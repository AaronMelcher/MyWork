package collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class CollectionsInClass {

    private static <T> List<T> removeDuplicates(List<T> of) {
        return of.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String expression = "Let'see see if this if works with works see if that cool and epic sentence epic and cool sentence";
        List<String> words = Arrays.asList(expression.split(" "));
        System.out.println(removeDuplicates(words));
    }
}
