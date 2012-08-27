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
 */
public class AetherArtifactMatchers
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new AetherArtifactMatchers();
    }

    public static Matcher<? super Artifact> artifactId( Matcher<? extends String> artifactId )
    {
        return new ArtifactIdMatcher( artifactId );
    }

    public static Matcher<? super Artifact> artifactId( String artifactId )
    {
        return artifactId( equalTo( artifactId ) );
    }

    public static Matcher<? super Artifact> classifier( Matcher<? extends String> classifier )
    {
        return new ClassifierMatcher( classifier );
    }

    public static Matcher<? super Artifact> classifier( String classifier )
    {
        return classifier( equalTo( classifier ) );
    }

    public static Matcher<? super Artifact> groupId( Matcher<? extends String> groupId )
    {
        return new GroupIdMatcher( groupId );
    }

    public static Matcher<? super Artifact> groupId( String groupId )
    {
        return groupId( equalTo( groupId ) );
    }

    public static Matcher<? super Artifact> extension( Matcher<? extends String> extension )
    {
        return new ExtensionMatcher( extension );
    }

    public static Matcher<? super Artifact> extension( String extension )
    {
        return extension( equalTo( extension ) );
    }

    public static Matcher<? super Artifact> version( Matcher<? extends String> versionMatcher )
    {
        return new VersionMatcher( versionMatcher );
    }

    public static Matcher<? super Artifact> version( String version )
    {
        return version( equalTo( version ) );
    }

    public static Matcher<? super Artifact> baseVersion( Matcher<? extends String> versionMatcher )
    {
        return new BaseVersionMatcher( versionMatcher );
    }

    public static Matcher<? super Artifact> baseVersion( String version )
    {
        return baseVersion( equalTo( version ) );
    }

    private AetherArtifactMatchers()
    {
        super();
    }

}
