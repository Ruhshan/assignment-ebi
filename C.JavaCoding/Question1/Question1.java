import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Question1 {

    private static ArrayList<String> findGroupA(HashMap<String, ArrayList<String>> network, HashMap<String, String> employer) {
        Map<String, Boolean> visited = new HashMap<>();
        Map<String, Boolean> hasCommonEmployer = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        AtomicBoolean isFirst = new AtomicBoolean(true);

        network.keySet().forEach(k->{
            if(isFirst.get()){
                queue.add(k);
                visited.put(k, Boolean.TRUE);
                isFirst.set(false);
            }
            visited.put(k, Boolean.FALSE);
            hasCommonEmployer.put(k, Boolean.FALSE);
        });


        while (queue.size() != 0){
            String employee = queue.poll();

            network.get(employee).forEach(friend->{

                if(employer.get(employee).equals(employer.get(friend))){
                    hasCommonEmployer.replace(employee, Boolean.TRUE);
                    hasCommonEmployer.replace(friend, Boolean.TRUE);
                }

                if(!visited.get(friend)){
                    visited.replace(friend, Boolean.TRUE);
                    queue.add(friend);
                }

            });
        }

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
