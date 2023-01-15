package Projects.P00;

public class TextPattern {
    public final static int INTRO = 0, PANEL = 1, H_EMPTY = 2, CHAR_LIM = 3, INV_INP = 4, CRIPT = 5, G_BYE = 6;

    public static String getMsg(int idx) {
        String msg = "";

        switch (idx) {
            case INTRO:
                msg = "J_ CRIPTOGRAPHY SYSTEM ~~~~~~~~~~~~~~~~\n"
                    + "~~~~~~~~~~~~~~~~~~~~~~ by David Santana";
                break;
            case PANEL:
                msg = "   CRIPTOGRAPHY SYSTEM   \n"
                    + "   -------------------   \n"
                    + "> [1] Encrypt Text       \n"
                    + "> [2] Show History       \n"
                    + "> [3] Statistical Queries\n"
                    + "> [0] End Application    \n";
                break;
            case H_EMPTY:
                msg = "The History is Empty!";
                break;
            case CHAR_LIM:
                msg = String.format("The Character Limit is %d!", Cryptography.CHAR_LIM);
                break;
            case INV_INP:
                msg = "Invalid Input!";
                break;
            case CRIPT:
                msg = "CRIPTOGRAPHY";
                break;
            case G_BYE:
                msg = "String goodBye = \"Good Bye\";";
        }

        return formatText(msg);
    }

    public static String formatText(String text) {
        String[] strArray = text.split("\n");
        int maxLenght = maxLenght(strArray);

        String format = "| %-" + maxLenght + "s |";
        String hyphens = "|-" + "-".repeat(maxLenght) + "-|";
        String formatedText = "";

        for (String str : strArray) {
            formatedText += String.format(format, str) + '\n';
        }

        return (hyphens + "\n" + formatedText + hyphens);
    }

    public static String[] hyphens(int titleLenght, int textLenght) {
        String[] hyphens = new String[2];
        if (textLenght > titleLenght) {
            hyphens[0] = " " + "-".repeat(textLenght - (titleLenght + 1));
            hyphens[1] = "-".repeat(textLenght);
        } else {
            hyphens[0] = "";
            hyphens[1] = "-".repeat(titleLenght);
        }

        return hyphens;
    }

    public static int maxLenght(String[] strArray) {
        int maxLenght = 0;

        for (String str : strArray) {
            if (str.length() > maxLenght) {
                maxLenght = str.length();
            }
        }

        return maxLenght;
    }
}
