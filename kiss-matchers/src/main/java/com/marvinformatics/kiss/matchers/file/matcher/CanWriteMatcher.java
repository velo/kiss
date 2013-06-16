package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;

/**
 * <p>CanWriteMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class CanWriteMatcher
    extends AbstractFileMatcher
{
    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return item.canWrite();
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( " that file " );
        description.appendValue( fileTested );
        description.appendText( "is writable" );
    }
}
