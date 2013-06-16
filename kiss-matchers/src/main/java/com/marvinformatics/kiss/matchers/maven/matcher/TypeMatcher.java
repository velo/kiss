package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>TypeMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class TypeMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for TypeMatcher.</p>
     */
    public TypeMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "type" );
    }

}
