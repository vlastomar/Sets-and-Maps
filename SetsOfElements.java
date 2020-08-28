import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();
        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        chargeSets(scan, first, input[0]);
        chargeSets(scan, second, input[1]);

            if (first.size() >= second.size()){
                compareSets(first, second);
            }else {
                compareSets(second, first);
            }



    }

    private  static void chargeSets (Scanner scan, LinkedHashSet<Integer> map, int input){
        for (int i = 0; i < input ; i++) {
            int number = Integer.parseInt(scan.nextLine());
            map.add(number);
        }
    }
    private static void compareSets(LinkedHashSet<Integer> first, LinkedHashSet<Integer> second){
        Iterator<Integer> value = first.iterator();
        while (value.hasNext()){
            int temp = value.next();
            if (second.contains(temp)){
                System.out.print(temp +" ");
            }
        }
    }
}
