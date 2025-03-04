import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateElement {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        values.stream().distinct().forEach(System.out::println); // remove duplicates values
        Set<Integer> items = new TreeSet<>();
        System.out.println("---------------- duplicates values ---------------------");
        List<Integer> result = values.stream().filter(n -> !items.add(n)).collect(Collectors.toList());
        System.out.println(result);

        Set<Integer> x = new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 5));
        // Set<Integer> y = new HashSet<>(Set.of(1,2,3,4,5,6,7));
        // x.add(1);

        System.out.println(x);
        boolean re = x.add(5); // it will return true if already not exist otherwise false
        System.out.println(re);

        // find the duplicate
        List<Integer> val = Arrays.asList(1, 2, 3, 4, 5, 6, 5, 4);
        Set<Integer> dupValue = new HashSet<>();
        Set<Integer> output = val.stream().filter(n -> !dupValue.add(n)).collect(Collectors.toSet());
        System.out.println(output);

        // count
        int count = (int) val.stream().count();
        System.out.println("count is :" + count);

        // convert map into stream
        Map<Integer, String> map = new HashMap<>(
                Map.of(73, "Dines", 71, "Chayan", 20, "Prem", 22, "Thanuh", 54, "Doshanth"));
        map.entrySet().size();
        Stream<Map.Entry<Integer, String>> stream = map.entrySet().stream();
        System.out.println("stream:"+Arrays.toString(stream.toArray()));


//   to find the summation
        Optional<Integer> summationOfArray = val.stream().reduce((sum,element) -> sum+element);
        System.out.println("average of array:"+summationOfArray);
 // calculate the average
        double avg = val.stream().mapToDouble(Integer::doubleValue)
        .average()
        .orElse(0.0);
        System.out.println("average is:"+avg);
    // Write a Java program to convert a list of strings to uppercase or lowercase using streams.
    List<String> players = new ArrayList<>(List.of("Smith","Travis","Malinka","Asalanka"));
    players.stream().map(String::toUpperCase).forEach(System.out::println);
    List<String> playersUppercase = players.stream().map(String::toUpperCase).collect(Collectors.toList());
    System.out.println("-------------- players uppercase ----------------");    
    System.out.println(playersUppercase);

// Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
    int sumOfEvenNumbers = val.stream().filter(n -> n%2==0)
    .mapToInt(Integer::intValue)
    .sum();
    System.out.println("summation of even numbers:"+sumOfEvenNumbers);
    
    int sumOfOddNumbers = val.stream().filter(n -> n%2!=0)
    .mapToInt(Integer::intValue)
    .sum();
    System.out.println("summation of even numbers:"+sumOfOddNumbers);

}
}
