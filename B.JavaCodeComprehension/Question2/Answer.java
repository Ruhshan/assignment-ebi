import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {
    public static List<Integer> foo(int length) {
        List<Integer> list = IntStream.rangeClosed(0, length).boxed().collect(Collectors.toList());

        Collections.shuffle(list);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(foo(10));
    }
}

