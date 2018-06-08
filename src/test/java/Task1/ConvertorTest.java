package Task1;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConvertorTest {
    private static Convertor convertor = new Convertor();

    @Test
    public void testConverteUSDToGrn() {
        double price = convertor.converteUSD(100, "grn");
        assertEquals(true,price < 2650.5);
    }

    @Test
    public void testConverteUSDToEur() {
        double price = convertor.converteUSD(100, "eur");
        assertEquals(true,price < 90);
    }

    @Test
    public void testConverteUSDToGbp() {
        double price = convertor.converteUSD(100, "gbp");
        assertEquals(true,price < 80);
    }
}