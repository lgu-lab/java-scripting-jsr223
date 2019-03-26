package lgulab.ecmascript;

import java.util.Hashtable;
import java.util.Map;

import lgulab.beans.KPI;
import lgulab.beans.Person;
import lgulab.beans.Values;
import lgulab.beans.Values2;

public class JavascriptCallFunctions {
	
	public static void main(String[] args) throws Exception {
		
		JavascriptFunctions myFunctions = new JavascriptFunctions();
		
		System.out.println("add(2,3)        : " + myFunctions.add(2, 3) );
		System.out.println("add(2.5, 7.123) : " + myFunctions.add(2.5, 7.123) );
		System.out.println("isOK('xzy') : " + myFunctions.isOK("xzy") );
		System.out.println("isOK('aaa') : " + myFunctions.isOK("aaa") );
		
		Person person = new Person(123, "Bart", "Simpson");
		System.out.println("id('person') : " + myFunctions.id(person) );
		
		Values values = new Values(15, 3);
		System.out.println("values : " + values );
		myFunctions.process(values) ;
		System.out.println("values : " + values );
		
		Values2 v = new Values2(100, 56);
		System.out.println("v : " + v );
		myFunctions.process2(v) ;
		System.out.println("v : " + v );
		
		// Test with specialized object
		KPI kpi = new KPI();
		kpi.CAFDO = 1.0 ;
		kpi.CAFDR = 2.0 ;
		kpi.CAFDRE = 3.5 ;
		kpi.CAFDF = 4.0 ;
		kpi.QTE = 12 ;
		kpi.PPHT = 18.75 ;
		kpi.LPC = 3.0 ;
		System.out.println("kpi input  : " + kpi );
		myFunctions.calc(kpi) ;
		System.out.println("kpi output : " + kpi );
		
		// Test with generic map
		Map<String,Double> map = new Hashtable<>();
		map.put("CAFDO", 1.0) ;
		map.put("CAFDR", 2.0 ) ;
		map.put("CAFDRE", 3.5 ) ;
		map.put("CAFDF", 4.0 );
		map.put("QTE", 12.0 );
		map.put("PPHT", 18.75 );
		map.put("LPC", 3.0 );
		System.out.println("map input  : " + map );
		myFunctions.calc(map) ;
		System.out.println("map output : " + map );
		
	}
	
}
