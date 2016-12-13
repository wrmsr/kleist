package com.wrmsr.kleist.impl.file;

import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.Paths;

public class FileIndexReaderTest
        extends TestCase
{
    public void testIndexReader()
            throws IOException
    {
        new FileIndexReader(Paths.get("/Users/will/barf"));
    }
}