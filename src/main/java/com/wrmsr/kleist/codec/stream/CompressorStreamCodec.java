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
package com.wrmsr.kleist.codec.stream;

import com.google.common.base.Throwables;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static java.util.Objects.requireNonNull;

public final class CompressorStreamCodec
        implements StreamCodec
{
    private final String name;

    public CompressorStreamCodec(String name)
    {
        this.name = requireNonNull(name);
    }

    @Override
    public InputStream decode(InputStream inputStream)
            throws IOException
    {
        try {
            return new CompressorStreamFactory().createCompressorInputStream(name, inputStream);
        }
        catch (CompressorException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public OutputStream encode(OutputStream outputStream)
            throws IOException
    {
        try {
            return new CompressorStreamFactory().createCompressorOutputStream(name, outputStream);
        }
        catch (CompressorException e) {
            throw Throwables.propagate(e);
        }
    }
}
