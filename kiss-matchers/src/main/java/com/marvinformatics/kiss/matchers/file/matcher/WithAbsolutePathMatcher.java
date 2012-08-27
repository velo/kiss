package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class WithAbsolutePathMatcher
    extends AbstractFileMatcher
{
    private final Matcher<String> path;

    public WithAbsolutePathMatcher( Matcher<String> path )
    {
        this.path = path;
    }

    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return path.matches( item.getAbsolutePath() );
    }

    public void describeTo( Description description )
    {
        description.appendText( "with absolute path '" );
        description.appendDescriptionOf( path );
        description.appendText( "'" );
    }
}