package com.marvinformatics.kiss.matchers.file;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.marvinformatics.kiss.matchers.file.matcher.CanReadMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.CanWriteMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.ExistsMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.IsDirectoryMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.IsFileMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.WithAbsolutePathMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.WithCanonicalPathMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.WithNameMatcher;
import com.marvinformatics.kiss.matchers.file.matcher.WithSizeMatcher;

/**
 * <p>
 * Set of matchers to handle {@link java.io.File}!
 * </p>
 * Based on: http://www.time4tea.net/wiki/display/MAIN/Testing+Files+with+Hamcrest <BR>
 * © time4tea technology ltd 2007 - Freely redistributable as long as source is acknowledged (CC BY 3.0)
 * 
 * @author marvin.froeder
 */
public final class FileMatchers
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new FileMatchers();
    }

    public static Matcher<File> canRead()
    {
        return new CanReadMatcher();
    }

    public static Matcher<File> canWrite()
    {
        return new CanWriteMatcher();
    }

    public static Matcher<File> exists()
    {
        return new ExistsMatcher();
    }

    public static Matcher<File> isDirectory()
    {
        return new IsDirectoryMatcher();
    }

    public static Matcher<File> isFile()
    {
        return new IsFileMatcher();
    }

    public static Matcher<File> withAbsolutePath( final Matcher<String> path )
    {
        return new WithAbsolutePathMatcher( path );
    }

    public static Matcher<File> withCanonicalPath( final Matcher<String> path )
    {
        return new WithCanonicalPathMatcher( path );
    }

    public static Matcher<File> withName( final Matcher<String> name )
    {
        return new WithNameMatcher( name );
    }

    public static Matcher<File> withName( final String name )
    {
        return withName( equalTo( name ) );
    }

    public static Matcher<File> withSize( int size )
    {
        return withSize( (long) size );
    }

    public static Matcher<File> withSize( long size )
    {
        return withSize( Matchers.equalTo( size ) );
    }

    public static Matcher<File> withSize( final Matcher<Long> size )
    {
        return new WithSizeMatcher( size );
    }

    private FileMatchers()
    {
        super();
    }

}