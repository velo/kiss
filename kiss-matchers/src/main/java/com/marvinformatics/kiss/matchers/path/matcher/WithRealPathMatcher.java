package com.marvinformatics.kiss.matchers.path.matcher;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.marvinformatics.kissthrow.Throws;

/**
 * <p>WithRealPathMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class WithRealPathMatcher
    extends AbstractPathMatcher
{
    private final Matcher<String> path;

    private final LinkOption[] options;

    private String realPath;

    /**
     * <p>Constructor for WithRealPathMatcher.</p>
     */
    public WithRealPathMatcher( Matcher<String> path, LinkOption... options )
    {
        this.path = path;
        this.options = options;
    }

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( Path item )
    {
        try
        {
            realPath = item.toRealPath( options ).toString();
            return path.matches( realPath );
        }
        catch ( IOException e )
        {
            throw Throws.silentThrow( e );
        }
    }

    /** {@inheritDoc} */
    public void describeTo( Description description )
    {
        description.appendText( "with real path '" );
        description.appendDescriptionOf( path );
        description.appendText( "'" );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendText( " that path " );
        description.appendValue( item );
        description.appendText( " with real path " );
        description.appendDescriptionOf( path );
        description.appendText( ", not " + realPath );
    }
}
