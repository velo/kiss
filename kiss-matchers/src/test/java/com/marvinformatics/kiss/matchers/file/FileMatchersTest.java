package com.marvinformatics.kiss.matchers.file;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileMatchersTest
{

    private static File REAL_FILE;

    private static File REAL_DIR;

    private static File NON_EXISTING_FILE;

    @BeforeMethod
    public void setupFiles()
        throws Exception
    {
        REAL_FILE = new File( "pom.xml" );
        assertThat( REAL_FILE.isFile(), is( true ) );
        assertThat( REAL_FILE.canRead(), is( true ) );
        assertThat( REAL_FILE.canWrite(), is( true ) );

        REAL_DIR = new File( "." );
        assertThat( REAL_DIR.isDirectory(), is( true ) );
        NON_EXISTING_FILE = new File( REAL_DIR, "/DOESNOTEXIST" );
        assertThat( NON_EXISTING_FILE.exists(), is( false ) );
    }

    @Test
    public void isDirectoryMatchesDirectory()
    {
        assertThat( REAL_DIR, FileMatchers.isDirectory() );
    }

    @Test
    public void isDirectoryDoesNotMatchFile()
    {
        assertThat( REAL_FILE, not( FileMatchers.isDirectory() ) );
    }

    @Test
    public void isFileDoesNotMatchDirectory()
    {
        assertThat( REAL_DIR, not( FileMatchers.isFile() ) );
    }

    @Test
    public void isFileMatchesFile()
    {
        assertThat( REAL_FILE, FileMatchers.isFile() );
    }

    @Test
    public void existsFileThatDoesNotExist()
    {
        assertThat( NON_EXISTING_FILE, not( FileMatchers.exists() ) );
    }

    @Test
    public void existsDirThatExists()
    {
        assertThat( REAL_DIR, FileMatchers.exists() );
    }

    @Test
    public void writableMatchesWritable()
    {
        assertThat( REAL_FILE, FileMatchers.canWrite() );
    }

    @Test
    public void readableMatchesReadable()
    {
        assertThat( REAL_FILE, FileMatchers.canRead() );
    }

    @Test
    public void named()
    {
        assertThat( REAL_FILE, FileMatchers.withName( "pom.xml" ) );
    }

    @Test
    public void withCanonicalPath()
    {
        assertThat( REAL_FILE, not( FileMatchers.withCanonicalPath( equalTo( "pom.xml" ) ) ) );
    }

    @Test
    public void withAbsolutePath()
    {
        assertThat( REAL_FILE, not( FileMatchers.withAbsolutePath( equalTo( "pom.xml" ) ) ) );
    }

    @Test
    public void sizedWithMatcher()
    {
        assertThat( REAL_FILE, FileMatchers.withSize( greaterThan( 100L ) ) );
    }

    @Test
    public void sizedStandalone()
    {
        File sizedFile = new File( REAL_DIR, "src/test/resources/file.txt" );
        assertThat( sizedFile, FileMatchers.exists() );
        assertThat( sizedFile, FileMatchers.withSize( 3 ) );
    }

}
