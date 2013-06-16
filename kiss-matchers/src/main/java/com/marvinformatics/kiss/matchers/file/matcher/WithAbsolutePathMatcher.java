package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * <p>WithAbsolutePathMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class WithAbsolutePathMatcher
    extends AbstractFileMatcher
{
    private final Matcher<String> path;

    /**
     * <p>Constructor for WithAbsolutePathMatcher.</p>
     */
    public WithAbsolutePathMatcher( Matcher<String> path )
    {
        this.path = path;
    }

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return path.matches( item.getAbsolutePath() );
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( "with absolute path '" );
        description.appendDescriptionOf( path );
        description.appendText( "'" );
    }
}
