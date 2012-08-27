package com.marvinformatics.kiss.matchers.file.matcher;

import java.io.File;

import org.hamcrest.TypeSafeMatcher;

public abstract class AbstractFileMatcher
    extends TypeSafeMatcher<File>
{

    protected File fileTested;

    public AbstractFileMatcher()
    {
        super( File.class );
    }

}