package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * <p>WithSizeMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class WithSizeMatcher
    extends AbstractFileMatcher
{
    private final Matcher<Long> size;

    long length;

    /**
     * <p>Constructor for WithSizeMatcher.</p>
     */
    public WithSizeMatcher( Matcher<Long> size )
    {
        this.size = size;
    }

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        length = item.length();
        return size.matches( length );
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( " that file " );
        description.appendValue( fileTested );
        description.appendText( " is sized " );
        description.appendDescriptionOf( size );
        description.appendText( ", not " + length );
    }
}
