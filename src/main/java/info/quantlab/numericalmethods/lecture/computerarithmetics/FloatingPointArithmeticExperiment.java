/*
 * (c) Copyright Christian P. Fries, Germany. Contact: email@christian-fries.de.
 *
 * Created on 23.04.2020, 26.04.2022
 */
package info.quantlab.numericalmethods.lecture.computerarithmetics;

/**
 * A simple class illustrating some aspects related to floating point arithmetic.
 *
 * @author Christian Fries
 */
public class FloatingPointArithmeticExperiment {

	public static void main(String[] args) {

		/*
		 * Explore Double
		 */

		System.out.println("\nSome experiments related to floating point arithmetic (IEEE 754).\n");
		System.out.println("_".repeat(79)+"\n");

		/*
		 * Double: Smallest positive number
		 */

		System.out.println("Smallest positive number 2^{-k}:\n");

		double tiny = 1.0;
		while(tiny/2.0 > 0 && tiny/2.0 < tiny) {
			tiny = tiny / 2.0;
		}

		System.out.println("tiny............ = " + tiny);

		System.out.println("2^{eMin-p}...... = " + Math.pow(2,-1022 - 52));

		System.out.println("tiny/2.......... = " + tiny/2);
		System.out.println("tiny/2*2........ = " + (tiny/2)*2);
		System.out.println("tiny*2/2........ = " + (tiny*2)/2);

		System.out.println("_".repeat(79)+"\n");
		
		
		System.out.println("Smallest positive number with 1 + 2x != 1 and 1 + x = 1");
		
		double eps = 1.0;
		while(1 + eps > 1) {
			eps = eps / 2.0;
		}
		
		System.out.println("eps................. = " + eps);
		System.out.println("1+eps............... = " + (1+eps));
		System.out.println("1+eps == 1.......... = " + (1+eps == 1));
		System.out.println("1+2*eps............. = " + (1+2*eps));
		System.out.println("2^{-52-1}........... = " + Math.pow(2, -53));

		System.out.println("1+1*eps............. = " + (1+1*eps));
		System.out.println("1+2*eps............. = " + (1+2*eps));
		System.out.println("1+3*eps............. = " + (1+3*eps));
		System.out.println("1+4*eps............. = " + (1+4*eps));
		System.out.println("1+5*eps............. = " + (1+5*eps));
		System.out.println("1+6*eps............. = " + (1+6*eps));

		System.out.println("_".repeat(79)+"\n");

		System.out.println("Small experiments with Double.MAX_VALUE");
		
		double maxDouble = Double.MAX_VALUE;
		double bigStep   = 0.49 * Math.pow(2,1023-52);
		double biggerStep= 0.50 * Math.pow(2,1023-52);

		System.out.println("maxDouble...................... = " + maxDouble);
		System.out.println("maxDouble+1000................. = " + (maxDouble+1000));
		System.out.println("bigStep........................ = " + (bigStep));
		System.out.println("maxDouble+bigStep.............. = " + (maxDouble+bigStep));
		System.out.println("maxDouble+biggerStep........... = " + (maxDouble+biggerStep));

		System.out.println("maxDouble+maxDouble-maxDouble.. = " + ((maxDouble+maxDouble)-maxDouble));
		System.out.println("maxDouble+(maxDouble-maxDouble) = " + (maxDouble+(maxDouble-maxDouble)));
	
		System.out.println("_".repeat(79)+"\n");

		System.out.println("Experiments on loss of significance - sovle a quadratic equation x^2 + px + q = 0");
		
		double p = -10000000;
		double q = 1.0;
		
		double x1 = getSmallestRootOfQuadraticEquationVersion1(p,q);
		
		System.out.println("........................p = " + p);
		System.out.println("........................q = " + q);
		System.out.println("Solution...............x1 = " + x1);
		System.out.println("x^2 + px + q for x=x1.... = " + (x1*x1+p*x1+q));
		
		System.out.println();
		
		double x2 = getSmallestRootOfQuadraticEquationVersion2(p,q);
		System.out.println("........................p = " + p);
		System.out.println("........................q = " + q);
		System.out.println("Solution...............x2 = " + x2);
		System.out.println("x^2 + px + q for x=x2.... = " + (x2*x2+p*x2+q));
		
		System.out.println("_".repeat(79)+"\n");

		System.out.println("Experiments related to +/- 0 and +/- Infinity");
		
		double plusZero = 1.0;
		while(plusZero != 0) {
			plusZero = plusZero / 2.0;
		}
		System.out.println("plusZero.................. = " + plusZero);
		
		double minusZero = -1.0;
		while(minusZero != 0) {
			minusZero = minusZero / 2.0;
		}
		System.out.println("minusZero................. = " + minusZero);
		
		System.out.println("+0 == -0................. is " + (plusZero == minusZero));
		
		double plusInfinity = 1/plusZero;
		double minusInfinity = 1/minusZero;
		
		System.out.println("1/+0...................... = " + plusInfinity);
		System.out.println("1/-0...................... = " + minusInfinity);
		
		System.out.println("plusInfinity+minusInfinity = " + (plusInfinity+minusInfinity));
		
		System.out.println("1 + Infinity.............. = " + (1+plusInfinity));
		
		System.out.println("sqrt(-1).................. = " + Math.sqrt(-1));
		
		double nan = Double.NaN;
		
		System.out.println("nan....................... = " + nan);
		
		System.out.println("1+nan..................... = " + (1+nan));
		
		double e1 = nan;
		double e2 = e1;
		
		System.out.println("nan == nan................ = " + (e1 == e2));
		
		
	}

	private static double getSmallestRootOfQuadraticEquationVersion2(double p, double q) {
		return q / (-p/2 + Math.sqrt(p*p/4 - q));
	}

	private static double getSmallestRootOfQuadraticEquationVersion1(double p, double q) {
		return -p/2 - Math.sqrt(p*p/4 - q);
	}
}
