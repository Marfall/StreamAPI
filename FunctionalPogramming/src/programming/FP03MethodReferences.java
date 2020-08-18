package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03MethodReferences {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API",
                "Microservices", "AWS", "PCF", "Azure",
                "Docker", "Kubernetes");

        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Supplier<String>  supplier  = String::new;
    }
}
