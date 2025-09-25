import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

class CoolHello{
    public static void main(String[] args) throws InterruptedException{



        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ @!?abcdefghijklmnopqrstuvwxyz1234567890_";


        String fullWord = "250997173_jeg_elsker_hunde";
        String printedWord = "";

        int wordIndex = 0;

        while (!printedWord.equals(fullWord)) {

            for (int CharIndex = 0; CharIndex < alphabet.length(); CharIndex++) {
                Thread.sleep(100);
                char currentChar = alphabet.charAt(CharIndex);
                System.out.println("\u001B[32m"+printedWord+currentChar);

                if (currentChar == fullWord.charAt(wordIndex)) {
                    printedWord = printedWord + currentChar;
                    wordIndex++;
                    break;
                }
            }

        }
    }
}



