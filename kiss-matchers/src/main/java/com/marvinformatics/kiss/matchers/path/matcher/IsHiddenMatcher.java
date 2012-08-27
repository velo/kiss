package com.marvinformatics.kiss.matchers.path.matcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.hamcrest.Description;

import com.marvinformatics.kissthrow.Throws;

public class IsHiddenMatcher
    extends AbstractPathMatcher
{

    @Override
    protected boolean matchesSafely( Path item )
    {
        try
        {
            return Files.isHidden( item );
        }
        catch ( IOException e )
        {
            throw Throws.silentThrow( e );
        }
    }

    public void describeTo( Description description )
    {
        description.appendText( "hidden path" );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendValue( item );
        description.appendText( " is not hidden!" );
    }

}
