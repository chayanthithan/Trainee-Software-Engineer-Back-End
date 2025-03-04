import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise2 {
    public static void main(String[] args) {
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream"));

        System.out.println(listOfList);

        List<String> result = listOfList.stream()
                .flatMap(List::stream)
                .filter(s -> s.startsWith("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);

        List<String> names = Arrays.asList("chayan", "doshanth", "dines", "thanush", "prem", "vithu", "santhan");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        names.stream().sorted().forEach(System.out::println);
        System.out.println("---------------- sorted names------------------");
        List<String> sortedNames = new ArrayList<>();
        names.stream().sorted().forEach(sortedNames::add);
        sortedNames.forEach(System.out::println);
    }
}
