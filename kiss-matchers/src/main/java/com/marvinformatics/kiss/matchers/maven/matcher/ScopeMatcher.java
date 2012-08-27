package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class ScopeMatcher
    extends AbstractArtifactMatcher<Object>
{
    public ScopeMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "scope" );
    }

}