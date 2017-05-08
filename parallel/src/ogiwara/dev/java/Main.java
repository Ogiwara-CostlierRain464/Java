package ogiwara.dev.java;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IntStream.range(1,10).parallel().forEach(System.out::println);
    }
}
