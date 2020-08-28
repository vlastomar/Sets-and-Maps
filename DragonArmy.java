import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, TreeMap<String, String>> dragons = new LinkedHashMap<>();
        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            if ("null".equals(input[2])){
                input[2] = "45";
            }
            if ("null".equals(input[3])){
                input[3] = "250";
            }
            if ("null".equals(input[4])){
                input[4] = "10";
            }
            String status = input[2] + " " + input[3] + " " + input[4];
            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, "");
            dragons.get(type).put(name, status);
        }


        for (Map.Entry<String, TreeMap<String, String>> entry : dragons.entrySet()) {
            double healthSumAvr = 0.0;
            double damageSumAvr = 0.0;
            double armorSumAvr = 0.0;
            for(Map.Entry<String, String> nestedMap : entry.getValue().entrySet()){
                String[] token = nestedMap.getValue().split(" ");
                int damage = Integer.parseInt(token[0]);
                int health = Integer.parseInt(token[1]);
                int armor = Integer.parseInt(token[2]);
                damageSumAvr += damage * 1.00;
                healthSumAvr  += health * 1.00;
                armorSumAvr += armor * 1.00;
            }
            damageSumAvr = damageSumAvr / entry.getValue().size();
            healthSumAvr = healthSumAvr / entry.getValue().size();
            armorSumAvr = armorSumAvr / entry.getValue().size();
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", entry.getKey(), damageSumAvr, healthSumAvr, armorSumAvr ));
            entry.getValue().entrySet()
                    .forEach(p -> {
                        String[] token = p.getValue().split(" ");
                        String damage = token[0];
                        String health = token[1];
                        String armor = token[2];
                        System.out.println(String.format("-%s -> damage: %s, health: %s, armor: %s", p.getKey(), damage, health, armor));
                    });
        }
    }
}
