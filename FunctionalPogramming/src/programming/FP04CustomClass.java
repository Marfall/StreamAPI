package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.CheckedOutputStream;

public class FP04CustomClass {
    public static void main(String[] args) {



        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 21000),
                new Course("Kubernetes", "Cloud", 91, 20000)

        );

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream()
                .allMatch(reviewScoreGreaterThan90Predicate));

        System.out.println(courses.stream()
                .noneMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream()
                .noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream()
                .anyMatch(reviewScoreGreaterThan90Predicate));

        Predicate<Course> coursePredicate = course -> course.getNumberOfStudents() > 17000;

        System.out.println(courses.stream()
                .anyMatch(coursePredicate));


        Comparator<Course> comparingByNoOfSudentsIncreasing = Comparator.comparing(Course::getNumberOfStudents);

        System.out.println(courses.stream()
                .sorted(comparingByNoOfSudentsIncreasing)
                .collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNumberOfStudents).reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing)
                .collect(Collectors.toList()));

        Comparator<Course>  comparingByNumberOfStudentsAndReviews = Comparator.comparing(Course::getNumberOfStudents)
                .thenComparing(Course::getReviewScore)
                .reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviews)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviews)
                .limit(5)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviews)
                .skip(3)
                .collect(Collectors.toList()));


        System.out.println(courses);

        System.out.println(courses.stream()
                .takeWhile(course ->  course.getReviewScore() >= 95)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .dropWhile(course ->  course.getReviewScore() >= 95)
                .collect(Collectors.toList()));


        System.out.println(courses.stream()
                .max(comparingByNumberOfStudentsAndReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        System.out.println(courses.stream()
                .min(comparingByNumberOfStudentsAndReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .findFirst());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .findAny());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .mapToInt(Course::getNumberOfStudents)
                .sum());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .mapToInt(Course::getNumberOfStudents)
                .average());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .mapToInt(Course::getNumberOfStudents)
                .max());


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));

    }
}

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;

    public Course(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return name +
                ":" + numberOfStudents +
                ":" + reviewScore;
    }
}