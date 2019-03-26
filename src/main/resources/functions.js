/*
 * Returns a number --> 'java.lang.Double' in Java
 */
function add(a, b) {
	return a + b ;
}

/*
 * Returns a number --> 'java.lang.Double' in Java
 */
function modulo10(a) {
	return a % 10 ;
}

/*
 * Returns a boolean --> 'java.lang.Boolean' in Java
 */
function isOK(s) {
	if ( s == "AAA" ) {
		return true ;
	}
	else {
		return false ;
	}
}

/*
 * Returns the original Java type --> 'java.lang.Integer'
 */
function id(person) {
	return person.id;
}

/*
 * KPI calculation simulation
 */
function process(v) {
	v.c = v.a + v.b ;
}

/*
 * KPI calculation simulation
 */
function process2(v) {
	v.c = v.a + v.b ;
}

/*
 * KPI calculation simulation
 */
function calc(data) {
	// Compute missing KPI 
	cafvd = ( data.QTE * data.PPHT ) + data.LPC ;
	cafdp = data.CAFDF + data.CAFDRE ;
	rca = cafdp + data.CAFDRE ;
	cafa = cafdp + cafvd ;
	
	// Set computed KPI values 
	data.CAFVD = cafvd ;
	data.CAFDP = cafdp ;
	data.RCA = rca ;
	data.CAFA = cafa ;
}
