
import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        //Set<Character> letters = new TreeSet<>();
        Map<Character, Integer> letters = new TreeMap<>();

        for (int i = 0; i < text.length() ; i++) {
            letters.putIfAbsent(text.charAt(i), 0);
            letters.put(text.charAt(i), letters.get(text.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            System.out.println(String.format("%c: %d time/s", entry.getKey(), entry.getValue()));
        }
    }
}
