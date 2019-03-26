package lgulab.ecmascript;

import lgulab.beans.Person;

public class JavascriptCallFunctions {
	
	public static void main(String[] args) throws Exception {
		
		JavascriptFunctions myFunctions = new JavascriptFunctions();
		
		System.out.println("add(2,3)        : " + myFunctions.add(2, 3) );
		System.out.println("add(2.5, 7.123) : " + myFunctions.add(2.5, 7.123) );
		System.out.println("isOK('xzy') : " + myFunctions.isOK("xzy") );
		System.out.println("isOK('aaa') : " + myFunctions.isOK("aaa") );
		
		Person person = new Person(123, "Bart", "Simpson");
		System.out.println("id('person') : " + myFunctions.id(person) );
	}
	
}
