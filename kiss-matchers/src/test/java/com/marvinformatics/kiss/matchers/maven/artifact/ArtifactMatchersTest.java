package com.marvinformatics.kiss.matchers.maven.artifact;

import static com.marvinformatics.kiss.matchers.maven.artifact.ArtifactMatchers.artifactId;
import static com.marvinformatics.kiss.matchers.maven.artifact.ArtifactMatchers.classifier;
import static com.marvinformatics.kiss.matchers.maven.artifact.ArtifactMatchers.groupId;
import static com.marvinformatics.kiss.matchers.maven.artifact.ArtifactMatchers.scope;
import static com.marvinformatics.kiss.matchers.maven.artifact.ArtifactMatchers.type;
import static com.marvinformatics.kiss.matchers.maven.artifact.ArtifactMatchers.version;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.maven.artifact.Artifact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArtifactMatchersTest
{

    private Artifact artifact;

    @BeforeMethod
    public void createArtifact()
    {
        artifact = mock( Artifact.class );
        when( artifact.getGroupId() ).thenReturn( "com.mi16.test" );
        when( artifact.getArtifactId() ).thenReturn( "artifact-test" );
        when( artifact.getClassifier() ).thenReturn( "tests" );
        when( artifact.getVersion() ).thenReturn( "1.1" );
        when( artifact.getType() ).thenReturn( "jar" );
        when( artifact.getScope() ).thenReturn( "provided" );
    }

    @Test
    public void testArtifactId()
    {
        assertThat( artifact, artifactId( "artifact-test" ) );
    }

    @Test
    public void testClassifier()
    {
        assertThat( artifact, classifier( "tests" ) );
    }

    @Test
    public void testGroupId()
    {
        assertThat( artifact, groupId( "com.mi16.test" ) );
    }

    @Test
    public void testScope()
    {
        assertThat( artifact, scope( "provided" ) );
    }

    @Test
    public void testType()
    {
        assertThat( artifact, type( "jar" ) );
    }

    @Test
    public void testVersion()
    {
        assertThat( artifact, version( "1.1" ) );
    }

    @Test( expectedExceptions = { AssertionError.class } )
    public void negativeTest()
    {
        assertThat( artifact, version( "europe" ) );
    }

}
