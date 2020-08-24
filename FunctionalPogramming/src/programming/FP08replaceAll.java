package programming;

import java.util.ArrayList;
import java.util.List;

public class FP08replaceAll {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        List<String> modifyableCourses  = new ArrayList<>(courses);

        modifyableCourses.replaceAll(str -> str.toUpperCase());

        System.out.println(modifyableCourses);


        modifyableCourses.removeIf(course -> course.length() < 6);

        System.out.println(modifyableCourses);

    }
}
