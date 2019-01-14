package com.aliottisimon.app;

import com.aliottisimon.tools.MyScanner;

public class App {

	Calculatrice calculatrice = new Calculatrice();
	MyScanner sc = new MyScanner();

	/**
	 * Permet d'effectuer plusieurs calculs
	 */
	public void onOff() {
		boolean calculAgain = false;
		String answer;

		System.out.println("========Calculatrice=========");

		do {
			doCalcul();
			System.out.println("Voulez vous effectuer un autre calcul ? [O/N]");
			answer = sc.input();
			if (answer.equals("O")) {
				calculAgain = true;
			} else {
				calculAgain = false;
			}

		} while (calculAgain);
		System.out.println("Au revoir");
	}

	/**
	 * Lance le calcul
	 */
	public void doCalcul() {
		boolean inputIsGood;

		String calcul = null;

		do {
			System.out.println("Veuillez entrer votre calcul :");
			calcul = sc.input();
			inputIsGood = verifyInput(calcul);
		} while (!inputIsGood);

		double result = calculatrice.calculator(calcul);
		System.out.println("Resultat = " + result);

	}

	/**
	 * Vérifie que l'input ne contient pas de lettres ni d'opérateurs ou "," et "." redoublés.
	 * Les espaces sont également gérés dans une autre méthode.
	 * 
	 * @param calcul
	 * @return true or false
	 */
	public boolean verifyInput(String calcul) {

		if (calcul.contains("++") || calcul.contains("--") || calcul.contains("//") || calcul.contains("**")
				|| calcul.contains(",,") || calcul.contains("..")) {
			System.out.println("Votre calcul contient des erreurs de frappe !");
			return false;
		} else {

			String verify = calcul.replaceAll("[+\\-/*.,]", "");
			verify = verify.replaceAll("[ ]", "");

			try {
				Double.parseDouble(verify);

				return true;

			} catch (Exception e) {
				System.out.println("Votre calcul n'est pas correct !");
				return false;
			}

		}

	}
}
