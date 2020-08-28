import java.util.*;

public class HandsCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> player = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"JOKER".equals(input)){
            String[] nameOthers = input.split(":\\s+");
            String name = nameOthers[0];
            String[] cards = nameOthers[1].split(",\\s+");
            player.putIfAbsent(name, new ArrayList<>());
            for (int i = 0; i < cards.length ; i++) {
                if (!player.get(name).contains(cards[i])){
                    player.get(name).add(cards[i]);
                }
            }

            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : player.entrySet()) {
            int sum = 0;
            for(String s : entry.getValue()){
                int power = 0;
                int type = 0;
                String[] token = s.split("");
                switch (token[0]){
                    case "A":
                        power = 14;
                        break;
                    case "K":
                        power = 13;
                        break;
                    case "Q":
                        power = 12;
                        break;
                    case "J":
                        power = 11;
                        break;
                    case "1":
                        if ("0".equals(token[1])){
                            power = 10;
                            token[1] = token[2];
                        }else {
                            power = 1;
                        }
                        break;
                    default:
                        power = Integer.parseInt(token[0]);
                        break;
                }
                switch (token[1]){
                    case "S":
                        type = 4;
                        break;
                    case "H":
                        type = 3;
                        break;
                    case "D":
                        type = 2;
                        break;
                    case "C":
                        type = 1;
                        break;
                }
                sum += type * power;
            }
            System.out.println(String.format("%s: %d", entry.getKey(), sum));
        }
    }
}
