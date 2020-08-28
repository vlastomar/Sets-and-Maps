import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String name = scan.nextLine();
        while (!"stop".equals(name)){
            String email = scan.nextLine();
            Pattern patt = Pattern.compile("(?<com>.com)|(?<us>.us)|(?<uk>.uk)");
            Matcher mat = patt.matcher(email);
            boolean check = true;
            while (mat.find()){
                check = false;
            }
            if (check){
                emails.putIfAbsent(name, "");
                emails.put(name, email);
            }
            name = scan.nextLine();
        }
        emails.entrySet().forEach(p ->{
            System.out.println(String.format("%s -> %s", p.getKey(), p.getValue()));
        });

    }
}
