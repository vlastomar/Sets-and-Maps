import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> cardsFirst = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> cardsSecond = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50 ; i++) {
            if (cardsFirst.isEmpty() || cardsSecond.isEmpty()){

                break;
            }
            int firstNumber = cardsFirst.iterator().next();
            int secondNumber = cardsSecond.iterator().next();
            cardsFirst.remove(firstNumber);
            cardsSecond.remove(secondNumber);

          if (firstNumber > secondNumber){
              cardsFirst.add(firstNumber);
              cardsFirst.add(secondNumber);
          }else if (secondNumber > firstNumber){
              cardsSecond.add(secondNumber);
              cardsSecond.add(firstNumber);
          }

        }
        if (cardsFirst.size() < cardsSecond.size()){
            System.out.println("Second player win!");
        }else if (cardsSecond.size() < cardsFirst.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }


    }
}
