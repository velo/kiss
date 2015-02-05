package com.marvinformatics.kiss.querydslmockery.engine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineEval {

	private static final ScriptEngine jsEngine;
	private static final String JAVA_SCRIPT = "JavaScript";

	static {
		ScriptEngineManager factory = new ScriptEngineManager();
		jsEngine = factory.getEngineByName( JAVA_SCRIPT );
	}

	public static Object eval(String statement) throws ScriptException {
		try {
			return jsEngine.eval( statement );
		} catch (Exception e) {
			throw new ScriptException( statement + " - " + e.getLocalizedMessage() );
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println( eval( "1 > 0" ) );
	}
}
