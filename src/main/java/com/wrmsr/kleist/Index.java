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

import java.util.Comparator;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.wrmsr.kleist.util.collect.MoreCollectors.toLinkedHashMap;

@JsonPropertyOrder({
        "segments",
})
@Immutable
public final class Index
{
    private final Map<String, Segment> segments;

    @JsonCreator
    public Index(
            @JsonProperty("segments") Map<String, Segment> segments)
    {
        this.segments = segments.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().getGeneration())).collect(toLinkedHashMap());
        checkArgument(this.segments.values().stream().map(Segment::getGeneration).distinct().count() == segments.size());
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("segments", segments)
                .toString();
    }

    @JsonProperty("segments")
    public Map<String, Segment> getSegments()
    {
        return segments;
    }
}
