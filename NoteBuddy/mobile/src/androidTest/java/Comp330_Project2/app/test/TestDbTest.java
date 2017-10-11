package Comp330_Project2.app.test;

//import static org.junit.Assert.*;

/**
 * Created by jorgeramirez on 10/8/17.
 */
public class TestDbTest {
    @org.junit.Test
    public void convertFahrenheitToCelsius() throws Exception {
        float input = 212;
        float output;
        float expected = 100;
        double delta = .1;

        ConverterUtil converterUtil = new ConverterUtil();
        output = converterUtil.convertCelsiusToFahrenheit(input);

        assertEquals(expected, output, delta);
    }

    @org.junit.Test
    public void convertCelsiusToFahrenheit() throws Exception {
        float input = 100;
        float output;
        float expected = 212;
        double delta = .1;


    }

}