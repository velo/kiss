package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;

/**
 * <p>CanReadMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public final class CanReadMatcher
    extends AbstractFileMatcher
{
    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return item.canRead();
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( " that file " );
        description.appendValue( fileTested );
        description.appendText( "is readable" );
    }
}
