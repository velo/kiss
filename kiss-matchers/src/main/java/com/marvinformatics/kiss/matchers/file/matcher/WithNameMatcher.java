package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class WithNameMatcher
    extends AbstractFileMatcher
{
    private final Matcher<String> name;

    public WithNameMatcher( Matcher<String> name )
    {
        this.name = name;
    }

    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return name.matches( item.getName() );
    }

    public void describeTo( Description description )
    {
        description.appendText( " that file " );
        description.appendValue( fileTested );
        description.appendText( " is named" );
        description.appendDescriptionOf( name );
        description.appendText( " not " );
        description.appendValue( fileTested.getName() );
    }
}