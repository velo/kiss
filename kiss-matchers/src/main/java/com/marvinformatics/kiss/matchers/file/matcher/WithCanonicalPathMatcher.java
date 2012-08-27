package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;
import java.io.IOException;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.marvinformatics.kissthrow.Throws;

public class WithCanonicalPathMatcher
    extends AbstractFileMatcher
{
    private final Matcher<String> path;

    public WithCanonicalPathMatcher( Matcher<String> path )
    {
        this.path = path;
    }

    @Override
    public boolean matchesSafely( File item )
    {
        try
        {
            return path.matches( item.getCanonicalPath() );
        }
        catch ( IOException e )
        {
            throw Throws.silentThrow( e );
        }
    }

    public void describeTo( Description description )
    {
        description.appendText( "with canonical path '" );
        description.appendDescriptionOf( path );
        description.appendText( "'" );
    }
}