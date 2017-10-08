package Comp330_Project2.app.test;

import static org.junit.Assert.*;

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
        output = converterUtil(convertFahrenheitToCelsius(input);

        assertEquals()
    }

    @org.junit.Test
    public void convertCelsiusToFahrenheit() throws Exception {

    }

}