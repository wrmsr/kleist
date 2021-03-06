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
package com.wrmsr.kleist.codec.block;

import com.google.common.io.ByteStreams;
import com.wrmsr.kleist.codec.stream.StreamCodec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static java.util.Objects.requireNonNull;

public final class StreamBlockCodec
        implements BlockCodec
{
    private final StreamCodec streamCodec;

    public StreamBlockCodec(StreamCodec streamCodec)
    {
        this.streamCodec = requireNonNull(streamCodec);
    }

    @Override
    public byte[] decode(byte[] block)
            throws IOException
    {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(block);
                InputStream inputStream = streamCodec.decode(byteArrayInputStream)) {
            return ByteStreams.toByteArray(inputStream);
        }
    }

    @Override
    public byte[] encode(byte[] block)
            throws IOException
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(block.length);
        try {
            try (OutputStream outputStream = streamCodec.encode(byteArrayOutputStream)) {
                outputStream.write(block);
            }
        }
        finally {
            byteArrayOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
