package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Path;

import org.hamcrest.TypeSafeMatcher;

public abstract class AbstractPathMatcher
    extends TypeSafeMatcher<Path>
{

    public AbstractPathMatcher()
    {
        super( Path.class );
    }

}
