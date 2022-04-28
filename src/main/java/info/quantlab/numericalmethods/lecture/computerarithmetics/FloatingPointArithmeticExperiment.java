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
	}
}
