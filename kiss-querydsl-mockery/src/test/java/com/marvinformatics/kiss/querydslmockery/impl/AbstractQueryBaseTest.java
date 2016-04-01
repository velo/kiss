package com.marvinformatics.kiss.querydslmockery.impl;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;
import static org.mockito.Answers.CALLS_REAL_METHODS;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.hamcrest.MatcherAssert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class AbstractQueryBaseTest
{

  private static AbstractQueryBase<?, ?> queryBase;

  @BeforeClass
  public static void createAbstractQueryBase() throws InstantiationException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
  {
    queryBase = Mockito.mock(AbstractQueryBase.class, CALLS_REAL_METHODS.get());
  }

  @Parameters
  public static List<Object[]> primeNumbers()
  {
    Method[] methods = AbstractQueryBase.class.getDeclaredMethods();
    Object[][] parameters = new Object[methods.length][];
    for (int i = 0; i < parameters.length; i++)
      parameters[i] = new Object[] { methods[i] };

    return asList(parameters);
  }

  private final Method methodUnderTest;

  public AbstractQueryBaseTest(Method methodUnderTest)
  {
    this.methodUnderTest = methodUnderTest;
  }

  @Test(expected = UnsupportedOperationException.class)
  public void checkUnsupportedException() throws Throwable
  {
    if(Modifier.isVolatile(methodUnderTest.getModifiers()))
      throw new AssumptionViolatedException("skipping volatile method: " + methodUnderTest);

    Class<?>[] parameterTypes = methodUnderTest.getParameterTypes();
    Object[] parameters = new Object[parameterTypes.length];
    for (int i = 0; i < parameterTypes.length; i++)
      parameters[i] = createParameter(parameterTypes[i]);

    try
    {
      methodUnderTest.invoke(queryBase, parameters);
      fail("Method should throw error " + methodUnderTest);
    }
    catch (IllegalAccessException e)
    {
      // just ignore jacoco syntetic methods
      MatcherAssert.assertThat(methodUnderTest.getName(), equalTo("$jacocoInit"));
      throw new AssumptionViolatedException("skipping jacocoInit " + methodUnderTest, e);
    }
    catch (InvocationTargetException e)
    {
      throw e.getCause();
    }
  }

  private Object createParameter(Class<?> type)
  {
    if (!type.isPrimitive())
      return null;

    if (int.class.equals(type))
      return 0;
    if (long.class.equals(type))
      return 0;
    if (boolean.class.equals(type))
      return true;

    throw new IllegalArgumentException("Unknow type " + type);
  }

}
