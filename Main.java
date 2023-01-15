package Projects.P00;

import java.lang.Thread;
import java.util.Scanner;

public class Main {
	private static final String C = "Crypt.", H = "History", SQ = "Stat. Queries";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int maxLenght = 0, lettersTyped = 0;
		String history = "";

		print(TextPattern.getMsg(TextPattern.INTRO) + "\n", 0);

		boolean endApp = false;
		while (!endApp) {
			print(TextPattern.getMsg(TextPattern.PANEL) + "\n" + "_Operation: ", 1);
			String operation = input.nextLine();

			switch (operation) {
				case "0":
					endApp = true;
					print(TextPattern.getMsg(TextPattern.G_BYE), 2);
					break;
				case "1":
					print(TextPattern.getMsg(TextPattern.CRIPT), 1);
					boolean validText = false;
					while (!validText) {
						print("_Text: ", 1);
						String text = input.nextLine();

						if (text.length() <= Cryptography.CHAR_LIM) {
							char[] characteres = text.toCharArray();
							if (haveLetter(characteres)) {
								validText = true;

								String encryptedText = Cryptography.encryptText(text);
								String[] hps = TextPattern.hyphens(C.length(), encryptedText.length());

								lettersTyped += letterCount(characteres);
								history += "\nT_: " + text + "\nC_: " + encryptedText + "\n";

								if (maxLenght < encryptedText.length()) {
									maxLenght = encryptedText.length();
								}

								print(C + hps[0], 2);
								charByChar(encryptedText);
								print(hps[1], 2);
							} else {
								print(TextPattern.getMsg(TextPattern.INV_INP), 2);
							}
						} else {
							print(TextPattern.getMsg(TextPattern.CHAR_LIM), 2);
						}
					}
					break;
				case "2":
					if (history != "") {
						String[] hps = TextPattern.hyphens(H.length(), (maxLenght + 4));

						print(H + hps[0], 1);
						print(history, 1);
						print(hps[1], 2);
					} else {
						print(TextPattern.getMsg(TextPattern.H_EMPTY), 2);
					}
					break;
				case "3":
					if (history != "") {
						String queries[] = { "Letters Typed_: " + lettersTyped,
											 "Total Characters of Biggest Text_: " + maxLenght };
						String[] hps = TextPattern.hyphens(SQ.length(), queries[1].length());

						print(SQ + hps[0], 1);
						print(queries[0] + "\n" + queries[1], 1);
						print(hps[1], 2);
					} else {
						print(TextPattern.getMsg(TextPattern.H_EMPTY), 2);
					}
					break;
				default:
					print(TextPattern.getMsg(TextPattern.INV_INP), 2);
			}
		}

		input.close();
	}

	private static void print(String text, int blankSpace) {
		if (blankSpace == 0) {
			System.out.print(text);
		} else if (blankSpace == 1) {
			System.out.print("\n" + text);
		} else {
			System.out.print("\n" + text + "\n");
		}
	}

	private static void charByChar(String text) {
		for (char character : text.toCharArray()) {
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {}
			System.out.print(character);
		}
	}

	private static int letterCount(char[] characteres) {
		int letterQtt = 0;
		for (char character : characteres) {
			if (Character.isLetter(character)) {
				letterQtt++;
			}
		}
		return letterQtt;
	}

	private static boolean haveLetter(char[] characteres) {
		for (char character : characteres) {
			if (Character.isLetter(character)) {
				return true;
			}
		}
		return false;
	}
}
