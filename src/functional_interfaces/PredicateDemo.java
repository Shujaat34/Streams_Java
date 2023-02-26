package functional_interfaces;

import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate Functional Interface is used - To check Conditional check.
 * Predicate takes value as argument and return value in boolean.
 * Predicate -> boolean test(T t).
 */
public class PredicateDemo {
    public static void main(String[] args) {
        //Example 1 : Find a number greater or less than 10.
        Predicate<Integer> predicate = b -> b > 10;
        boolean isGreater = predicate.test(5);
        if (isGreater) {
            System.out.println("The Number is Greater than "+10);
        } else {
            System.out.println("The Number is Less than "+10);
        }
        //output: The Number is Less than 10

        System.out.println("==========================");
        //Example 2 : find Even and Odd Number
        //In Stream filter() method takes predicate as parameter
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        List<Integer> list = List.of(2, 3, 4, 5);
        list.stream().filter(isEvenPredicate).forEach(x -> System.out.println("The Number is Even "+x));
        /**
         * output:
         * The Number is Even 2
         * The Number is Even 4
         */

    }
}

/**
 * This is the Simplest Example For Predicate Functional Interface
 *
 *public class functional_interfaces.PredicateDemo implements Predicate<Integer> {
 *     public static void main(String[] args) {
 *         functional_interfaces.PredicateDemo demo = new functional_interfaces.PredicateDemo();
 *         boolean isEven = demo.test(2);
 *         if(isEven){
 *             System.out.println("The Number is Even");
 *         }else {
 *             System.out.println("The Number id Odd");
 *         }
 *     }
 *
 *     //Let's Check if the Number is Even
 *     @Override
 *     public boolean test(Integer integer) {
 *         if (integer % 2 == 0) {
 *             return true;
 *         }
 *         return false;
 *     }
 * }
 */
