import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();
        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            System.out.print(String.format("%s -> %s (avg: %.2f)\n", entry.getKey(), valueList(entry.getValue()), getAverage(entry.getValue())));
        }
    }
    private static Double getAverage(List<Double> grades){
        return grades.stream().mapToDouble(m -> m).average().getAsDouble();
    }

    private static String valueList(List<Double> grades){
        return grades.stream()
                .map(m -> String.format("%.2f", m))
                .collect(Collectors.joining(" "));
    }
}
