package streams_work;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java Streams is a feature introduced in Java 8 that is used for processing
 * collections of objects. Streams allow you to express common operations on collections,
 * such as filtering, mapping, sorting, and aggregating
 * <p>
 * Stream Source can be created from Collections, List, Set, Integer, Long, Double, Array, Lines of File.
 * Stream operations are either intermediate or Terminal.
 * <p>
 * Intermediate Operations - Such as filter, map, sort return a stream, so we can chain them
 * Terminal Operations - Such as forEach, collect or reduce are either void or return final result or non-stream-result.
 * <p>
 * filter(boolean) -> filter(Predicate) which is a simple boolean and return stream
 * map(Any Datatype or Object) -> map(Function) which is any Object and return stream
 */
public class StreamSolution {

    /**
     * Note: Stream once used then it can not be re-used again, so we close it. Whereas List can be re-used
     */

    public static void main(String[] args) throws IOException {
        //Prints Number from 1 to 9. Because Last Number in range function is exclusive
        IntStream.range(1, 10).forEach(x -> System.out.print(x + " "));
        //output: 1 2 3 4 5 6 7 8 9

        System.out.println();
        System.out.println("=================");
        //Skip from 1 to 5 and print onwards 6 to 9
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.print(x + " "));
        //output: 6 7 8 9

        System.out.println();
        System.out.println("=================");
        //Sum from 1 to 4 -> 1 + 2 + 3 + 4 = 10
        System.out.println(IntStream.range(1, 5).sum());
        //output: 10

        System.out.println("=================");
        //Sort the Names and find the First in Ascending Order Alphabet.
        Stream.of("Bunny", "Mason", "Ava")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        //output:Ava

        System.out.println("=================");
        String names[] = {"Jamal", "Abbas", "Raza", "Jameel", "Rehan", "Risha"};
        //x is a String. Get only the names starting with R and then sort them
        Arrays.stream(names).filter(x -> x.startsWith("R")).forEach(x -> System.out.print(x + " "));
        //output : Raza Rehan Risha

        System.out.println();
        System.out.println("=================");
        //Average of squares of int array -> 2*2 + 3*3 + 4*4 + 5*5 = 54/4 = 13.5
        int array[] = {2, 3, 4, 5};
        Arrays.stream(array)
                .map(x -> x * x) // Finding Square
                .average()// Getting Average
                .ifPresent(x -> System.out.print(x + " "));
        //output: 13.5

        System.out.println();
        System.out.println("=================");
        List<String> nameList = Arrays.asList("Suleman", "Seema", "Sara", "Zara", "Zainab");
        //Lowercase and then filter names with s and then sort them
        nameList
                .stream()
                .map(String::toLowerCase) // or we can also use map(x -> x.toLowerCase())
                .filter(x -> x.startsWith("s"))
                .sorted()
                .forEach(x -> System.out.print(x + " "));
        //output: sara seema suleman

        //This code Reads the Text File Line by Line and Return Stream
        System.out.println();
        System.out.println("=================");
        Stream<String> lines = Files.lines(Paths.get("bands.txt"));
        //Printing All the lines in the text File bands.txt
        lines.forEach(System.out::println);
        lines.close(); // Good Approach to Close a Stream when it is done.

        System.out.println();
        System.out.println("=================");
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        //Sort the bands and then print only the names of the bands which are greater than 13 characters.
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        //Note: Stream used once cannot be re-used again if we use bands it will give exception. Whereas List can be re-used
        bands.close();
        /** output:
         * Jackson Browne
         * Mumford and Sons
         * Rolling Stones
         */

        //Read the lines from the file and then store only the names containing "jit" in List so that we can re-use it.
        System.out.println();
        System.out.println("=================");
        List<String> bandList = Files.lines(Paths.get("bands.txt"))
                .filter(x -> x.contains("jit")) //contains jit
                .collect(Collectors.toList());
        bandList.forEach(System.out::println);
        //output: Arijit Singh

        System.out.println("=================");
        //Count the Rows in a CSV File. If a Row has 3 Columns then Count a row otherwise not.
        //In data.txt we have only five rows with proper 3 columns
        Stream<String> stLines = Files.lines(Paths.get("data.txt"));
        long count = stLines
                .map(x -> x.split(","))
                .filter(x -> x.length == 3) //x is Array of String.
                .count();
        System.out.println("Proper Rows " + count);
        stLines.close();
        //output: Proper Rows 5

        System.out.println("=================");
        //Read the data.txt file which contains a simple CSV data.
        //Print only those lines in which 2nd column Integer is greater than 15.
        Stream<String> stLines1 = Files.lines(Paths.get("data.txt"));
        System.out.println("Col1 Col2 Col3");
        stLines1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3) //x is Array of String.
                .filter((x -> Integer.parseInt(x[1]) > 15)) // because second column is Integer so x[1]>15
                .forEach(x -> System.out.println(x[0] + "     " + x[1] + "  " + x[2]));
        stLines1.close();
        /**
         * output:
         * Col1 Col2 Col3
         * B     17  2.8
         * D     23  2.7
         * F     18  3.4
         */


        System.out.println("=================");
        //Read the data.txt file which contains a simple CSV data.
        //Store First Column as Key and 2nd Column as Value in a Map and Print the Map.
        Stream<String> stLines2 = Files.lines(Paths.get("data.txt"));
        System.out.println("Key Value ");
        Map<String, Integer> map = stLines2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .collect(Collectors.toMap(
                        //Because x is an array of String
                        x -> x[0], //First Column -> Col1
                        x -> Integer.parseInt(x[1])  //Second Column -> Col2
                ));
        stLines2.close();
        //Printing Map
        for (Map.Entry<String, Integer> me : map.entrySet()) {
            // Printing keys
            System.out.println(me.getKey() + ":" + me.getValue());
        }
        /**
         * output:
         * Key Value
         * A:12
         * B:17
         * C:14
         * D:23
         * F:18
         */

        System.out.println("=================");
        //Reduction
        double total = Stream.of(1.1, 2.2, 3.3)
                .reduce(0.0, (Double a, Double b) -> a + b); //0.0 is starting point, a is running total and b is number we are passing in.
        System.out.println("Total is " + total);
        //output: Total is 6.6


        System.out.println("=================");
        //Find the Summary of 2,3,4,5
        //IntSummaryStatistics only works on Integers
        IntSummaryStatistics summary = IntStream.of(2, 3, 4, 5)
                .summaryStatistics();
        System.out.println(summary);
        //output: IntSummaryStatistics{count=4, sum=14, min=2, average=3.500000, max=5}

    }
}