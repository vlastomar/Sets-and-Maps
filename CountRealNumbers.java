import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        for (double doubl : input) {
            numbers.putIfAbsent(doubl, 0);
            numbers.put(doubl, numbers.get(doubl) + 1);
        }
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
