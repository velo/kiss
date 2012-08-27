package com.marvinformatics.kiss.matchers.path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PathMatchersTest
{

    private Path REAL_FILE;

    private Path REAL_DIR;

    private Path NON_EXISTING_FILE;

    @BeforeMethod
    public void setupFiles()
        throws Exception
    {
        REAL_FILE = Paths.get( "pom.xml" );
        assertTrue( Files.isRegularFile( REAL_FILE ) );
        REAL_DIR = Paths.get( "." );
        assertTrue( Files.isDirectory( REAL_DIR ) );
        NON_EXISTING_FILE = Paths.get( ".", "DOESNOTEXIST" );
        assertFalse( Files.exists( NON_EXISTING_FILE ) );
    }

    @Test
    public void notExists()
    {
        assertThat( NON_EXISTING_FILE, not( PathMatchers.exists() ) );
    }

    @Test
    public void exists()
    {
        assertThat( REAL_DIR, PathMatchers.exists() );
    }

    @Test
    public void notIsRegularFile()
    {
        assertThat( REAL_DIR, not( PathMatchers.isRegularFile() ) );
    }

    @Test
    public void isRegularFilePath()
    {
        assertThat( REAL_FILE, PathMatchers.isRegularFile() );
    }

    @Test
    public void notIsDirectory()
    {
        assertThat( REAL_FILE, not( PathMatchers.isDirectory() ) );
    }

    @Test
    public void isDirectory()
    {
        assertThat( REAL_DIR, PathMatchers.isDirectory() );
    }

    @Test
    public void notCanRead()
    {
        assertThat( NON_EXISTING_FILE, not( PathMatchers.canRead() ) );
    }

    @Test
    public void canRead()
    {
        assertThat( REAL_FILE, PathMatchers.canRead() );
    }

    @Test
    public void notCanWrite()
    {
        assertThat( NON_EXISTING_FILE, not( PathMatchers.canWrite() ) );
    }

    @Test
    public void canWrite()
    {
        assertThat( REAL_FILE, PathMatchers.canWrite() );
    }

}
