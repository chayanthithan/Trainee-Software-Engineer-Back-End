
import java.util.*;
import java.util.stream.Collectors;

public class StreamExercise{
    public static void main(String []args){
        // Stream<String> stream;
        List<String> movies = new ArrayList<>();
// Here T is either a class, object, or data type depending upon the declaration.

        List<String> names = Arrays.asList("chayan","kamal","vimal","dines","doshan","prem","thanush");
        names.stream().forEach((name) -> System.out.print(" "+ name));
        names.stream().forEach(System.out::print);

        System.out.println("------------- forEach---------------");
        List<String> phoneBrands = Arrays.asList("Apple","Samsung","Vivo","Oppo","Huwawei");
        phoneBrands.stream().forEach(System.err::println);
        System.out.println("-------------filter , collect---------------");
        phoneBrands.stream().filter(brands -> brands.startsWith("A"))
        .collect(Collectors.toList())
        .forEach(System.out::println);
        
        System.out.println("-------------reduce---------------");

        String concateBrands = phoneBrands.stream().reduce("",(partialString,element) -> partialString+element);
        System.out.println(concateBrands.trim());

        Long count = phoneBrands.stream().count();
        System.out.println(count);

        Optional<String> firstName = phoneBrands.stream().findFirst();
        // System.out.println(firstName);
        firstName.ifPresent(System.out::println);
        // or
        firstName.ifPresent((brand) -> System.out.println(brand));
    
        boolean allStartWithS = phoneBrands.stream().allMatch(name -> name.startsWith("S"));
        System.out.println(allStartWithS);

        boolean anyStartWithS = phoneBrands.stream().anyMatch(
            name -> name.startsWith("S")
        );
        System.out.println(anyStartWithS);

    }
}