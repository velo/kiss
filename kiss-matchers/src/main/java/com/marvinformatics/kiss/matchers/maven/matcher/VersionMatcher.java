package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>VersionMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class VersionMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for VersionMatcher.</p>
     */
    public VersionMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "version" );
    }

}
