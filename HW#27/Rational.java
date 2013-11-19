// Nicholas Romanoff
// Period Nine
// Homework #27
// 2012-11-18

public class Rational {

//	PHASE ONE

// 	Instance Variables:
//	- for the numerator and denominator

	private int _numerator;
	private int _denominator;

// 	Default Constructor:
//	- creates a new Rational with the value of 0/1

	public Rational() {
		_numerator = 0;
		_denominator = 1;
	}

// 	Overloaded Constructor:
//	- takes two parameters, one for the numerator, one for the denominator
//	- if an invalid denominator is attempted, should print a message and set the number to 0/1

	public Rational(int numerator, int denominator) {
		if (denominator == 0) {
			System.out.println("------------------------------------------------------------");
			System.out.println("Error: Rational numbers do not have zero in the denominator:");
			System.out.println("Value automatically set to 0/1");
			System.out.println("------------------------------------------------------------");
			numerator = 0;
			denominator = 1;
		}
		_numerator = numerator;
		_denominator = denominator;
	}

// 	Get Instance Methods:

	public int getNumerator() {
		return _numerator;
	}

	public int getDenominator() {
		return _denominator;
	}	

// 	Overwritten toString() Method:
//	- returns a string representation of the rational number

	public String toString() {
		String retStr = _numerator + "/" + _denominator;
		return retStr;
	}

// 	FloatValue Method:
//	- returns a floating point value of the number
//	- uses the most precise floating point primitive

	public double floatValue() {
		double ret = ((double) _numerator) / ((double) _denominator);
		return ret;
	} 

// 	Multiply:
//	- takes one Rational object as a arameter and multiplies it by this Rational object
//	- does not return any value
//	- should modify this object and leave the parameter alone
//	- need not reduce the fraction

	public void multiply(Rational factor) {
		_numerator *= factor.getNumerator();
		_denominator *= factor.getDenominator();
	}

// 	Divide:
//	- works the same as multiply, except the operation is division

	public void divide(Rational divisor) {
		_numerator *= divisor.getDenominator();
		_denominator *= divisor.getNumerator();
	}

// 	Add: 
//	- takes one Rational object and adds it to thecurrent rational number object
//	- need not reduce

	public void add(Rational plus) {
		if (_denominator == plus.getDenominator()) {
			_numerator += plus.getNumerator();
		}
		else {
			int temp = _denominator;
			_denominator *= plus.getDenominator();
			_numerator = (_numerator * plus.getDenominator()) + (plus.getNumerator() * temp);
		}
	}

// 	Subtract: 
//	- works the same as add, except the operation is subtraction

	public void subtract(Rational minus) {
		if (_denominator == minus.getDenominator()) {
			_numerator -= minus.getNumerator();
		}
		else {
			int temp = _denominator;
			_denominator *= minus.getDenominator();
			_numerator = (_numerator * minus.getDenominator()) - (minus.getNumerator() * temp);
		}
	}

// 	Greatest Common Denominator:
//	- uses Euclid's algorithm
//	- accounts for the fact that the first number must be greater than the second

	public int nGCD() {
		int a = _numerator;
		int b = _denominator;
		if (a < b) {
			int c = b;
			b = a;
			a = c;
		}
		int gcd = 1;
		int r = 1;
		if ((a % b) != 0) {

			int d = b;
			b = (a % b);
			a = d;
		}
		else {
			gcd = b;
		}
		return gcd;
	}

// 	Reduce:
//	- changes this Rational to one in reduced form using gcd

	public String reduce() {
		int xGCD = nGCD();
		_numerator /= xGCD;
		_denominator /= xGCD;
		return _numerator + "/" + _denominator;
	}

// 	Static Greatest Common Denominator:
//	- takes numerator and denominator inputs

	public static int eGCD(int a, int b) {
		if (a < b) {
			int c = b;
			b = a;
			a = c;
		}
		int gcd = 1;
		int r = 1;
		if ((a % b) != 0) {

			int d = b;
			b = (a % b);
			a = d;
		}
		else {
			gcd = b;
		}
		return gcd;
	}

// 	CompareTo Function:
//	- takes a Rational as a parameter and compares it to the calling object
//	- returns 0 if the two numbers are equal
//	- returns 1 if the calling number is larger than the parameter
//	- returns -1 if the calling number is smaller than the parameter

	public int compareTo(Rational comparison) {
		double a = floatValue();
		double b = comparison.floatValue();
		if (a > b) {
			return 1;
		}
		else if (a == b) {
			return 0;
		}
		else {
			return -1;
		}
	}

// 	Driver:

	public static void main( String[] args ) {

	System.out.println();
	System.out.println("------------------------------------------");
	System.out.println("------------------------------------------");
	System.out.println("--- Rational.java by Nicholas Romanoff ---");
	System.out.println("------------------------------------------");
	System.out.println("------------------------------------------");
	System.out.println();

	Rational exampleA = new Rational();
	System.out.println("Rational exampleA = new Rational();");
	System.out.println();
	System.out.println("Example A has been instantiated with the Default Constructor.");
	System.out.println("This is its numerator:    " + exampleA.getNumerator());
	System.out.println("This is its denominator:  " + exampleA.getDenominator());
	System.out.println();

	Rational exampleB = new Rational(1, 2);
	System.out.println("Rational exampleB = new Rational(1, 2);");
	System.out.println();
	System.out.println("Example B has been instantiated with the Overloaded Constructor.");
	System.out.println("This is its numerator:    " + exampleB.getNumerator());
	System.out.println("This is its denominator:  " + exampleB.getDenominator());
	System.out.println();

	System.out.println("Rational exampleC = new Rational(5, 0);");
	System.out.println();
	System.out.println("Example C has been instantiated with the Overloaded Constructor.");
	System.out.println("Note that its denominator is zero.");
	Rational exampleC = new Rational(5, 0);
	System.out.println("This is its numerator:    " + exampleC.getNumerator());
	System.out.println("This is its denominator:  " + exampleC.getDenominator());
	System.out.println();
	
	System.out.println("The overwritten toString() method can return each fraction as a String.");
	System.out.println();
	System.out.println("System.out.print(exampleA);" + "   ----->   " + exampleA);
	System.out.println("System.out.print(exampleB);" + "   ----->   " + exampleB);
	System.out.println("System.out.print(exampleC);" + "   ----->   " + exampleC);
	System.out.println();

	System.out.println("The floatValue() method can return the fractions as floating point values.");
	System.out.println();
	Rational exampleD = new Rational(7, 9);
	Rational exampleE = new Rational(3, 8);
	Rational exampleF = new Rational(1, 3);	
	System.out.println(exampleD + "   ----->   " + exampleD.floatValue());
	System.out.println(exampleE + "   ----->   " + exampleE.floatValue());
	System.out.println(exampleF + "   ----->   " + exampleF.floatValue());
	System.out.println();

	System.out.println("The multiply function takes a Rational and multiplies it by another Rational.");
	System.out.println("The product is not in simplest form, and the parameter is not changed.");
	System.out.println();
	Rational exampleG = new Rational(2, 3);
	Rational exampleH = new Rational(3, 5);
	exampleG.multiply(exampleH);
	System.out.println("Rational exampleG = new Rational(2, 3);");
	System.out.println("Rational exampleH = new Rational(3, 5);");
	System.out.println("exampleG.multiply(exampleH);");
	System.out.println();
	System.out.println("System.out.println(exampleG)" + "   ----->   " + exampleG);
	System.out.println("System.out.println(exampleG)" + "   ----->   " + exampleH);
	System.out.println();

	System.out.println("The add function can add two fractions.");
	System.out.println();
	Rational exampleI = new Rational(1, 4);
	Rational exampleJ = new Rational(2, 3);
	Rational exampleK = new Rational(1, 5);	
	Rational exampleL = new Rational(4, 6);
	Rational exampleM = new Rational(7, 8);
	Rational exampleN = new Rational(9, 11);
	String str1 = exampleI + " + " + exampleJ + " = ";
	exampleI.add(exampleJ);
	System.out.println(str1 + exampleI);
	String str2 = exampleK + " + " + exampleL + " = ";
	exampleK.add(exampleL);
	System.out.println(str2 + exampleK);
	String str3 = exampleM + " + " + exampleN + " = ";
	exampleM.add(exampleN);
	System.out.println(str3 + exampleM);
	System.out.println();

	System.out.println("The minus function can subtract one fraction from another.");
	System.out.println();
	Rational exampleO = new Rational(5, 6);
	Rational exampleP = new Rational(1, 3);
	Rational exampleQ = new Rational(1, 5);	
	Rational exampleR = new Rational(7, 8);
	Rational exampleS = new Rational(5, 7);
	Rational exampleT = new Rational(5, 7);
	String str4 = exampleO + " - " + exampleP + " = ";
	exampleO.subtract(exampleP);
	System.out.println(str4 + exampleO);
	String str5 = exampleQ + " - " + exampleR + " = ";
	exampleQ.subtract(exampleR);
	System.out.println(str5 + exampleQ);
	String str6 = exampleS + " - " + exampleT + " = ";
	exampleS.subtract(exampleT);
	System.out.println(str6 + exampleS);
	System.out.println();
	
	System.out.println("The GCD function returns the GCD of a fraction's components.");
	System.out.println();
	Rational exampleU = new Rational(5, 15);
	Rational exampleV = new Rational(3, 81);
	Rational exampleW = new Rational(7, 9);	
	System.out.println("Rational exampleU = new Rational(5, 15);");
	System.out.println("Rational exampleV = new Rational(3, 81);");
	System.out.println("Rational exampleW = new Rational(7, 9);");
	System.out.println();
	System.out.println("exampleU.nGCD();" + "    ----->   " + exampleU.nGCD());
	System.out.println("exampleV.nGCD();" + "    ----->   " + exampleV.nGCD());
	System.out.println("exampleW.nGCD();" + "    ----->   " + exampleW.nGCD());
	System.out.println();

	System.out.println("The reduce method is useful for simplifying fractions.");
	System.out.println();
	System.out.println(exampleU + "    ----->   " + exampleU.reduce());
	System.out.println(exampleV + "    ----->   " + exampleV.reduce());
	System.out.println(exampleW + "     ----->   " + exampleW.reduce());
	System.out.println();


	System.out.println("There's also a static GCD function that accepts numerator and denominator input.");
	System.out.println();
	System.out.println("eGCD(5, 5);" + "    ----->   " + eGCD(5, 5));
	System.out.println("eGCD(7, 1);" + "    ----->   " + eGCD(7, 1));
	System.out.println("eGCD(1, 11);" + "   ----->   " + eGCD(1, 11));
	System.out.println("eGCD(2, 8);" + "    ----->   " + eGCD(2, 8));
	System.out.println("eGCD(8, 2);" + "    ----->   " + eGCD(8, 2));
	System.out.println("eGCD(81, 9);" + "   ----->   " + eGCD(81, 9));
	System.out.println();

	System.out.println("Finally, compareTo() can be used to compare the values of two Rationals:");
	System.out.println();
	System.out.println("- If the calling number is larger than the parameter, 1 is returned.");
	System.out.println("- If the calling number is equal to the parameter, 0 is returned.");
	System.out.println("- If the calling number is less than the parameter, -1 is returned.");
	System.out.println();
	Rational exampleX = new Rational(1, 2);
	Rational exampleY = new Rational(3, 5);
	Rational exampleZ = new Rational(1, 20);	
	System.out.println("Rational exampleX = new Rational(1, 2);");
	System.out.println("Rational exampleY = new Rational(3, 5);");
	System.out.println("Rational exampleZ = new Rational(1, 20);");
	System.out.println();
	System.out.println("exampleX.compareTo(exampleX)" + "   ----->   " + exampleX.compareTo(exampleX));
	System.out.println("exampleX.compareTo(exampleY)" + "   ----->   " + exampleX.compareTo(exampleY));
	System.out.println("exampleX.compareTo(exampleZ)" + "   ----->   " + exampleX.compareTo(exampleZ));
	System.out.println();

	System.out.println();
	System.out.println("------------------------------------------");
	System.out.println("------------------------------------------");
	System.out.println("--- Rational.java by Nicholas Romanoff ---");
	System.out.println("------------------------------------------");
	System.out.println("------------------------------------------");
	System.out.println();

	}
}
