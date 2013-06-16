package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Files;
import java.nio.file.Path;

import org.hamcrest.Description;

/**
 * <p>CanWriteMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class CanWriteMatcher
    extends AbstractPathMatcher
{

    @Override
    protected boolean matchesSafely( Path item )
    {
        return Files.isWritable( item );
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( "writable path" );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendValue( item );
        description.appendText( " is not writable!" );
    }

}
