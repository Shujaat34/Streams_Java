package functional_interfaces;

import java.util.List;
import java.util.function.Consumer;

/**
 * ----Types of Interface -----
 * 1. Normal Interface - contains list of abstract methods that must be implemented by class implementing that interface.
 * 2. Functional Interface or (SAM) Single Abstract Method - contains only one abstract method.
 *    E.g. Runnable –> This interface only contains the run() method.
 *         Comparable –> This interface only contains the compareTo() method.
 *         ActionListener –> This interface only contains the actionPerformed() method.
 *         Callable –> This interface only contains the call() method.
 *
 * 3. Marker Interface - does not contain any methods or fields. Empty Interface.
 *    It serves as a marker to indicate that a class implementing the interface has a certain capability or property.
 *    E.g. Serializable interface is a marker interface that indicates that a class can be serialized,
 *    i.e., converted to a sequence of bytes that can be stored and later restored to its original state.
 *    Cloning: The Cloneable interface is a marker interface that indicates that a class can be cloned,
 *    i.e., duplicated by creating a new object with the same state as the original object.
 *    marker interfaces work as a label or Tag for the compiler and Compiler detects them easily If it doesn't contain any method.
 *
 * 4.Default Method Interface - contains one or more default methods. Default methods were introduced in Java 8 to allow interfaces to have concrete methods without breaking compatibility with existing code.
 *
 */

/**
 * ====================================================
 * Consumer Functional Interface is used - when an object is to be consumed. Take input and operation is performed without
 * returning a value
 * Consumer -> void accept(T t).
 */

public class ConsumerDemo {
    public static void main(String[] args) {
        //Example 1
        Consumer<Integer> consumer = t -> System.out.println("The number is "+t);
        //Calling the accept method
        consumer.accept(125);
        //output: The number is 125

        //Example 2
        //In Stream forEach() method takes consumer as parameter
        System.out.println("==================");
        Consumer<Integer> con = x -> System.out.println("List of Num : "+x);
        List<Integer> list = List.of(2, 3, 4, 5);
        list.stream().forEach(con);
        /**
         * output:
         * List of Num : 2
         * List of Num : 3
         * List of Num : 4
         * List of Num : 5
         */
    }
}

/**
 * This is the Simplest Example For Consumer Functional Interface
 *
     * public class functional_interfaces.ConsumerDemo implements Consumer<Integer> {
     *     public static void main(String[] args) {
     *         functional_interfaces.ConsumerDemo demo = new functional_interfaces.ConsumerDemo();
     *         demo.accept(5);
     *     }
     *
     *     @Override
     *     public void accept(Integer integer) {
     *         System.out.println("The Number is "+integer);
     *     }
     * }
 */
