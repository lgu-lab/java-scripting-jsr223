package lgulab.ecmascript;

public class EvalJavascriptCallFunctions {
	
	public static void main(String[] args) throws Exception {
		
		MyFunctions myFunctions = new MyFunctions();
		
		System.out.println("add(2,3)        : " + myFunctions.add(2, 3) );
		System.out.println("add(2.5, 7.123) : " + myFunctions.add(2.5, 7.123) );
		System.out.println("isOK('xzy') : " + myFunctions.isOK("xzy") );
		System.out.println("isOK('aaa') : " + myFunctions.isOK("aaa") );
	}
	
}
