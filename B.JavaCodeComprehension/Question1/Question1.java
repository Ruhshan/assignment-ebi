import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Question1 {
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9).stream().filter(n->(n%3 == 0))
                .map(n->n*2).collect(Collectors.toList());
        System.out.println(numbers);
    }
}
