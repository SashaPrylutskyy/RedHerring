import java.util.Random;
import java.util.Scanner;

class Encrypt{
    private static String ukr = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public static void main(String[] args) {
        getUserInput();
    }
    static void genKey(String message){
        StringBuilder key = new StringBuilder();
        Random rand = new Random();

        int min = 1;
        int max = 9;
        for(int i = 0; i <= message.length(); i++){
            key.append(rand.nextInt(max - min) + min);
        }

        System.out.println("Ключ: " + key); // We use not reversed key to give it to user
        key.reverse();
        System.out.println("Reversed key: " + key); // Reserved key is used to encrypt and decrypt message
        encrypt(message, key.toString());
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

        System.out.printf("Підговтовка до шифрування. Провірка всіх данних:\n * повідомлення %s\n * ключ %s", message, key);

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

        System.out.println("\nЗашифроване повідомлення: " + result);
    }
}