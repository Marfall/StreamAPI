package programming;

import java.util.List;

public class FP06IntermediateStreams {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

//            courses.stream()
//            .forEach(System.out::println);

            courses.stream()
               .peek(System.out::println)
                .filter(course -> course.length() > 9)
                .map(String::toUpperCase)
                //.peek(System.out::println)
                 .forEach(System.out::println);
                //.findFirst();

        courses.stream()
                .peek(System.out::println)
                .filter(course -> course.length() > 12)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();




    }
}
