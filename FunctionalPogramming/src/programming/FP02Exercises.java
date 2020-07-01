package programming;

import java.util.List;

public class FP02Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9 , 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println(squareAndSum(numbers));
        System.out.println(cubeAndSum(numbers));
        System.out.println(sumOfOddNumbers(numbers));



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



}
