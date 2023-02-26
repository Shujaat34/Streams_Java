package functional_interfaces;

public class PredicateConsumerSupplier {
    /***
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


    public static void main(String[] args) {

    }


    public void forConsumer(Object obj){

    }

    /**
     * Predicate Functional Interface is used - To check Conditional check.
     * Predicate -> boolean test(T t).
     */
    public boolean forPredicate(){
        return true;
    }


    /**
     * Supplier Functional Interface is used - when we get a value.
     * Supplier -> No Input but only return value (output).
     * Supplier -> T get();
     */
    public Object forSupplier(){

        return new Object();
    }
}
