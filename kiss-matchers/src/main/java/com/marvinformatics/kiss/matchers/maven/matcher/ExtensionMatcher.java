package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class ExtensionMatcher
    extends AbstractArtifactMatcher<Object>
{
    public ExtensionMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "extension" );
    }

}