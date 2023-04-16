import java.util.Scanner;

class Decrypt {

    static StringBuilder key = new StringBuilder();
    static StringBuilder message = new StringBuilder();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        key.append(scan.nextLine());
        message.append(scan.nextLine());
        scan.close();

        decrypt(message.toString(), key.reverse().toString());
    }

    public static void decrypt(String message, String key){
        StringBuilder decMessage = new StringBuilder(message);


        for(int i = 0; i < key.length(); i++){
            int amount = Integer.parseInt(String.valueOf(key.charAt(i)));

            int end = amount+i;
            if(end > decMessage.length()){
                end = key.length();
            }
            decMessage.delete(i, end);
        }

        System.out.println("decrepted: " + decMessage.toString());

    }
}