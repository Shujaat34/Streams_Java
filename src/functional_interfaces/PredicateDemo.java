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
        System.out.println("==========================");
        //Example 3: A Grade Calculator marks greater than 90 and less than 100 is A1 GRADE.
        Predicate<Integer> marks_1 = x -> x > 90;
        Predicate<Integer> marks_2 = y -> y < 100;
        //There is also or function in it
        boolean result = marks_1.and(marks_2).test(94);
        if(result){
            System.out.println("You got A1 Grade");
        }
        /**
         * output:
         * You got A1 Grade
         */
        System.out.println("==========================");
        //Example 4: If a person's age is not equal to or greater than 18. He is not a Adult.
        Predicate<Integer> ageCheck = a -> a >= 18;

        //negate() is same like !=
        boolean isNotAdult = ageCheck.negate().test(20);
        if(isNotAdult){
            System.out.println("You are not Adult");
        }
        /**
         * output:
         * You are not Adult
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
