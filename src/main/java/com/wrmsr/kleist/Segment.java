/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wrmsr.kleist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;

import javax.annotation.concurrent.Immutable;

import java.time.Instant;
import java.util.Comparator;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.wrmsr.kleist.util.Itertools.zip;
import static com.wrmsr.kleist.util.collect.MoreCollectors.toLinkedHashMap;
import static java.util.Objects.requireNonNull;

@JsonPropertyOrder({
        "generation",
        "created_datetime",
        "splits",
})
@Immutable
public final class Segment
{
    private final long generation;
    private final Instant createdDatetime;
    private final Map<String, Split> splits;

    @JsonCreator
    public Segment(
            @JsonProperty("generation") long generation,
            @JsonProperty("created_datetime") Instant createdDatetime,
            @JsonProperty("splits") Map<String, Split> splits)
    {
        checkArgument(generation >= 0);
        this.generation = generation;
        this.createdDatetime = requireNonNull(createdDatetime);
        this.splits = splits.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().getMinSequence())).collect(toLinkedHashMap());
        checkArgument(zip(this.splits.values().stream(), this.splits.values().stream().skip(1)).allMatch(pair -> pair.getLeft().getMaxSequence() < pair.getRight().getMinSequence()));
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("generation", generation)
                .add("createdDatetime", createdDatetime)
                .add("splits", splits)
                .toString();
    }

    @JsonProperty("generation")
    public long getGeneration()
    {
        return generation;
    }

    @JsonProperty("created_datetime")
    public Instant getCreatedDatetime()
    {
        return createdDatetime;
    }

    @JsonProperty("splits")
    public Map<String, Split> getSplits()
    {
        return splits;
    }
}
