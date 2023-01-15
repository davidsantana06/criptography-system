package Projects.P00;

public class Cryptography {
    public static final int CHAR_LIM = 40;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int LETTER_GAP = 3;

    public static String encryptText(String text) {
        char[] characteres = text.toCharArray();
        String encryptedText = "";

        for (char character : characteres) {
            if (Character.isLetter(character)) {
                boolean isUpperCase = (Character.isUpperCase(character)) ? true : false;
                if (isUpperCase) {
                    character = Character.toLowerCase(character);
                }

                int idx = 0;
                while (idx < ALPHABET.length()) {
                    if (character == ALPHABET.charAt(idx)) {
                        break;
                    }

                    idx++;
                }

                idx += LETTER_GAP;
                if (idx >= ALPHABET.length()) {
                    idx -= ALPHABET.length();
                }

                encryptedText += (isUpperCase) ? Character.toUpperCase(ALPHABET.charAt(idx)) : ALPHABET.charAt(idx);
            } else {
                encryptedText += character;
            }
        }

        return encryptedText;
    }
}