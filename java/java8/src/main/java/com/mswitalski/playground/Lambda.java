package com.mswitalski.playground;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Playground for Java 8 - lambda expression feature.
 */
public class Lambda {

    // Lambda expressions might be defined and used in several ways:

    // as class field
    private final UnaryOperator<Long> lambdaSquareAsClassField = n -> n * n;

    // as variable declared inside a function
    public void lambdaAsTypicalVariable() {
        final Consumer<String> lambdaUppercaseConsolePrinter = s -> System.out.println(s.toUpperCase());
    }

    // passed as function parameter
    public void lambdaAsFunctionParameter(Supplier<Integer> numberSupplier) {
        final Integer numberTakenFromSupplier = numberSupplier.get();
    }

    // returned from a function
    public Function<Float, Integer> lambdaAsFunctionReturnValue() {
        return f -> Integer.valueOf(f.intValue());
    }

    // declared as type stored in a collection
    public List<Consumer<String>> lambdaAsCollectionType() {
        return Arrays.asList(
                str -> System.out.println(str.toUpperCase()),
                str -> System.out.println(str.toLowerCase())
        );
    }

    // returned from generic function
    public <T> BiConsumer<T, T> lambdaReturnedFromGenericFunction() {
        return (obj1, obj2) -> System.out.println(obj1.equals(obj2));
    }

    // lambda may use other variables
    public void lambdaUsingOtherVariable() {
        final String greeting = "Hello";
        final Function<String, String> lambdaUsingOtherVariable = str -> greeting + " " + str;
    }

    // for one parameter one can use parenthesis around lambda param (but it's optional)
    // * but for more than one parameter one must use parenthesis around lambda params
    public void lambdaWithParenthesis() {
        final Consumer<String> lambdaWithSingleParamNoParenthesis = in -> System.out.println(in.toLowerCase());
        final Consumer<String> lambdaWithSingleParamAndParenthesis = (in) -> System.out.println(in.toLowerCase());
        final BiConsumer<String, String> lambdaWithTwoParams = (str1, str2) -> System.out.println(str1 + str2);
//        final BiConsumer<String, String> invalidLambdaWithTwoParams = str1, str2 -> System.out.println(in.toLowerCase());
    }

    // optionally one can define type of lambda parameter
    // * parenthesis is mandatory, even for one parameter
    // * declared parameters types must be the same as type of variable/function parameter/function return value
    public void lambdaWithTypedParameters() {
        final Consumer<String> lambdaWithTypedParam = (String in) -> System.out.println(in.toLowerCase());
//        final Consumer<String> invalidLambdaWithTypedParam = String in -> System.out.println(in.toLowerCase());
        final BiConsumer<String, String> lambdaWithTwoTypedParams = (String str1, String str2) -> System.out.println(str1 + str2);
//        final BiConsumer<String, String> invalidLambdaWithTwoTypedParams = (String str1, str2) -> System.out.println(str1 + str2);
    }
}
