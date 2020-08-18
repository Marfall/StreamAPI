package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x%2 ==0;
        Function <Integer, Integer> squareFunction = x -> (int)Math.pow(x, 2);
        Consumer<Integer> sysoutConsumer = System.out::println;

        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2 == 0;
            }
        };

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random  = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> x * 3;
        System.out.println(unaryOperator.apply(3));

        BiPredicate<Integer, String> biPredicate = (number, str) -> number < 10 && str.length() > 5;

        System.out.println(biPredicate.test(7, "tessdfsdf"));

        BiFunction<Integer, String, String> biFunction = (number, str) -> number + " " +  str;

        System.out.println(biFunction.apply(7, "test"));

        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept("15", "in28minutes");

        IntToDoubleFunction intToDoubleFunction = (x) -> x;

        System.out.println(intToDoubleFunction.applyAsDouble(5));

    }
}
