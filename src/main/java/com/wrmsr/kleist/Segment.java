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
import com.google.common.collect.ImmutableMap;

import javax.annotation.concurrent.Immutable;

import java.time.Instant;
import java.util.Map;

@Immutable
public final class Segment
{
    private final Instant createdDatetime;
    private final Map<String, Split> splits;

    @JsonCreator
    public Segment(
            @JsonProperty("created_datetime") Instant createdDatetime,
            @JsonProperty("splits") Map<String, Split> splits)
    {
        this.createdDatetime = createdDatetime;
        this.splits = ImmutableMap.copyOf(splits);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("createdDatetime", createdDatetime)
                .add("splits", splits)
                .toString();
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
