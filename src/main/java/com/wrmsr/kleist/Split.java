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

@Immutable
public final class Split
{
    private final String name;
    private final long sizeBytes;
    private final long numRecords;
    private final long minSequence;
    private final long maxSequence;

    @JsonCreator
    public Split(
            @JsonProperty("name") String name,
            @JsonProperty("size_bytes") long sizeBytes,
            @JsonProperty("num_records") long numRecords,
            @JsonProperty("min_sequence") long minSequence,
            @JsonProperty("max_sequence") long maxSequence)
    {
        this.name = name;
        this.sizeBytes = sizeBytes;
        this.numRecords = numRecords;
        this.minSequence = minSequence;
        this.maxSequence = maxSequence;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("sizeBytes", sizeBytes)
                .add("numRecords", numRecords)
                .add("minSequence", minSequence)
                .add("maxSequence", maxSequence)
                .toString();
    }

    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    @JsonProperty("size_bytes")
    public long getSizeBytes()
    {
        return sizeBytes;
    }

    @JsonProperty("num_records")
    public long getNumRecords()
    {
        return numRecords;
    }

    @JsonProperty("min_sequence")
    public long getMinSequence()
    {
        return minSequence;
    }

    @JsonProperty("max_sequence")
    public long getMaxSequence()
    {
        return maxSequence;
    }
}
