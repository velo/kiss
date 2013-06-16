package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;

/**
 * <p>ExistsMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class ExistsMatcher
    extends AbstractFileMatcher
{

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        return item.exists();
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( "to exists" );
    }

    @Override
    protected void describeMismatchSafely( File item, Description description )
    {
        description.appendValue( item );
        description.appendText( " not found!" );
    }
}
