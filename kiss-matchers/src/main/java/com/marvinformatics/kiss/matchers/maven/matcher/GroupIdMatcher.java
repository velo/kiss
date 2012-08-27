package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

public class GroupIdMatcher
    extends AbstractArtifactMatcher<Object>
{
    public GroupIdMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "groupId" );
    }

}