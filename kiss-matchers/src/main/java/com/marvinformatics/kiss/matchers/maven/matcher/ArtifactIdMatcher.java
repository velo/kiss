package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>ArtifactIdMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class ArtifactIdMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for ArtifactIdMatcher.</p>
     */
    public ArtifactIdMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "artifactId" );
    }

}
