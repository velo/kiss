package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class ArtifactIdMatcher
    extends AbstractArtifactMatcher<Object>
{
    public ArtifactIdMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "artifactId" );
    }

}