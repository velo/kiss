package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>ClassifierMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class ClassifierMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for ClassifierMatcher.</p>
     */
    public ClassifierMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "classifier" );
    }

}
