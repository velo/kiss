package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.hamcrest.Description;

public class ExistsMatcher
    extends AbstractPathMatcher
{

    private LinkOption[] options;

    public ExistsMatcher( LinkOption... options )
    {
        super();
        this.options = options;
    }

    @Override
    protected boolean matchesSafely( Path item )
    {
        return Files.exists( item, options );
    }

    public void describeTo( Description description )
    {
        description.appendText( "to exists" );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendValue( item );
        description.appendText( " not found!" );
    }

}
