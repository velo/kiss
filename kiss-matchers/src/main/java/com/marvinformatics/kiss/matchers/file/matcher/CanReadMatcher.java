package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;

public final class CanReadMatcher
    extends AbstractFileMatcher
{
    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return item.canRead();
    }

    public void describeTo( Description description )
    {
        description.appendText( " that file " );
        description.appendValue( fileTested );
        description.appendText( "is readable" );
    }
}