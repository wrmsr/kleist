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
package com.wrmsr.kleist.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wrmsr.kleist.Index;
import com.wrmsr.kleist.Reader;
import com.wrmsr.kleist.RecordIterator;

import javax.annotation.concurrent.Immutable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;

@Immutable
public final class FileReader
        implements Reader
{
    private final Path rootPath;
    private final ObjectMapper objectMapper;

    public FileReader(Path rootPath, ObjectMapper objectMapper)
    {
        this.rootPath = requireNonNull(rootPath);
        this.objectMapper = requireNonNull(objectMapper);
    }

    public FileReader(Path rootPath)
    {
        this(rootPath, new ObjectMapper());
    }

    @Override
    public Index readIndex()
            throws IOException
    {
        return requireNonNull(objectMapper.readValue(Files.readAllBytes(Paths.get(rootPath.toString(), "index.json")), Index.class));
    }

    @Override
    public RecordIterator getRecordIterator(String segmentName, String splitName)
            throws IOException
    {
        return null;
    }
}
