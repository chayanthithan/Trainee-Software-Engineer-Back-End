import java.util.Arrays;
import java.util.*;

public class StreamExercise03 {
    public static void main(String[] args) {
        
        List<String> values = Arrays.asList("Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last");
        Optional<String> firstValue = values.stream().findFirst();
        System.out.println("first value is:" + firstValue.get());

        Optional<String> name = values.stream().reduce((first, second) -> first);
        System.out.println(name);


    }

}