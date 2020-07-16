package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP03Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9 , 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");

        Integer sum = fiml(numbers);
        System.out.println(sum);

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);

        List<Integer> cubeNumbers = mapAndCreateNewList(numbers, x -> (int)Math.pow(x, 3));

        List<Integer> doubleNumbers = mapAndCreateNewList(numbers, x -> x + x);

        System.out.println(squaredNumbers);
        System.out.println(cubeNumbers);
        System.out.println(doubleNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                        .map(mappingFunction)
                        .collect(Collectors.toList());
    }


    public static Integer fiml(List<Integer> numbers) {

        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };
        return numbers.stream().reduce(0, sumBinaryOperator2);
    }


}
