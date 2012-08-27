package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class VersionMatcher
    extends AbstractArtifactMatcher<Object>
{
    public VersionMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "version" );
    }

}