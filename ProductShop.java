import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> shops = new TreeMap<>();

        String input = scan.nextLine();
        while (!"Revision".equals(input)){
            String[] token = input.split("\\s*,\\s+");
            String value = token[1] + " " + token[2];
            shops.putIfAbsent(token[0], new ArrayList<>());
            shops.get(token[0]).add(value);

            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : shops.entrySet()) {
            System.out.println(String.format("%s->", entry.getKey()));
            for (String s : entry.getValue()) {
                String[] temp = s.split("\\s+");
                String product = temp[0];
                double price = Double.parseDouble(temp[1]);
                System.out.println(String.format("Product: %s, Price: %.1f", product, price));
            }

        }
    }
}
