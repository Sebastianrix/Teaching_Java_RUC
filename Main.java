import java.util.Scanner;
        
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] inputArray = new int[24];
        
        for (int x = 0; x < inputArray.length; x++) {
            inputArray[x] = scanner.nextInt();
        }
        
        
        for (int y = 0; y < inputArray.length; y++) {
              System.out.println(y+". List is as this :"+inputArray[y]);
            }
        }
    }

