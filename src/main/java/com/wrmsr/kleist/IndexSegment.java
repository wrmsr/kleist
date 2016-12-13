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

import javax.annotation.concurrent.Immutable;

import java.time.Instant;
import java.util.List;

@Immutable
public final class IndexSegment
{
    private final String name;
    private final Instant createdDatetime;
    private final List<IndexSegmentSplit> splits;

    @JsonCreator
    public IndexSegment(
            @JsonProperty("name") String name,
            @JsonProperty("created_datetime") Instant createdDatetime,
            @JsonProperty("splits") List<IndexSegmentSplit> splits
    {
        this.name = name;
        this.createdDatetime = createdDatetime;
        this.splits = splits;
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
    public List<IndexSegmentSplit> getSplits()
    {
        return splits;
    }
}
