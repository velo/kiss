package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class TypeMatcher
    extends AbstractArtifactMatcher<Object>
{
    public TypeMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "type" );
    }

}