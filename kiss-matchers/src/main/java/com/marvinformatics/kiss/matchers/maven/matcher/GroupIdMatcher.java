package com.marvinformatics.kiss.matchers.maven.matcher;

import org.hamcrest.Matcher;

/**
 * <p>GroupIdMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public class GroupIdMatcher
    extends AbstractArtifactMatcher<Object>
{
    /**
     * <p>Constructor for GroupIdMatcher.</p>
     */
    public GroupIdMatcher( Matcher<? extends String> elementMatcher )
    {
        super( elementMatcher, "groupId" );
    }

}
