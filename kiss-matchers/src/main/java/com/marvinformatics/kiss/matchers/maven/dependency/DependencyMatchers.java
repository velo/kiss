package com.marvinformatics.kiss.matchers.maven.dependency;

import static org.hamcrest.Matchers.equalTo;

import org.apache.maven.model.Dependency;
import org.hamcrest.Matcher;

import com.marvinformatics.kiss.matchers.maven.matcher.ArtifactIdMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.ClassifierMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.GroupIdMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.ScopeMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.TypeMatcher;
import com.marvinformatics.kiss.matchers.maven.matcher.VersionMatcher;

/**
 * <p>
 * Matcher to check maven {@link Dependency}
 * </p>
 * Based on the original work I did for Flexmojos
 *
 * @author marvin.froeder
 * @since 0.7
 */
public class DependencyMatchers
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new DependencyMatchers();
    }

    /**
     * <p>artifactId</p>
     */
    public static Matcher<? super Dependency> artifactId( Matcher<? extends String> artifactId )
    {
        return new ArtifactIdMatcher( artifactId );
    }

    /**
     * <p>artifactId</p>
     */
    public static Matcher<? super Dependency> artifactId( String artifactId )
    {
        return artifactId( equalTo( artifactId ) );
    }

    /**
     * <p>classifier</p>
     */
    public static Matcher<? super Dependency> classifier( Matcher<? extends String> classifier )
    {
        return new ClassifierMatcher( classifier );
    }

    /**
     * <p>classifier</p>
     */
    public static Matcher<? super Dependency> classifier( String classifier )
    {
        return classifier( equalTo( classifier ) );
    }

    /**
     * <p>groupId</p>
     */
    public static Matcher<? super Dependency> groupId( Matcher<? extends String> groupId )
    {
        return new GroupIdMatcher( groupId );
    }

    /**
     * <p>groupId</p>
     */
    public static Matcher<? super Dependency> groupId( String groupId )
    {
        return groupId( equalTo( groupId ) );
    }

    /**
     * <p>scope</p>
     */
    public static Matcher<? super Dependency> scope( Matcher<? extends String> scope )
    {
        return new ScopeMatcher( scope );
    }

    /**
     * <p>scope</p>
     */
    public static Matcher<? super Dependency> scope( String scope )
    {
        return scope( equalTo( scope ) );
    }

    /**
     * <p>type</p>
     */
    public static Matcher<? super Dependency> type( Matcher<? extends String> type )
    {
        return new TypeMatcher( type );
    }

    /**
     * <p>type</p>
     */
    public static Matcher<? super Dependency> type( String type )
    {
        return type( equalTo( type ) );
    }

    /**
     * <p>version</p>
     */
    public static Matcher<? super Dependency> version( Matcher<? extends String> versionMatcher )
    {
        return new VersionMatcher( versionMatcher );
    }

    /**
     * <p>version</p>
     */
    public static Matcher<? super Dependency> version( String version )
    {
        return version( equalTo( version ) );
    }

    private DependencyMatchers()
    {
        super();
    }

}
