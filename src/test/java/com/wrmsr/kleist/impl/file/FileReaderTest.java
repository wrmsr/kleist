package com.wrmsr.kleist.impl.file;

import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.Paths;

public class FileReaderTest
        extends TestCase
{
    public void testIndexReader()
            throws IOException
    {
        new FileReader(Paths.get("/Users/will/barf"));
    }
}