import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UseraLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> ip = new TreeMap<>();

        String input = scan.nextLine();
        while (!"end".equals(input)){
            String[] token = input.split("\\s+");
            String[] ipAdressArr = token[0].split("=");
            String ipAddress = ipAdressArr[1];
            String[] name = token[token.length - 1].split("=");
            String username = name[1];

            ip.putIfAbsent(username, new LinkedHashMap<>());
            /*if (ip.get(username).containsKey(ipAddress)){
                ip.get(username).put(ipAddress, ip.get(username).get(ipAddress) + 1);
            }else {
                ip.get(username).put(ipAddress, 1);
            }*/
            ip.get(username).putIfAbsent(ipAddress, 0);
            ip.get(username).put(ipAddress, ip.get(username).get(ipAddress) + 1);

            input = scan.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : ip.entrySet()) {
            System.out.println(entry.getKey() + ":" + " ");
            int[] counter = {0};
            entry.getValue().entrySet()
                    .forEach(p ->{
                        if (counter[0] < entry.getValue().size() - 1){
                            System.out.print(String.format("%s => %d, ", p.getKey(), p.getValue()));
                        }else{
                            System.out.println(String.format("%s => %d.", p.getKey(), p.getValue()));
                        }
                        counter[0]++;
                    });
        }
    }
}
