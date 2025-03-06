import java.util.*;
import java.util.stream.Collectors;

public class IntegerStartWith1 {
    public static void main(String[] args) {
        List<Integer> val = Arrays.asList(1,11,43,23,21,15,100);
        List<String> result = val.stream()
                                 .map(n -> n.toString())
                                 .filter(n -> n.startsWith("1"))
                                 .collect(Collectors.toList());
        System.out.println(result);
        
        //     or

        List<String> result2 = val.stream()
        .map(n -> n+"")
        .filter(n -> n.startsWith("1"))
        .collect(Collectors.toList());
System.out.println(result2);
    }
}
