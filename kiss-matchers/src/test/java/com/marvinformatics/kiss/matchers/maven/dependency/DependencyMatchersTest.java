package com.marvinformatics.kiss.matchers.maven.dependency;

import static com.marvinformatics.kiss.matchers.maven.dependency.DependencyMatchers.artifactId;
import static com.marvinformatics.kiss.matchers.maven.dependency.DependencyMatchers.classifier;
import static com.marvinformatics.kiss.matchers.maven.dependency.DependencyMatchers.groupId;
import static com.marvinformatics.kiss.matchers.maven.dependency.DependencyMatchers.scope;
import static com.marvinformatics.kiss.matchers.maven.dependency.DependencyMatchers.type;
import static com.marvinformatics.kiss.matchers.maven.dependency.DependencyMatchers.version;
import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.maven.model.Dependency;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependencyMatchersTest
{

    private Dependency dependency;

    @BeforeMethod
    public void createArtifact()
    {
        dependency = new Dependency();
        dependency.setGroupId( "com.mi16.test" );
        dependency.setArtifactId( "artifact-test" );
        dependency.setClassifier( "tests" );
        dependency.setVersion( "1.1" );
        dependency.setType( "jar" );
        dependency.setScope( "provided" );
    }

    @Test
    public void testArtifactId()
    {
        assertThat( dependency, artifactId( "artifact-test" ) );
    }

    @Test
    public void testClassifier()
    {
        assertThat( dependency, classifier( "tests" ) );
    }

    @Test
    public void testGroupId()
    {
        assertThat( dependency, groupId( "com.mi16.test" ) );
    }

    @Test
    public void testScope()
    {
        assertThat( dependency, scope( "provided" ) );
    }

    @Test
    public void testType()
    {
        assertThat( dependency, type( "jar" ) );
    }

    @Test
    public void testVersion()
    {
        assertThat( dependency, version( "1.1" ) );
    }

    @Test( expectedExceptions = { AssertionError.class } )
    public void negativeTest()
    {
        assertThat( dependency, version( "europe" ) );
    }

}
