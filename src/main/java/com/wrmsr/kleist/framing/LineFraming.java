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
package com.wrmsr.kleist.framing;

import com.wrmsr.kleist.BlockIterator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LineFraming
    implements Framing
{
    @Override
    public BlockIterator decode(InputStream inputStream)
            throws IOException
    {
        return null;
    }

    @Override
    public OutputStream encode(BlockIterator blockIterator)
            throws IOException
    {
        return null;
    }
}
