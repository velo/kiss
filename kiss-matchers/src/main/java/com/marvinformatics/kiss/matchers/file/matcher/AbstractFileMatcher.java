package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.TypeSafeMatcher;

/**
 * <p>Abstract AbstractFileMatcher class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public abstract class AbstractFileMatcher
    extends TypeSafeMatcher<File>
{

    protected File fileTested;

    /**
     * <p>Constructor for AbstractFileMatcher.</p>
     */
    public AbstractFileMatcher()
    {
        super( File.class );
    }

}
