import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class Exercise{
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,3,6,9,13,15,1,2,3);
        BiFunction<Integer,Integer,Integer> add = (a,b) -> a + b;
        System.out.println(add.apply(10, 5));

        // 2. Write a Java 8 program to filter and print even numbers from a list.
        List<Integer> result = values.stream().filter(n -> n%2==0).toList();
        System.out.println(result);
        // Write a Java 8 program to map integers to their squares and print results.
        List<Integer> squareValues = values.stream().map(n -> n*n).toList();
        System.out.println(squareValues);
        // Write a Java 8 program to find and print the maximum value from a list.
        System.out.println(values.stream().mapToInt(Integer::valueOf).min());
        System.out.println(values.stream().mapToInt(Integer::valueOf).max()); //---------   way 1
        System.out.println(values.stream().max(Integer::compareTo).get());     //--------   way 2


        //  Write a Java 8 program to print distinct elements from a list of integers.
        values.stream().distinct().forEach(System.out::println);

        // Write a Java 8 program to print names sorted in alphabetical order from a list.
        System.out.println("---------- sort------------");
        List<String> names = Arrays.asList("Doshan","Dines","Chayan","Kumar","Chanakyan");
        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // optional
        Optional<List<String>> sizes = Optional.of(Arrays.asList("S","M","L","XL","XXL"));
       
    }
}