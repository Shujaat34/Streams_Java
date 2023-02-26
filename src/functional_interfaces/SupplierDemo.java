package functional_interfaces;

import java.util.List;
import java.util.function.Supplier;

/**
 * Supplier Functional Interface is used - when we get a value.
 * Supplier -> No Input but only return value (output).
 * Supplier -> T get();
 */
public class SupplierDemo {
    public static void main(String[] args) {
        //Example 1: Because Supplier does not recieve a value as argument therefore no "x -> x" but we return a value only
        Supplier<String> supplier = () -> "Beautiful World";
        System.out.println(supplier.get());

        System.out.println("==========================");
        //Example 2: If the List is Empty Print Ana if you find any element in List then print it.
        //Because it finds first Element non-emepty Jamica so prints it.
        List<String> list = List.of("Jamica","Rahul","Arslan");
        System.out.println(list.stream().findAny().orElse("Ana"));
        //output: Jamica

    }

}

/**
 * This is the Simplest Example For Supplier Functional Interface
 * public class functional_interfaces.SupplierDemo implements Supplier<String> {
 *     public static void main(String[] args) {
 *         functional_interfaces.SupplierDemo demo = new functional_interfaces.SupplierDemo();
 *         String s = demo.get();
 *         System.out.println(s);
 *     }
 *     @Override
 *     public String get() {
 *         return "Pakistan Zindabad";
 *     }
 * }
 */
