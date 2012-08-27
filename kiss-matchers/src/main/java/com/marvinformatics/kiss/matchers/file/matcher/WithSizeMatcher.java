package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class WithSizeMatcher
    extends AbstractFileMatcher
{
    private final Matcher<Long> size;

    long length;

    public WithSizeMatcher( Matcher<Long> size )
    {
        this.size = size;
    }

    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        length = item.length();
        return size.matches( length );
    }

    public void describeTo( Description description )
    {
        description.appendText( " that file " );
        description.appendValue( fileTested );
        description.appendText( " is sized " );
        description.appendDescriptionOf( size );
        description.appendText( ", not " + length );
    }
}