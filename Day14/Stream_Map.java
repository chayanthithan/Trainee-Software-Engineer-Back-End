import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Map{
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1,2,3,4,5,6,5,4,3,2,1));
        System.out.println(nums);
        System.out.println("---------------------------------------------------------");
        List<Integer> result = nums.stream().map((in,sum) -> (sum+in)).toList();
        System.out.println(result);
    }
}