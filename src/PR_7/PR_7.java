package PR_7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PR_7 {
    public static void main(String[] args) {
        List<String> text = List.of("hello", "world", "a", "b", "c");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(convert(text, String::toUpperCase));
        System.out.println(convert(numbers, x -> x * x));
    }

    public static <S, T> List<T> convert(List<S> sourse, Function<S, T> func){
        return sourse.stream()
                .map(func)
                .collect(Collectors.toList());
    }
}