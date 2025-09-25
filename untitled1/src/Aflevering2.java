import java.util.Scanner;


public class Aflevering2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hvad er din temperatur?");
        float temp = input.nextFloat();
        if (temp < -20 || temp > 80){ myResult("TempOutOfBound");}

        System.out.println("Hvad er klokken?");
        int klok = input.nextInt();
        input.nextLine();
        if (klok < 0 || klok > 24){ myResult("KlokkeOutOfBound");}

        System.out.println("Er vinduet åbent? Type: (Y/N)");
        String vindue = input.nextLine();
        if (vindue != "Y" || vindue != "y" || vindue != "N" || vindue != "n"){ myResult("VindueErForkertInput");}

        System.out.println("Hvilen temperatur ønsker du?");
        float wishTemp = input.nextFloat();
        if (wishTemp <-20 || wishTemp > 80){ myResult("WishTemp");}

        boolean Nattilstand = false;

        if (klok < 6 && klok > 22){
            Nattilstand = true;
            wishTemp = wishTemp - 1;
        }



        String decision = "";
        if (wishTemp-0.5<=temp || wishTemp+0.5<=temp && wishTemp-0.5>=temp || wishTemp+0.5>=temp){decision="HOLD";}
        if (wishTemp-0.5<=temp || wishTemp+0.5<=temp){decision="HEAT";}
        if (wishTemp-0.5>=temp || wishTemp+0.5>=temp){decision="COOL";}



        myResult(decision);



    }





       // System.out.println("Temp : "+temp+"\nKlokken : "+klok+"\nNattilstand : "+Nattilstand+"\nVindue : "+vindue+"\nØnsket temp : "+wishTemp);
         public static void myResult(String input){


        switch(input){
            case "HOLD":
                System.out.println("--- Beslutning ---\nNatilstand: "+Nattilstand+" (effektiv ønskede temperatur = "+wishTemp+".0°C"+"\nHandling: HOLD");
                break;
            case "HEAT":
                System.out.println("--- Beslutning ---\nNatilstand: "+Nattilstand+" (effektiv ønskede temperatur = "+wishTemp+".0°C"+"\nHandling: HEAT");
                break;
            case "COOL":
                System.out.println("--- Beslutning ---\nNatilstand: "+Nattilstand+" (effektiv ønskede temperatur = "+wishTemp+".0°C"+"\nHandling: HOLD");
                break;
            case "TempOutOfBound":
                System.out.println("Input fejl: Din temperatur er ude for realistisk rekkevidde (Skal være mellem '-20/+80'");
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
}
