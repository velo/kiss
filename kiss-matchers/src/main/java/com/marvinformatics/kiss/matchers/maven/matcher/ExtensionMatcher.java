package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>ExtensionMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class ExtensionMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for ExtensionMatcher.</p>
     */
    public ExtensionMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "extension" );
    }

}
