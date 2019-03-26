package lgulab.ecmascript;

import java.util.Map;

import lgulab.beans.KPI;
import lgulab.beans.Person;
import lgulab.beans.Values;
import lgulab.beans.Values2;
import lgulab.scripting.ScriptFunctions;
import lgulab.scripting.Util;

public class JavascriptFunctions extends ScriptFunctions {

	public JavascriptFunctions() throws Exception {
		super(Util.getResourceFile("functions.js"), "javascript");
	}
	
	public Double add(double a, double b) throws Exception {
		Object[] args = {a, b };
		Object result = invokeFunction( "add", args);
		// System.out.println("Resutl type is " + result.getClass() );
		// Result is 'java.lang.Double'
		return (Double) result;
	}

	public int modulo10(int a) throws Exception {
		Object[] args = {a};
		Object result = invokeFunction( "modulo10", args);
		// System.out.println("Resutl type is " + result.getClass() );
		// Result is 'java.lang.Double'
		return ((Number)result).intValue();
	}

	public boolean isOK(String s) throws Exception {
		Object[] args = {s};
		Object result = invokeFunction( "isOK", args);
		return (Boolean) result;
	}

	public int id(Person p) throws Exception {
		Object[] args = {p};
		Object result = invokeFunction( "id", args);
		// System.out.println("'id()' Result type is " + result.getClass() );
		// Result is 'java.lang.Integer' (the original Java type in the Person class)
		return (int)result;
	}
	
	public void process(Values values) throws Exception {
		Object[] args = {values};
		invokeFunction( "process", args);
	}

	public void process2(Values2 values) throws Exception {
		Object[] args = {values};
		invokeFunction( "process2", args);
	}
	
	public void calc(KPI kpi) throws Exception {
		Object[] args = {kpi};
		invokeFunction( "calc", args);
	}
	public void calc(Map<String,Double> map) throws Exception {
		Object[] args = {map};
		invokeFunction( "calc", args);
	}
}
