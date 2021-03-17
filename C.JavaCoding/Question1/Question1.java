import java.util.*;
import java.util.stream.Collectors;

public class Question1 {

    private static ArrayList<String> findGroupA(HashMap<String, ArrayList<String>> network, HashMap<String, String> employer) {
        Map<String, Boolean> hasCommonEmployer = network.keySet().stream().collect(Collectors.toMap(k -> k, k -> Boolean.FALSE));

        network.forEach((people, friends)->{
            if(!hasCommonEmployer.get(people)){
                friends.forEach(friend->{
                    if(employer.get(people).equals(employer.get(friend))){
                        hasCommonEmployer.replace(people, Boolean.TRUE);
                        hasCommonEmployer.replace(friend, Boolean.TRUE);
                    }
                });
            }
        });

        ArrayList<String> groupA = new ArrayList<>();

        hasCommonEmployer.forEach((k, v)->{
            if(!v){
                groupA.add(k);
            }
        });

        return groupA;
    }

    public static void main(String args[]){
        HashMap<String, ArrayList<String>> network = new HashMap<>();

        network.put("Alice", new ArrayList<>(List.of("Ben", "Carrie")));
        network.put("Ben", new ArrayList<>(List.of("Alice", "Carrie", "Eve", "Darcey")));
        network.put("Carrie", new ArrayList<>(List.of("Ben", "Eve", "Fred")));
        network.put("Darcey", new ArrayList<>(List.of("Ben", "Eve")));
        network.put("Eve", new ArrayList<>(List.of("Darcey", "Carrie", "Fred")));
        network.put("Fred", new ArrayList<>(List.of("Carrie", "Eve")));

        HashMap<String, String> employer = new HashMap<>();

        employer.put("Alice", "UCA");
        employer.put("Ben", "EBI");
        employer.put("Carrie", "OFC");
        employer.put("Darcey", "EBI");
        employer.put("Eve", "BioB");
        employer.put("Fred", "EBI");

        System.out.println(findGroupA(network, employer));
    }
}
