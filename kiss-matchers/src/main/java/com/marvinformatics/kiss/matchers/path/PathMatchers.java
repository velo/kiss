package com.marvinformatics.kiss.matchers.path;

import static org.hamcrest.Matchers.equalTo;

import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.marvinformatics.kiss.matchers.path.matcher.CanReadMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.CanWriteMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.ExistsMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.IsDirectoryMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.IsExecutableMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.IsHiddenMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.IsRegularFileMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.WithAbsolutePathMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.WithNameMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.WithRealPathMatcher;
import com.marvinformatics.kiss.matchers.path.matcher.WithSizeMatcher;

/**
 * <p>
 * Set of matchers to handle {@link java.nio.file.Path}!
 * </p>
 *
 * @author marvin.froeder
 * @since 0.7
 */
public final class PathMatchers
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new PathMatchers();
    }

    /**
     * <p>canRead</p>
     */
    public static Matcher<Path> canRead()
    {
        return new CanReadMatcher();
    }

    /**
     * <p>canWrite</p>
     */
    public static Matcher<Path> canWrite()
    {
        return new CanWriteMatcher();
    }

    /**
     * <p>exists</p>
     */
    public static Matcher<Path> exists( LinkOption... options )
    {
        return new ExistsMatcher( options );
    }

    /**
     * <p>isDirectory</p>
     */
    public static Matcher<Path> isDirectory( LinkOption... options )
    {
        return new IsDirectoryMatcher( options );
    }

    /**
     * <p>isRegularFile</p>
     */
    public static Matcher<Path> isRegularFile( LinkOption... options )
    {
        return new IsRegularFileMatcher( options );
    }

    /**
     * <p>isHidden</p>
     */
    public static Matcher<Path> isHidden()
    {
        return new IsHiddenMatcher();
    }

    /**
     * <p>isExecutable</p>
     */
    public static Matcher<Path> isExecutable()
    {
        return new IsExecutableMatcher();
    }

    /**
     * <p>withAbsolutePath</p>
     */
    public static Matcher<Path> withAbsolutePath( final Matcher<String> path )
    {
        return new WithAbsolutePathMatcher( path );
    }

    /**
     * <p>withRealPath</p>
     */
    public static Matcher<Path> withRealPath( final Matcher<String> path )
    {
        return new WithRealPathMatcher( path );
    }

    /**
     * <p>withName</p>
     */
    public static Matcher<Path> withName( final Matcher<String> name )
    {
        return new WithNameMatcher( name );
    }

    /**
     * <p>withName</p>
     */
    public static Matcher<Path> withName( final String name )
    {
        return withName( equalTo( name ) );
    }

    /**
     * <p>withSize</p>
     */
    public static Matcher<Path> withSize( long size )
    {
        return withSize( Matchers.equalTo( size ) );
    }

    /**
     * <p>withSize</p>
     */
    public static Matcher<Path> withSize( int size )
    {
        return withSize( (long) size );
    }

    /**
     * <p>withSize</p>
     */
    public static Matcher<Path> withSize( final Matcher<Long> size )
    {
        return new WithSizeMatcher( size );
    }

    private PathMatchers()
    {
        super();
    }

}
