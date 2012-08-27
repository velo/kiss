package com.marvinformatics.kiss.matchers.maven.matcher;

import java.lang.reflect.Method;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.marvinformatics.kissthrow.Throws;

public class AbstractArtifactMatcher<E>
    extends TypeSafeMatcher<E>
{
    private String element;

    private Matcher<? extends String> elementMatcher;

    public AbstractArtifactMatcher( Matcher<? extends String> elementMatcher, String element )
    {
        this.elementMatcher = elementMatcher;
        this.element = element;
    }

    public void describeTo( Description description )
    {
        description.appendText( "a artifact with " + element + " " ).appendDescriptionOf( elementMatcher );
    }

    @Override
    protected void describeMismatchSafely( E item, Description description )
    {
        description.appendText( " that artifact " );
        description.appendValue( item );
        description.appendText( " with " + element + " " );
        description.appendDescriptionOf( elementMatcher );
        description.appendText( ", not " + getValue( item ) );
    }

    protected final String getValue( E item )
    {
        String getterName = "get" + Character.toUpperCase( element.charAt( 0 ) ) + element.substring( 1 );
        try
        {
            Method method = item.getClass().getMethod( getterName );
            Object value = method.invoke( item );
            return (String) value;
        }
        catch ( Exception e )
        {
            throw Throws.silentThrow( e );
        }
    }

    @Override
    public boolean matchesSafely( E item )
    {
        return elementMatcher.matches( getValue( item ) );
    }
}