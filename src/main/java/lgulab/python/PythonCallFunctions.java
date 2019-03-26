package lgulab.python;

import lgulab.ecmascript.JavascriptFunctions;

public class PythonCallFunctions {
	
	public static void main(String[] args) throws Exception {
		
		JavascriptFunctions myFunctions = new JavascriptFunctions();
		
		System.out.println("add(2,3)        : " + myFunctions.add(2, 3) );
		System.out.println("add(2.5, 7.123) : " + myFunctions.add(2.5, 7.123) );
		System.out.println("isOK('xzy') : " + myFunctions.isOK("xzy") );
		System.out.println("isOK('aaa') : " + myFunctions.isOK("aaa") );
	}
	
}
