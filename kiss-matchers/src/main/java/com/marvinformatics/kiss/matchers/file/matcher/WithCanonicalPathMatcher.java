package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;
import java.io.IOException;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.marvinformatics.kissthrow.Throws;

/**
 * <p>WithCanonicalPathMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class WithCanonicalPathMatcher
    extends AbstractFileMatcher
{
    private final Matcher<String> path;

    /**
     * <p>Constructor for WithCanonicalPathMatcher.</p>
     */
    public WithCanonicalPathMatcher( Matcher<String> path )
    {
        this.path = path;
    }

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        try
        {
            return path.matches( item.getCanonicalPath() );
        }
        catch ( IOException e )
        {
            throw Throws.silentThrow( e );
        }
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( "with canonical path '" );
        description.appendDescriptionOf( path );
        description.appendText( "'" );
    }
}
