package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP09Files {

    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get("file.txt"))
                .map(str -> str.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .distinct()
                .sorted()
                .forEach(System.out::println);


        Files.list(Paths.get("."))//root of the project
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
