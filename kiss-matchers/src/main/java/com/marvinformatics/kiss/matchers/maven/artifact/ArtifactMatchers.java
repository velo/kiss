package com.marvinformatics.kiss.matchers.maven.artifact;

import static org.hamcrest.Matchers.equalTo;

import org.apache.maven.artifact.Artifact;
import org.hamcrest.Matcher;

import com.marvinformatics.kiss.matchers.maven.matcher.ArtifactIdMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.ClassifierMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.GroupIdMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.ScopeMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.TypeMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.VersionMatcher;

/**
 * <p>
 * Matcher to check maven {@link Artifact}
 * </p>
 * Based on the original work I did for {@link http://www.flexmojos.net}
 *
 * @author marvin.froeder
 * @since 0.7
 */
public class ArtifactMatchers
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new ArtifactMatchers();
    }

    /**
     * <p>artifactId</p>
     */
    public static Matcher<? super Artifact> artifactId( Matcher<? extends String> artifactId )
    {
        return new ArtifactIdMatcher( artifactId );
    }

    /**
     * <p>artifactId</p>
     */
    public static Matcher<? super Artifact> artifactId( String artifactId )
    {
        return artifactId( equalTo( artifactId ) );
    }

    /**
     * <p>classifier</p>
     */
    public static Matcher<? super Artifact> classifier( Matcher<? extends String> classifier )
    {
        return new ClassifierMatcher( classifier );
    }

    /**
     * <p>classifier</p>
     */
    public static Matcher<? super Artifact> classifier( String classifier )
    {
        return classifier( equalTo( classifier ) );
    }

    /**
     * <p>groupId</p>
     */
    public static Matcher<? super Artifact> groupId( Matcher<? extends String> groupId )
    {
        return new GroupIdMatcher( groupId );
    }

    /**
     * <p>groupId</p>
     */
    public static Matcher<? super Artifact> groupId( String groupId )
    {
        return groupId( equalTo( groupId ) );
    }

    /**
     * <p>scope</p>
     */
    public static Matcher<? super Artifact> scope( Matcher<? extends String> scope )
    {
        return new ScopeMatcher( scope );
    }

    /**
     * <p>scope</p>
     */
    public static Matcher<? super Artifact> scope( String scope )
    {
        return scope( equalTo( scope ) );
    }

    /**
     * <p>type</p>
     */
    public static Matcher<? super Artifact> type( Matcher<? extends String> type )
    {
        return new TypeMatcher( type );
    }

    /**
     * <p>type</p>
     */
    public static Matcher<? super Artifact> type( String type )
    {
        return type( equalTo( type ) );
    }

    /**
     * <p>version</p>
     */
    public static Matcher<? super Artifact> version( Matcher<? extends String> versionMatcher )
    {
        return new VersionMatcher( versionMatcher );
    }

    /**
     * <p>version</p>
     */
    public static Matcher<? super Artifact> version( String version )
    {
        return version( equalTo( version ) );
    }

    private ArtifactMatchers()
    {
        super();
    }

}
