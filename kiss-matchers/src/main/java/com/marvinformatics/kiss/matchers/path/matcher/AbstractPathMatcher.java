package com.marvinformatics.kiss.matchers.path.matcher;

import java.nio.file.Path;

import org.hamcrest.TypeSafeMatcher;

/**
 * <p>Abstract AbstractPathMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public abstract class AbstractPathMatcher
    extends TypeSafeMatcher<Path>
{

    /**
     * <p>Constructor for AbstractPathMatcher.</p>
     */
    public AbstractPathMatcher()
    {
        super( Path.class );
    }

}
