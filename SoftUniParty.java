import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> guests= new TreeSet<>();
        Set<String> guestsParty = new TreeSet<>();
        List<String> guestNotParty = new ArrayList<>();

        String input = scan.nextLine();
        while (!"PARTY".equals(input)){
            if (input.length() == 8){
                guests.add(input);
            }


            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!"END".equals(input)){
            if (input.length() == 8){
                guestsParty.add(input);
            }


            input = scan.nextLine();
        }
        for (String guest : guests) {
            if (!guestsParty.contains(guest)){
                guestNotParty.add(guest);
            }
        }
        System.out.println(guestNotParty.size());
        for (int i = 0; i < guestNotParty.size() ; i++) {
            System.out.println(guestNotParty.get(i));
        }
    }
}
