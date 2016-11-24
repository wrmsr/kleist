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

import javax.annotation.concurrent.Immutable;

import java.time.Instant;

@Immutable
public final class IndexSegment
{
    private final String name;
    private final Instant createdDatetime;
    private final long sizeBytes;
    private final long numRows;
    private final long minSequence;
    private final long maxSequence;

    @JsonCreator
    public IndexSegment(
            @JsonProperty("name") String name,
            @JsonProperty("created_datetime") Instant createdDatetime,
            @JsonProperty("size_bytes") long sizeBytes,
            @JsonProperty("num_rows") long numRows,
            @JsonProperty("min_sequence") long minSequence,
            @JsonProperty("max_sequence") long maxSequence)
    {
        this.name = name;
        this.createdDatetime = createdDatetime;
        this.sizeBytes = sizeBytes;
        this.numRows = numRows;
        this.minSequence = minSequence;
        this.maxSequence = maxSequence;
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

    @JsonProperty("size_bytes")
    public long getSizeBytes()
    {
        return sizeBytes;
    }

    @JsonProperty("num_rows")
    public long getNumRows()
    {
        return numRows;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IndexSegment indexSegment = (IndexSegment) o;

        if (sizeBytes != indexSegment.sizeBytes) {
            return false;
        }
        if (numRows != indexSegment.numRows) {
            return false;
        }
        if (minSequence != indexSegment.minSequence) {
            return false;
        }
        if (maxSequence != indexSegment.maxSequence) {
            return false;
        }
        if (name != null ? !name.equals(indexSegment.name) : indexSegment.name != null) {
            return false;
        }
        if (createdDatetime != null ? !createdDatetime.equals(indexSegment.createdDatetime) : indexSegment.createdDatetime != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (createdDatetime != null ? createdDatetime.hashCode() : 0);
        result = 31 * result + (int) (sizeBytes ^ (sizeBytes >>> 32));
        result = 31 * result + (int) (numRows ^ (numRows >>> 32));
        result = 31 * result + (int) (minSequence ^ (minSequence >>> 32));
        result = 31 * result + (int) (maxSequence ^ (maxSequence >>> 32));
        return result;
    }
}
