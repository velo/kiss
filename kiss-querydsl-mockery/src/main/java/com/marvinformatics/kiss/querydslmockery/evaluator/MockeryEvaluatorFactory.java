package com.marvinformatics.kiss.querydslmockery.evaluator;

import java.net.URLClassLoader;
import java.util.Map;

import com.marvinformatics.kiss.querydslmockery.impl.MockeryQueryFunctions;
import com.mysema.codegen.ECJEvaluatorFactory;
import com.mysema.codegen.Evaluator;
import com.mysema.codegen.EvaluatorFactory;
import com.mysema.codegen.JDKEvaluatorFactory;
import com.mysema.codegen.model.ClassType;
import com.mysema.codegen.model.Type;
import com.querydsl.collections.CollQueryFunctions;

public class MockeryEvaluatorFactory implements EvaluatorFactory
{

  public static final MockeryEvaluatorFactory DEFAULT = new MockeryEvaluatorFactory();
  private final EvaluatorFactory delegate;
  
  private MockeryEvaluatorFactory() {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      if (classLoader instanceof URLClassLoader) {
        this.delegate = new JDKEvaluatorFactory((URLClassLoader) classLoader);
    } else {
        // for OSGi compatibility
        this.delegate = new ECJEvaluatorFactory(classLoader);
    }
  }

  @Override
  public <T> Evaluator<T> createEvaluator(String source, Class<? extends T> projectionType, String[] names, Class<?>[] classes, Map<String, Object> constants)
  {
    return delegate.createEvaluator(fixLeftJoin(source), projectionType, names, classes, constants);
  }

  @Override
  public <T> Evaluator<T> createEvaluator(String source, ClassType projection, String[] names, Type[] types, Class<?>[] classes, Map<String, Object> constants)
  {
    return delegate.createEvaluator(fixLeftJoin(source), projection, names, types, classes, constants);
  }

  private String fixLeftJoin(String source)
  {
    return source.replace(
        CollQueryFunctions.class.getName() + ".leftJoin", 
        MockeryQueryFunctions.class.getName() +".leftJoin");
  }

}
