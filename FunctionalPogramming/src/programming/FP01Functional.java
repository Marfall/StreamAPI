package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9 , 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
//        printAllNumbersInListFunctional(numbers);
//        printEvenNumbersInListFunctional(numbers);
//        printOddNumbersInListFunctional(numbers);
//        printAllCoursesIndividually(courses);
//        printCoursesContainingWordSpring(courses);
//        printCoursesWhoseNameAtLeast4Letters(courses);
//        printSquaresOfEvenNumbersInListFunctional(numbers);
//        printCubesOfOddNumbersInListFunctional(numbers);
          printNumberOfCharactersInEachCourseName(courses);

    }

    private static void printCoursesWhoseNameAtLeast4Letters(List<String> courses) {
        courses.stream()
                .filter(x -> x.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCoursesContainingWordSpring(List<String> courses) {
        courses.stream()
                .filter(x -> x.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printAllCoursesIndividually(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        //Exercise 1 - Print only Odd Numbers from the List;
        numbers.stream()
                .filter(x -> x%2 != 0)
                .forEach(System.out::println);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 0)
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 0)
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 != 0)
                .map(number -> (int)Math.pow(number, 3))
                .forEach(System.out::println);
    }

    private static void printNumberOfCharactersInEachCourseName(List<String> courses) {
        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }
}
