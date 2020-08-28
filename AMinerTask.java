import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resource = scan.nextLine();
        while (!"stop".equals(resource)){
            int quantity = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + quantity);

            resource = scan.nextLine();
        }

        resources.entrySet().forEach(p -> {
            System.out.println(String.format("%s -> %s", p.getKey(), p.getValue()));
        });
    }
}
