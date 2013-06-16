package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;

/**
 * <p>IsFileMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class IsFileMatcher
    extends AbstractFileMatcher
{

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return item.isFile();
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( " that " );
        description.appendValue( fileTested );
        description.appendText( "is a file" );
    }
}
