package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class ClassifierMatcher
    extends AbstractArtifactMatcher<Object>
{
    public ClassifierMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "classifier" );
    }

}