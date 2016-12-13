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
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import javax.annotation.concurrent.Immutable;

import java.time.Instant;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Immutable
public final class Segment
{
    private final String name;
    private final Instant createdDatetime;
    private final List<Split> splits;

    @JsonCreator
    public Segment(
            @JsonProperty("name") String name,
            @JsonProperty("created_datetime") Instant createdDatetime,
            @JsonProperty("splits") List<Split> splits)
    {
        this.name = requireNonNull(name);
        this.createdDatetime = createdDatetime;
        this.splits = ImmutableList.copyOf(splits);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("createdDatetime", createdDatetime)
                .add("splits", splits)
                .toString();
    }

    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    @JsonProperty("created_datetime")
    public Instant getCreatedDatetime()
    {
        return createdDatetime;
    }

    @JsonProperty("splits")
    public List<Split> getSplits()
    {
        return splits;
    }
}
