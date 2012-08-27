package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Files;
import java.nio.file.Path;

import org.hamcrest.Description;

public class IsExecutableMatcher
    extends AbstractPathMatcher
{

    @Override
    protected boolean matchesSafely( Path item )
    {
        return Files.isExecutable( item );
    }

    public void describeTo( Description description )
    {
        description.appendText( "executable path" );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendValue( item );
        description.appendText( " is not executable!" );
    }

}
