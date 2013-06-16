package com.marvinformatics.kiss.matchers.maven.aether;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.sonatype.aether.artifact.Artifact;

import com.marvinformatics.kiss.matchers.maven.matcher.ArtifactIdMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.BaseVersionMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.ClassifierMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.ExtensionMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.GroupIdMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.VersionMatcher;

/**
 * <p>
 * Matcher to check aether {@link Artifact}
 * </p>
 *
 * @author marvin.froeder
 * @since 0.7
 */
public class AetherArtifactMatchers
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new AetherArtifactMatchers();
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
     * <p>extension</p>
     */
    public static Matcher<? super Artifact> extension( Matcher<? extends String> extension )
    {
        return new ExtensionMatcher( extension );
    }

    /**
     * <p>extension</p>
     */
    public static Matcher<? super Artifact> extension( String extension )
    {
        return extension( equalTo( extension ) );
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

    /**
     * <p>baseVersion</p>
     */
    public static Matcher<? super Artifact> baseVersion( Matcher<? extends String> versionMatcher )
    {
        return new BaseVersionMatcher( versionMatcher );
    }

    /**
     * <p>baseVersion</p>
     */
    public static Matcher<? super Artifact> baseVersion( String version )
    {
        return baseVersion( equalTo( version ) );
    }

    private AetherArtifactMatchers()
    {
        super();
    }

}
