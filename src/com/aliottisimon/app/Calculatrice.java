package com.aliottisimon.app;

import java.util.Arrays;

public class Calculatrice {

	/**
	 * Effectue le calcul, le nombres décimaux peuvent êtres écrit avec 
	 * une virgule ou un point
	 * 
	 * @calcul le calcul à effectuer
	 * @return le résultat
	 */
	public double calculator(String calcul) {
		String regexSign = "[+\\-/*]";
		String regexNumbers = "[0-9]+(\\.[0-9])?";

		calcul = removeSpace(calcul);
		calcul = calcul.replaceAll(",", ".");

		String[] tabNumbers = calcul.split(regexSign);
		String[] tabSigns = calcul.split(regexNumbers);

		System.out.println(Arrays.toString(tabSigns));
		System.out.println(Arrays.toString(tabNumbers));

		int sizeNumbers = tabNumbers.length;
		int sizeOfCalculs = sizeNumbers - 1;

	
		
		int j = 1;
		double result = Double.parseDouble(tabNumbers[0]);

		for (int i = 0; i < sizeOfCalculs; i++) {

			if (tabSigns[j].contains("+")) {
				result = result + Double.parseDouble(tabNumbers[i + 1]);
				j++;
				System.out.println(result);
			} else if (tabSigns[j].contains("-")) {
				result = result - Double.parseDouble(tabNumbers[i + 1]);
				j++;
				System.out.println(result);
			} else if (tabSigns[j].contains("*")) {
				result = result * Double.parseDouble(tabNumbers[i + 1]);
				j++;
				System.out.println(result);
			} else if (tabSigns[j].contains("/")) {
				result = result / Double.parseDouble(tabNumbers[i + 1]);
				j++;
				System.out.println(result);
			} else {
				System.out.println("L'expression ne contient pas de signe mathématique");
			}

		}
		return result;
	}

	/**
	 * Retire tous les espaces du calcul à effectuer
	 * @le calcul à effectuer (input)
	 * @return le calcul à effectuer sans les espaces
	 */
	public String removeSpace(String calcul) {
		calcul.replaceAll("\\s", "");
		return calcul;
	}

}
