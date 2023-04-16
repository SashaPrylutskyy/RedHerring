import java.util.Random;
import java.util.Scanner;

class Encrypt{
    static StringBuilder key = new StringBuilder();
    private static String ukr = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public static void main(String[] args) {
        getUserInput();
    }
    static void genKey(String message){
        Random rand = new Random();

        int min = 1;
        int max = 9;
        for(int i = 0; i <= message.length(); i++){
            key.append(rand.nextInt(max - min) + min);
        }

        encrypt(message, key.reverse().toString());
    }

    static void getUserInput(){
        System.out.println("Введіть повідомлення, щоб зашифрувати: ");
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        message = message.toLowerCase(); //lower case all the letters
        genKey(message);
    }

    static void encrypt(String message, String key){
        StringBuilder result = new StringBuilder();

        //generate rand id of the char
        Random rand = new Random();
        int min = 0;
        int max = 33;

        for(int i = 0; i < message.length(); i++){
            int amount = Integer.parseInt(String.valueOf(key.charAt(i))); // amount of null chars

            for (int n = 0; n < amount; n++){
                int id = rand.nextInt(max - min) + min;
                result.append(ukr.charAt(id));
            }
            result.append(message.charAt(i));
        }
        int amount = Integer.parseInt(String.valueOf(key.charAt(key.length()-1)));
        for (int n = 0; n < amount; n++){
            int id = rand.nextInt(max - min) + min;
            result.append(ukr.charAt(id));
        }

        showResult(result.toString());
    }
    static void showResult(String encMessage){

        System.out.println("KEY: " + key.reverse().toString());
        System.out.println("Encrypted message: " + encMessage);
    }
}