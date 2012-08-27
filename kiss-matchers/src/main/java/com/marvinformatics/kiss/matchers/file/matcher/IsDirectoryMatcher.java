package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;

public class IsDirectoryMatcher
    extends AbstractFileMatcher
{

    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return item.isDirectory();
    }

    public void describeTo( Description description )
    {
        description.appendText( " that " );
        description.appendValue( fileTested );
        description.appendText( "is a directory" );
    }
}