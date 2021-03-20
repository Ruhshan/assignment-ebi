import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Question1 {

    private static ArrayList<String> findGroupA(HashMap<String, ArrayList<String>> network, HashMap<String, String> employer) {
        //Declaring a hashmap to keep track of visited nodes
        Map<String, Boolean> visited = new HashMap<>();
        //Declaring a hasmap to mark employees with common employer
        Map<String, Boolean> hasCommonEmployer = new HashMap<>();
        //Delaring a linked list to use as queue during traversing
        LinkedList<String> queue = new LinkedList<>();
        AtomicBoolean isFirst = new AtomicBoolean(true);

        //Iterating over network keyset
        network.keySet().forEach(k->{
            if(isFirst.get()){//Adding the first key to queue, marking the key as visited
                queue.add(k);
                visited.put(k, Boolean.TRUE);
                isFirst.set(false);
            }
            visited.put(k, Boolean.FALSE);//mark all other keys as unvisided
            hasCommonEmployer.put(k, Boolean.FALSE);//For initialization, marking all employee's common employer as false
        });


        while (queue.size() != 0){//Loop until queue is empty
            String employee = queue.poll();//poll a employee from queue

            network.get(employee).forEach(friend->{//traverse through all friends of the emplyee

                if(employer.get(employee).equals(employer.get(friend))){//if the employee and the friend has common employer, mark them
                    hasCommonEmployer.replace(employee, Boolean.TRUE);
                    hasCommonEmployer.replace(friend, Boolean.TRUE);
                }

                if(!visited.get(friend)){//if the friend node is unvisided make it visited and add to queue to explore it's breadth
                    visited.replace(friend, Boolean.TRUE);
                    queue.add(friend);
                }

            });
        }
        //Delcare an empty ArrayList
        ArrayList<String> groupA = new ArrayList<>();
        //Iterate through the key, value pair of hasCommonEmployer
        hasCommonEmployer.forEach((k, v)->{
            if(!v){//if value is false add the key, which is the name of employee to the list
                groupA.add(k);
            }
        });
        //return
        return groupA;
    }

    public static void main(String args[]){
        //Declaring a hashmap to contain the friend's network
        HashMap<String, ArrayList<String>> network = new HashMap<>();

        network.put("Alice", new ArrayList<>(List.of("Ben", "Carrie")));//Alice is friend with Ben And Carrie
        network.put("Ben", new ArrayList<>(List.of("Alice", "Carrie", "Eve", "Darcey")));
        network.put("Carrie", new ArrayList<>(List.of("Ben", "Eve", "Fred")));
        network.put("Darcey", new ArrayList<>(List.of("Ben", "Eve")));
        network.put("Eve", new ArrayList<>(List.of("Darcey", "Carrie", "Fred")));
        network.put("Fred", new ArrayList<>(List.of("Carrie", "Eve")));

        //Declaring a hashmap to contain the employee->employer map
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
