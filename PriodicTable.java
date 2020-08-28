import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        Set<String>  elements = new TreeSet<>();

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int j = 0; j < input.length ; j++) {
                elements.add(input[j]);
            }
        }
        for(String s : elements){
            System.out.print(s + " ");
        }
    }
}
