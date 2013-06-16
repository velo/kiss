package com.marvinformatics.kiss.matchers.path.matcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.marvinformatics.kissthrow.Throws;

/**
 * <p>WithSizeMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class WithSizeMatcher
    extends AbstractPathMatcher
{
    private final Matcher<Long> size;

    private long length;

    /**
     * <p>Constructor for WithSizeMatcher.</p>
     */
    public WithSizeMatcher( Matcher<Long> size )
    {
        this.size = size;
    }

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( Path item )
    {
        try
        {
            this.length = Files.size( item );
            return size.matches( length );
        }
        catch ( IOException e )
        {
            throw Throws.silentThrow( e );
        }
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( " file to have dize " );
        description.appendDescriptionOf( size );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendText( " that file " );
        description.appendValue( item );
        description.appendText( " is sized " );
        description.appendDescriptionOf( size );
        description.appendText( ", not " + length );
    }
}
