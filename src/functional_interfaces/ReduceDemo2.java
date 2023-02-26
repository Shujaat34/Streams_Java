package functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceDemo2 {
    public static void main(String[] args) {
        //Example 1
        List<String> studentList = Arrays.asList("Emma Watson", "Paul Walker", "Leesa",
                "James", "Lilly");
        //The reduce() method takes the lambda expression that take two string type values and returns a longer string
        //The Optional data is returned as a result from the reduce() method because the list can be empty on which reduce() method is called.
        Optional<String> newString = studentList
                .stream()
                // firstName is empty string
                .reduce((firstName, secondName) -> firstName.length() > secondName.length() ? firstName : secondName);
        // show the result returned by the reduce method
        newString.ifPresent(System.out::println);
        //output: Paul Walker

        //Example 2:
        System.out.println("=============================");

        List<String> countryList = Arrays.asList("Germany", "Switzerland", "France","Russia","China");
        //The reduce() method takes the lambda expression that take two string type values and returns a longer string
        //The Optional data is returned as a result from the reduce() method because the list can be empty on which reduce() method is called.
        Optional<String> country = countryList
                .stream()
                // firstName is empty string
                .reduce((country1, country2) -> country1.length() > country2.length() ? country1 : country2);
        // show the result returned by the reduce method
        country.ifPresent(System.out::println);

    }
}
