 import java.util.Map;
 import java.util.Scanner;
 import java.util.TreeMap;

 public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, TreeMap<String, Integer>> ip = new TreeMap<>();

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String[] token = scan.nextLine().split("\\s+");
            String ipAddress = token[0];
            String name = token[1];
            int duration = Integer.parseInt(token[2]);
            ip.putIfAbsent(name, new TreeMap<>());
            ip.get(name).putIfAbsent(ipAddress, 0);
            ip.get(name).put(ipAddress, ip.get(name).get(ipAddress) + duration);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : ip.entrySet()) {
            int sum = 0;
            for(Map.Entry<String, Integer> innerMap : entry.getValue().entrySet()){
                sum += innerMap.getValue();
            }
            System.out.print(String.format("%s: %d [", entry.getKey(), sum));
            int temp = 0;
            for(Map.Entry<String, Integer> innerMap : entry.getValue().entrySet()){
                if (temp < entry.getValue().size() - 1){
                    System.out.print(innerMap.getKey() + ", ");
                }else {
                    System.out.print(innerMap.getKey());
                }
                temp++;
            }
            System.out.println("]");

        }
    }
}
