import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodingTest {
    public static List<Integer> foo(int length) {
        List<Integer> list = new ArrayList<>();
        boolean isDone = false;
        Random random = new Random();
        while (!isDone) {
            int r = random.nextInt(length) + 1;
            boolean isFound = false;
            for (int n : list)
                if (n == r) {
                    isFound = true;
                    break;
                }
            if (!isFound) list.add(r);
            if (list.size() == length) isDone = true;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(foo(15));
    }
}
