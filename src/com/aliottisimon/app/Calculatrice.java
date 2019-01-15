package com.aliottisimon.app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculatrice {

	/**
	 * Effectue le calcul, le nombres décimaux peuvent êtres écrit avec une virgule
	 * ou un point
	 * 
	 * @calcul le calcul à effectuer
	 * @return le résultat
	 */
	public double calculator(String calcul) {
		String regexSign = "[+\\-/*]";
		String regexNumbers = "[0-9.,]+";

		
		calcul = removeSpace(calcul);
		calcul = calcul.replaceAll(",", ".");
	

		String[] tabNumbers = calcul.split(regexSign);
		String[] tabSigns = calcul.split(regexNumbers);

		List<String> listNumbers = new LinkedList(Arrays.asList(tabNumbers));
		List<String> listSigns = new LinkedList(Arrays.asList(tabSigns));
		String test = listSigns.remove(0);

		System.out.println(listNumbers);
		System.out.println(listSigns);
		System.out.println(listNumbers.get(0));

		int index = -1;
		double result = 0;

		while (listNumbers.size() > 1) {

			//System.out.println("Liste avant chaque opération: " + listNumbers);
			if ((index = listSigns.indexOf("/")) > -1) {
				result = Double.parseDouble(listNumbers.get(index)) / Double.parseDouble(listNumbers.get(index + 1));
				//System.out.println("Resultat intermédiaire :" + result);
			} else if ((index = listSigns.indexOf("*")) > -1) {
				result = Double.parseDouble(listNumbers.get(index)) * Double.parseDouble(listNumbers.get(index + 1));
				//System.out.println("Resultat intermédiaire :" + result);
			} else if ((index = listSigns.indexOf("+")) > -1) {
				result = Double.parseDouble(listNumbers.get(index)) + Double.parseDouble(listNumbers.get(index + 1));
				//System.out.println("Resultat intermédiaire :" + result);
			} else if ((index = listSigns.indexOf("-")) > -1) {
				result = Double.parseDouble(listNumbers.get(index)) - Double.parseDouble(listNumbers.get(index + 1));
				//System.out.println("Resultat intermédiaire :" + result);
			}

			listNumbers.remove(index + 1);
			listNumbers.set(index, String.valueOf(result));
			listSigns.remove(index);

		}

		return result;
	}

	/**
	 * Retire tous les espaces du calcul à effectuer
	 * 
	 * @le calcul à effectuer (input)
	 * @return le calcul à effectuer sans les espaces
	 */
	public String removeSpace(String calcul) {
		calcul = calcul.replaceAll("\\s", "");
		return calcul;
	}

}
