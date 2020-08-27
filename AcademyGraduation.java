import java.math.BigDecimal;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        Map <String, List<Double>> scores = new TreeMap<>();
        //BigDecimal vlado = new BigDecimal();
        for (int i = 0; i < number ; i++) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(d -> Double.parseDouble(d)).toArray();
            scores.putIfAbsent(name, new ArrayList<>());
            for (int j = 0; j < grades.length; j++) {
                scores.get(name).add(grades[j]);
            }
        }
        for (Map.Entry<String, List<Double>> entry : scores.entrySet()) {

            double average = entry.getValue().stream().mapToDouble(d ->d).average().getAsDouble();
            String temp = average + "";

            System.out.println(String.format("%s is graduated with %s", entry.getKey(), temp));
        }
    }
}
