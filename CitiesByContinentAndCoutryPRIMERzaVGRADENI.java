
import java.util.*;

public class CitiesByContinentAndCoutryPRIMERzaVGRADENI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, LinkedHashMap<String, List<String>>> countryCities = new LinkedHashMap<>();
        //Map<String, List<String >> continentCountry = new LinkedHashMap<>();
        int number = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String continent  = input[0];
            String country = input[1];
            String city = input[2];
            //continentCountry.putIfAbsent(continent, new ArrayList<>());
           // continentCountry.get(continent).add(country);
            countryCities.putIfAbsent(continent, new LinkedHashMap<>());
            countryCities.get(continent).putIfAbsent(country, new ArrayList<>());
            countryCities.get(continent).get(country).add(city);
        }
        int count = 0;

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : countryCities.entrySet()) {
            System.out.println(entry.getKey() + ":");
             entry.getValue().entrySet()
                     .stream()
                     .forEach(p ->{
                         System.out.printf("%s -> ", p.getKey());
                         String temp = "";
                         int[] counter = {0};
                         for(String s : p.getValue()){
                              int tempInt = entry.getValue().get(p.getKey()).size();
                              if (counter[0] < tempInt - 1){
                                  System.out.print(s + ", ");
                              }else{
                                  System.out.println(s);
                              }
                              counter[0]++;

                         }
                         //System.out.println();


                     });
        }


    }
}
