import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phones  = new HashMap<>();

        String input = scan.nextLine();
        while (!"search".equals(input)){
            String[] token = input.split("-");
            phones.putIfAbsent(token[0], "");
            phones.put(token[0], token[1]);

            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!"stop".equals(input)){
            if (phones.containsKey(input)){
                System.out.println(String.format("%s -> %s", input, phones.get(input)));
            }else{
                System.out.println(String.format("Contact %s does not exist.", input));
            }
        input = scan.nextLine();
        }
    }
}
