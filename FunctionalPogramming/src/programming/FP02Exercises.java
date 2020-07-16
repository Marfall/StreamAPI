package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9 , 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println(squareAndSum(numbers));
        System.out.println(cubeAndSum(numbers));
        System.out.println(sumOfOddNumbers(numbers));
        System.out.println(createlistWithEvenNumbersFromNumbersList(numbers));
        System.out.println(createListWithLengthsOfTitles(courses));



    }

    public static int squareAndSum(List<Integer> numbers) {
        return numbers.stream()
                .map(number-> (int)Math.pow(number, 2))
                .reduce(0, Integer::sum);
    }

    public static int cubeAndSum(List<Integer> numbers) {
        return numbers.stream()
                .map(number-> (int)Math.pow(number, 3))
                .reduce(0, Integer::sum);
    }

    public static int sumOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number%2 != 0)
                .reduce(0, Integer::sum);
    }

    public static List<Integer> createlistWithEvenNumbersFromNumbersList(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number%2 == 0)
                .collect(Collectors.toList());
    }

    public static List<String> createListWithLengthsOfTitles(List<String> cources) {
        return cources.stream()
                .map(course -> course + " " + course.length() + "\n")
                .collect(Collectors.toList());
    }
}
