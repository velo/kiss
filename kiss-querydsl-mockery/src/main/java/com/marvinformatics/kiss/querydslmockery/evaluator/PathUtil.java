package com.marvinformatics.kiss.querydslmockery.evaluator;

import java.lang.reflect.Field;
import java.util.StringTokenizer;

import javax.persistence.Id;

import com.mysema.query.types.Path;

public class PathUtil {

	public static Object getValue(Path pathImpl, Object tuple) {
		StringTokenizer tokenizer = new StringTokenizer( pathImpl.toString(), "\\." );
		// queima o primeiro elemento
		tokenizer.nextElement();
		try {
			return getValue( tokenizer, tuple );
		} catch (Exception e) {
			throw new RuntimeException( "PathUtil.getValue FAIL: " + pathImpl );
		}
	}

	private static Object getValue(StringTokenizer tokenizer, Object object) throws Exception {
		String field = (String) tokenizer.nextElement();
		object = getValueFromField( object, field );

		if (object == null)
			return null;
		if (tokenizer.hasMoreElements())
			return getValue( tokenizer, object );
		return object;
	}

	private static Object getValueFromField(Object object, String fieldName) throws ReflectiveOperationException {
		Field field = null;
		if (fieldName.equals( "id" ))
			field = getFieldId( object );
		else
			field = getFieldByName( object, fieldName );
		field.setAccessible( true );

		return field.get( object );
	}

	protected static Field getFieldByName(Object object, String fieldName) throws NoSuchFieldException {
		Field field;
		try {
			field = object.getClass().getDeclaredField( fieldName );
		} catch (Exception e) {
			field = object.getClass().getSuperclass().getDeclaredField( fieldName );
		}
		return field;
	}

	private static Field getFieldId(Object object) {
		Field[] declaredFields = object.getClass().getDeclaredFields();
		for (Field field : declaredFields)
			if (field.isAnnotationPresent( Id.class ))
				return field;
		return null;
	}
}
