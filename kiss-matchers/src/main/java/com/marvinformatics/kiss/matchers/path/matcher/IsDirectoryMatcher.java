package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.hamcrest.Description;

public class IsDirectoryMatcher
    extends AbstractPathMatcher
{

    private LinkOption[] options;

    public IsDirectoryMatcher( LinkOption... options )
    {
        super();
        this.options = options;
    }

    @Override
    protected boolean matchesSafely( Path item )
    {
        return Files.isDirectory( item, options );
    }

    public void describeTo( Description description )
    {
        description.appendText( "to be a directory" );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendValue( item );
        description.appendText( " ain't a directory!" );
    }

}
