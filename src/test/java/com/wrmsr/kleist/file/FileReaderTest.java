package com.wrmsr.kleist.file;

import com.wrmsr.kleist.Reader;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest
        extends TestCase
{
    public void testIndexReader()
            throws Exception
    {
        Path rootPath = Paths.get(getClass().getResource("/test_index/index.json").toURI()).getParent();
        Reader reader = new FileReader(rootPath);
        System.out.println(reader.readIndex());
    }
}
