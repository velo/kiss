package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Path;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class WithAbsolutePathMatcher
    extends AbstractPathMatcher
{
    private final Matcher<String> path;

    private String absolutePath;

    public WithAbsolutePathMatcher( Matcher<String> path )
    {
        this.path = path;
    }

    @Override
    public boolean matchesSafely( Path item )
    {
        absolutePath = item.toAbsolutePath().toString();
        return path.matches( absolutePath );
    }

    public void describeTo( Description description )
    {
        description.appendText( "with absolute path " );
        description.appendDescriptionOf( path );
    }

    @Override
    protected void describeMismatchSafely( Path item, Description description )
    {
        description.appendText( " that path " );
        description.appendValue( item );
        description.appendText( " with absolute path " );
        description.appendDescriptionOf( path );
        description.appendText( ", not " + absolutePath );
    }
}