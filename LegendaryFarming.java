

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> farmings = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        farmings.putIfAbsent("fragments", 0);
        farmings.putIfAbsent("shards", 0);
        farmings.putIfAbsent("motes", 0);

        String input = scan.nextLine();
        boolean check250 = false;
        String legendary = "";
        while (true){

            String[] token = input.split("\\s+");
            for (int i = 0; i < token.length ; i+= 2) {
                String key = token[i + 1];
                key = key.toLowerCase();
                int quantity = Integer.parseInt(token[i]);
                if ("fragments".equals(key) || "shards".equals(key) || "motes".equals(key)){
                    //farmings.putIfAbsent(key, 0);
                    farmings.put(key, farmings.get(key) + quantity);
                    if (farmings.get(key) >= 250){
                        switch (key){
                            case "shards":
                                legendary = "Shadowmourne";
                                farmings.put(key, farmings.get(key) - 250);
                                break;
                            case "fragments":
                                legendary = "Valanyr";
                                farmings.put(key, farmings.get(key) - 250);
                                break;
                            case "motes":
                                legendary = "Dragonwrath";
                                farmings.put(key, farmings.get(key) - 250);
                                break;
                        }
                    }

                }else{
                    junk.putIfAbsent(key, 0);
                    junk.put(key, junk.get(key) + quantity);
                }
                if (!"".equals(legendary))   {
                    break;
                }
            }
            if (!"".equals(legendary))   {
                break;
            }

            input = scan.nextLine();
        }

        System.out.println(String.format("%s obtained!", legendary));
        farmings.entrySet().stream()
                .sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(p -> System.out.println(String.format("%s: %d", p.getKey(), p.getValue())));
        junk.entrySet().forEach(a -> System.out.println(String.format("%s: %d", a.getKey(), a.getValue())));
    }
}
