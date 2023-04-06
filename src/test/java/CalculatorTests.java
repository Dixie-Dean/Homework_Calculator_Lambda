import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTests {
    Calculator calculator = new Calculator();

    @Test
    public void plusTest() {
        //given
        int expected = 25, a = 10, b = 15;

        //act
        int result = calculator.plus.apply(a, b);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void powTest(int number, int expected) {
        //act
        int result = calculator.pow.apply(number);

        //assert
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(5, 25),
                Arguments.of(-8, 64),
                Arguments.of(10, 100)
        );
    }

    @Test
    public void divideTest() {
        //given
        int a = 10, b = 5;

        //act
        int result = calculator.divide.apply(a, b);
        Executable executable = () -> calculator.divide.apply(a, b);

        //assert
        Assertions.assertDoesNotThrow(executable);
    }
}
