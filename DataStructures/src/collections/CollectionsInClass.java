package collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Scanner;

public class CollectionsInClass {

    private static <T> List<T> removeDuplicates(List<T> of) {
        return of.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a bunch of words any number of times:");
        String expression = input.nextLine();
        List<String> words = Arrays.asList(expression.split(" "));
        System.out.println(removeDuplicates(words));
        input.close();
    }
}
