import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String input = scan.nextLine();
        while (!"END".equals(input)){
            String[] token = input.split("\\s*,\\s+");
            String action = token[0];
            String carNumber = token[1];
            switch (action){
                case "IN":
                    cars.add(carNumber);
                    break;
                case "OUT":
                    if (cars.contains(carNumber)){
                        cars.remove(carNumber);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car : cars) {
                System.out.println(car);
            }
        }


    }
}
