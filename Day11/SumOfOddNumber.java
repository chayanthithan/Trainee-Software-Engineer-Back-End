import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfOddNumber {
    public static void main(String[] args) {
        List<Integer> val = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 4);

        // summation of even numbers
        int sumOfEvenNumber = val.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("summation of even numbers:" + sumOfEvenNumber);

        // summation of odd numbers
        int SumOfOddNumber = val.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("summation of odd numbers:" + SumOfOddNumber);

//get all duplicate elements
        Set<Integer> tempStack = new HashSet<>();
        List<Integer> duplicate = val.stream().filter(n -> !tempStack.add(n)).collect(Collectors.toList());
        System.out.println("duplicate values in the list is:"+ duplicate);

//remove all duplicate elements
        List<Integer> withoutDuplicate = val.stream().distinct().collect(Collectors.toList());
        System.out.println(withoutDuplicate);
// Write a Java program to count the number of strings in a list that start with a specific letter using streams.
        List<String> nameContainer = Arrays.asList("chayan kumar","vikaram vetha","vinoth kanakasabai","Ajith pathma");
        List<String> numOfString = nameContainer.stream().filter(n -> n.startsWith("v")).collect(Collectors.toList());
        int countOfNames = (int)nameContainer.stream().filter(n -> n.startsWith("v")).count();
        System.out.println("name list which is start  with letter v:"+numOfString);
        System.out.println("count is:"+countOfNames);

        // Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        //assecending order  // we may or may not give this Comparator.naturalOrder()
        List<String> sortNamesAssec = nameContainer.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        //desscending order
        List<String> sortNamesDesc = nameContainer.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortNamesAssec);
        System.out.println(sortNamesDesc);

        //  Write a Java program to find the maximum and minimum values in a list of integers using streams.
        int maxVal = val.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("max value in the list:"+maxVal);
        
        int minVal = val.stream().mapToInt(Integer::intValue).min().orElse(0);
        System.out.println("min value in the list:"+minVal);
       
        //  Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        int secondSmall = val.stream()
                            .distinct()
                             .sorted()
                             .skip(1)
                             .findFirst()
                             .orElse(null);
        System.out.println("second smallest number in the list:"+secondSmall);

        int secondLargest = val.stream()
                            .distinct()
                             .sorted(Comparator.reverseOrder())
                             .skip(1)
                             .findFirst()
                             .orElse(null);
        System.out.println("second smallest number in the list:"+secondLargest);

        

    }
}