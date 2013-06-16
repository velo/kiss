package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.hamcrest.Description;

/**
 * <p>IsRegularFileMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class IsRegularFileMatcher
    extends AbstractPathMatcher
{

    private LinkOption[] options;

    /**
     * <p>Constructor for IsRegularFileMatcher.</p>
     */
    public IsRegularFileMatcher( LinkOption... options )
    {
        super();
        this.options = options;
    }

    @Override
    protected boolean matchesSafely( Path item )
    {
        return Files.isRegularFile( item, options );
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( "to be a regular file" );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendValue( item );
        description.appendText( " ain't a regular file!" );
    }
}
