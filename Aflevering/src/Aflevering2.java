import java.util.Scanner;


public class Aflevering2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Hvad er din temperatur?");
        double temp = input.nextDouble();
        if (temp < -20 || temp > 80){
            myFailure("TempOutOfBound");
            return;
        }

        System.out.println("Hvilen temperatur ønsker du?");
        double wishTemp = input.nextDouble();
        if (wishTemp <-20 || wishTemp > 80){
            myFailure("WishTempOutOfBound");
            return;
        }

        System.out.println("Hvad er klokken?");
        int klok = input.nextInt();
        input.nextLine();
        if (klok < 0 || klok > 23){
            myFailure("KlokkeOutOfBound");
            return;
        }

        System.out.println("Er vinduet åbent? Type: (Y/N)");
        String vindue = input.nextLine();
        if (!vindue.equalsIgnoreCase("Y") && !vindue.equalsIgnoreCase("N")){
            myFailure("VindueErForkertInput");
            return;
        }

        // Check for Nattilstand
        boolean nattilstand = false;
        if (klok <= 6 || klok >= 22){
            nattilstand = true;
            wishTemp = wishTemp - 1;
        }

        // Check for frostbeskyttelse
        boolean frostbeskyttelse = false;
        if (temp < 5){
            frostbeskyttelse = true;
        }

        // Grænserne for interval
        double upperBound = wishTemp+0.5;
        double lowerBound = wishTemp-0.5;

        String decision = "";
        if (frostbeskyttelse){
            decision="HEAT";
        } else if(vindue.equalsIgnoreCase("Y")){
            decision="HOLD";
        } else if (temp>=lowerBound && temp<=upperBound ){
            decision="HOLD";
        } else if (temp<upperBound){
            decision="HEAT";
        } else {
            decision="COOL";
        }

        myResult(decision, nattilstand, wishTemp);
    }


    public static void myFailure(String input) {

        switch (input) {
            case "TempOutOfBound":
                System.out.println("Input fejl: Din temperatur er ude for realistisk rekkevidde (Skal være mellem '-20/+80')");
                break;
            case "WishTempOutOfBound":
                System.out.println("Input fejl: Din ønskede temperatur er ude for realistisk rekkevidde (Skal være mellem '-20/+80'");
                break;
            case "KlokkeOutOfBound":
                System.out.println("Input fejl: Din klokke er ikke korrekt rekkevidde for tid i timer (Skal være mellem '0/24'");
                break;
            case "VindueErForkertInput":
                System.out.println("Input fejl: Du kan kun svare Y/N til on vinduet er åbent");
                break;
        }
    }

    public static void myResult(String input, boolean nattilstand, double wishTemp){

        switch(input){
            case "HOLD":
                System.out.println("--- Beslutning ---\nNatilstand: "+nattilstand+" (effektiv ønskede temperatur = "+wishTemp+"°C"+"\nHandling: HOLD");
                break;
            case "HEAT":
                System.out.println("--- Beslutning ---\nNatilstand: "+nattilstand+" (effektiv ønskede temperatur = "+wishTemp+"°C"+"\nHandling: HEAT");
                break;
            case "COOL":
                System.out.println("--- Beslutning ---\nNatilstand: "+nattilstand+" (effektiv ønskede temperatur = "+wishTemp+"°C"+"\nHandling: COOL");
                break;
        }
    }
}
