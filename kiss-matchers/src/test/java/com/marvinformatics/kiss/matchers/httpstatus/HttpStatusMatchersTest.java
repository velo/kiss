package com.marvinformatics.kiss.matchers.httpstatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hamcrest.Matcher;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HttpStatusMatchersTest
{

    @DataProvider( parallel = true )
    public Object[][] methodsProvider()
        throws Exception
    {
        // in case any new http code get inside HttpServletResponse this test will catch
        assertThat( fromField( "SC_A_B_C" ), equalTo( "aBC" ) );

        List<Object[]> data = new ArrayList<Object[]>();

        Field[] fields = HttpServletResponse.class.getFields();
        for ( Field field : fields )
        {
            String name = field.getName();
            if ( !name.startsWith( "SC_" ) )
            {
                continue;
            }

            String methodName = fromField( name );

            try
            {
                HttpStatusMatchers.class.getMethod( methodName );
            }
            catch ( NoSuchMethodException e )
            {
                // fall back position
                try
                {
                    methodName = methodName + "Status";
                    HttpStatusMatchers.class.getMethod( methodName );
                }
                catch ( NoSuchMethodException e1 )
                {
                    fail( "No assertion method found for: " + name + ":" + methodName, e );
                    throw e1;
                }
            }

            int code = (Integer) field.get( null );
            data.add( new Object[] { methodName, code } );
        }

        return data.toArray( new Object[0][] );
    }

    @Test( dataProvider = "methodsProvider", threadPoolSize = 10 )
    public void singleCodeMethods( String methodName, Integer code )
        throws Exception
    {
        Method method = HttpStatusMatchers.class.getMethod( methodName );
        @SuppressWarnings( "unchecked" )
        Matcher<Integer> matcher = (Matcher<Integer>) method.invoke( null );
        assertThat( code, matcher );
    }

    private String fromField( String name )
    {
        StringBuilder methodName = new StringBuilder();
        String[] parts = name.split( "_" );
        for ( int i = 0; i < parts.length; i++ )
        {
            String part = parts[i].toLowerCase();
            if ( i == 0 )
            {
                continue;
            }
            if ( i == 1 )
            {
                methodName.append( part );
            }
            else
            {
                methodName.append( Character.toUpperCase( part.charAt( 0 ) ) );
                methodName.append( part.substring( 1 ) );
            }
        }
        return methodName.toString();
    }

    @Test
    public void successTest()
    {
        assertThat( HttpServletResponse.SC_OK, HttpStatusMatchers.success() );
        assertThat( HttpServletResponse.SC_CREATED, HttpStatusMatchers.success() );
        assertThat( HttpServletResponse.SC_ACCEPTED, HttpStatusMatchers.success() );
        assertThat( HttpServletResponse.SC_NO_CONTENT, HttpStatusMatchers.success() );
    }

    @Test
    public void redirectTest()
    {
        assertThat( HttpServletResponse.SC_MOVED_PERMANENTLY, HttpStatusMatchers.redirect() );
        assertThat( HttpServletResponse.SC_SEE_OTHER, HttpStatusMatchers.redirect() );
        assertThat( HttpServletResponse.SC_NOT_MODIFIED, HttpStatusMatchers.redirect() );
        assertThat( HttpServletResponse.SC_TEMPORARY_REDIRECT, HttpStatusMatchers.redirect() );
    }

    @Test
    public void clientErrorTest()
    {
        assertThat( HttpServletResponse.SC_BAD_REQUEST, HttpStatusMatchers.clientError() );
        assertThat( HttpServletResponse.SC_UNAUTHORIZED, HttpStatusMatchers.clientError() );
        assertThat( HttpServletResponse.SC_FORBIDDEN, HttpStatusMatchers.clientError() );
        assertThat( HttpServletResponse.SC_NOT_FOUND, HttpStatusMatchers.clientError() );
    }

    @Test
    public void serverErrorTest()
    {
        assertThat( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, HttpStatusMatchers.serverError() );
        assertThat( HttpServletResponse.SC_SERVICE_UNAVAILABLE, HttpStatusMatchers.serverError() );
    }
}
