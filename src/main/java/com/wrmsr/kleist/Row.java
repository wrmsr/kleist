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

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

@Immutable
public final class Row
{
    private final long sequence;
    private final byte[] data;

    @JsonCreator
    public Row(
            @JsonProperty("sequence") long sequence,
            @JsonProperty("data") byte[] data)
    {
        checkArgument(sequence >= 0);
        this.sequence = sequence;
        this.data = requireNonNull(data);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("sequence", sequence)
                .add("data", data)
                .toString();
    }

    @JsonProperty("sequence")
    public long getSequence()
    {
        return sequence;
    }

    @JsonProperty("data")
    public byte[] getData()
    {
        return data;
    }
}
