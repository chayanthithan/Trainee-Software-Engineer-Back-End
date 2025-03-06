import java.util.*;
import java.util.stream.Collectors;
public class ReverseEachWords {
    public static void main(String[] args) {
        String str = "Hello this is chayan";
        String tempStr[] = str.split(" ");
        
        List<StringBuilder> reversedString = Arrays.stream(tempStr)
        .map(n -> new StringBuilder(n).reverse())
        .collect(Collectors.toList());
        reversedString.forEach(System.out::println);
    }
}
