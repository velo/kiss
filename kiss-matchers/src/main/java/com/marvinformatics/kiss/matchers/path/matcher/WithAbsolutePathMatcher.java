package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Path;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * <p>WithAbsolutePathMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class WithAbsolutePathMatcher
    extends AbstractPathMatcher
{
    private final Matcher<String> path;

    private String absolutePath;

    /**
     * <p>Constructor for WithAbsolutePathMatcher.</p>
     */
    public WithAbsolutePathMatcher( Matcher<String> path )
    {
        this.path = path;
    }

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( Path item )
    {
        absolutePath = item.toAbsolutePath().toString();
        return path.matches( absolutePath );
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( "with absolute path " );
        description.appendDescriptionOf( path );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendText( " that path " );
        description.appendValue( item );
        description.appendText( " with absolute path " );
        description.appendDescriptionOf( path );
        description.appendText( ", not " + absolutePath );
    }
}
