package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>ScopeMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class ScopeMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for ScopeMatcher.</p>
     */
    public ScopeMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "scope" );
    }

}
