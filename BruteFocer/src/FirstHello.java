

public class FirstHello {
    public static int car;
    public static int fuel;

    public static void main(String[] args){
        car = 1;
        fuel = 10;

        int plane;
        int Bike;

        plane = 500;
        Bike = 500;

        int[] transport = {plane,Bike,fuel,car};
        for(int x : transport){
            System.out.println(transport[x]);
        }
        System.out.println("Hello World!"+car+" "+fuel);
        System.out.println("Goodbye World!"+plane+" "+Bike);





        }
    }
