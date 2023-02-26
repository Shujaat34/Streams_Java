package functional_interfaces;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceDemo1 {
    public static void main(String[] args) {
        //Example 1
        //Finding Sum of Numbers.
        double total = Stream.of(1.1, 2.2, 3.3)
                //0.0 is starting point, a is running total and b is number we are passing in.
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total is " + total);
        //output: Total is 6.6

        System.out.println("====================================");
        //Example 2
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                //0 is starting point subtotal is running sum variable and element is new item passing in.
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);
        //output: 21

        System.out.println("====================================");
        //Example 3
        int totalSum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(totalSum);
        //output: 21

        System.out.println("====================================");
        //Example 4
        int productOfElements = IntStream
                .range(5, 12) // numbers from 5 to 11
                //firstNumber is the starting point.
                .reduce((firstNumber, secondNumber) -> firstNumber * secondNumber) // multiply 5 * 6 * 7 * 8 * 9 * 10 * 11
                .orElse(-1);
        // show the result returned by the reduce method
        System.out.println("The product of all the elements come in given range is: " + productOfElements);
        //output: 1166.5
        System.out.println("====================================");
        //Example 5
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String concatString = letters
                .stream()
                //empty quotes is starting point partial string is running concatenation String and element is new item passing in
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println(concatString);

        System.out.println("====================================");
        //Example 5
        //create list of invoices by using wrapper class
        List<Invoice> listOfInvoices = Arrays.asList(
                new Invoice("productA31", BigDecimal.valueOf(131), BigDecimal.valueOf(5)),
                new Invoice("productA32", BigDecimal.valueOf(121), BigDecimal.valueOf(3)),
                new Invoice("productA33", BigDecimal.valueOf(99), BigDecimal.valueOf(1.5))

        );
        //calculate price of the product
        BigDecimal sum = listOfInvoices
                .stream()
                .map(data -> data.getQTY().multiply(data.getPrice()))
                //BigDecimal.ZERO is the starting point  BigDecimal is running total and add is passing in item.
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // show the result returned by the reduce method
        System.out.println(sum);
    }
}


class Invoice {
    String invoiceNo;
    BigDecimal price;
    BigDecimal qty;

    public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
        this.invoiceNo = invoiceNo;
        this.price = price;
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQTY() {
        return qty;
    }
}
