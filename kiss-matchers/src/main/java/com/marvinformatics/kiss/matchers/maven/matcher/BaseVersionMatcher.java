package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class BaseVersionMatcher
    extends AbstractArtifactMatcher<Object>
{
    public BaseVersionMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "baseVersion" );
    }

}