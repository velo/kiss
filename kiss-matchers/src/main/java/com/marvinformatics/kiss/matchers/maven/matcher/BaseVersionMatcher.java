package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>BaseVersionMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class BaseVersionMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for BaseVersionMatcher.</p>
     */
    public BaseVersionMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "baseVersion" );
    }

}
