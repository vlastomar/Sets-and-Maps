import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> concert = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"End".equals(input)){
            Pattern patt = Pattern.compile("(?<name>[A-Za-z ]+){1,3} @(?<town>[A-Za-z ]+){1,3} (?<price>[0-9]+) (?<count>[0-9]+)");
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                String name = mat.group("name");
                String place = mat.group("town");
                int money = Integer.parseInt(mat.group("price")) * Integer.parseInt(mat.group("count"));
                concert.putIfAbsent(place, new LinkedHashMap<>());
                concert.get(place).putIfAbsent(name, 0);
                concert.get(place).put(name, concert.get(place).get(name) + money);
            }

            input = scan.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : concert.entrySet()) {
            System.out.println(entry.getKey());
           /* for(Map.Entry<String, Integer> nestedMap : entry.getValue().entrySet()){

            }*/
            entry.getValue().entrySet().stream()
                    .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(p -> {
                        System.out.println(String.format("#  %s -> %d", p.getKey(), p.getValue()));
                    });
        }
    }
}
