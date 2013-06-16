package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * <p>WithNameMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class WithNameMatcher
    extends AbstractFileMatcher
{
    private final Matcher<String> name;

    /**
     * <p>Constructor for WithNameMatcher.</p>
     */
    public WithNameMatcher( Matcher<String> name )
    {
        this.name = name;
    }

    /** {@inheritDoc} */
    @Override
    public boolean matchesSafely( File item )
    {
        fileTested = item;
        return name.matches( item.getName() );
    }

    /** {@inheritDoc} */
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
