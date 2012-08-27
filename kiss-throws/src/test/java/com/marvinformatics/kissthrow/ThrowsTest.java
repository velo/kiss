package com.marvinformatics.kissthrow;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.marvinformatics.kissthrow.Throws;

public class ThrowsTest
{

    @BeforeMethod
    public void validateMethods()
    {
        Method[] methods = ThrowsTest.class.getDeclaredMethods();
        for ( Method method : methods )
        {
            //metodos de teste não devem lançar exception
            assertThat( method.getExceptionTypes(), emptyArray() );
        }
    }

    @Test( expectedExceptions = Exception.class )
    public void silentThrowException()
    {
        Throws.silentThrow( new Exception() );
    }

    @Test( expectedExceptions = RuntimeException.class )
    public void silentThrowRuntimeException()
    {
        Throws.silentThrow( new RuntimeException() );
    }

    @Test( expectedExceptions = Throwable.class )
    public void silentThrowThrowable()
    {
        Throws.silentThrow( new Throwable() );
    }

    @Test( expectedExceptions = IOException.class )
    public void silentThrowIOException()
    {
        Throws.silentThrow( new IOException() );
    }

}
