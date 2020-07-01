package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9 , 13, 4, 6, 2, 4, 12, 15);

        List<Integer> doubleNumbers = doubleList(numbers);
        System.out.println(doubleNumbers);

        int sum = addListFunctional(numbers);
        System.out.println(sum);
    }

    public static int addListFunctional(List<Integer> numbers) {
        return  numbers.stream()
                .reduce(0, (x, y) -> x + y);
    }

    public static List<Integer> doubleList(List<Integer> numbers) {
        Long count = numbers.stream()
                .map(number -> number * number).count();
        System.out.println("numbers " + count);
        return numbers.stream()
                .map(number -> number*number)
                .collect(Collectors.toList());
    }
}
