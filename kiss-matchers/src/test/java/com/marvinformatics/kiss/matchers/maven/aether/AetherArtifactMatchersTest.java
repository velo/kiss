package com.marvinformatics.kiss.matchers.maven.aether;

import static com.marvinformatics.kiss.matchers.maven.aether.AetherArtifactMatchers.artifactId;
import static com.marvinformatics.kiss.matchers.maven.aether.AetherArtifactMatchers.baseVersion;
import static com.marvinformatics.kiss.matchers.maven.aether.AetherArtifactMatchers.classifier;
import static com.marvinformatics.kiss.matchers.maven.aether.AetherArtifactMatchers.extension;
import static com.marvinformatics.kiss.matchers.maven.aether.AetherArtifactMatchers.groupId;
import static com.marvinformatics.kiss.matchers.maven.aether.AetherArtifactMatchers.version;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.sonatype.aether.artifact.Artifact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AetherArtifactMatchersTest
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
        when( artifact.getBaseVersion() ).thenReturn( "1" );
        when( artifact.getExtension() ).thenReturn( "jar" );
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
    public void testExtension()
    {
        assertThat( artifact, extension( "jar" ) );
    }

    @Test
    public void testVersion()
    {
        assertThat( artifact, version( "1.1" ) );
    }

    @Test
    public void testBaseVersion()
    {
        assertThat( artifact, baseVersion( "1" ) );
    }

    @Test( expectedExceptions = { AssertionError.class } )
    public void negativeTest()
    {
        assertThat( artifact, version( "europe" ) );
    }

}
