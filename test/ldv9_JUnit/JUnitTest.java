package ldv9_JUnit;

import org.junit.Test;
import static org.junit.Assert.*;

import static javafxapplication.FXMLDocumentController.completing;

public class JUnitTest {
        
    @Test
    public void test1FXML() throws Exception {
        assertTrue(completing(2, 2, 4) == 1.0);
        assertTrue(completing(10, 10, 10) == 4000.00);
        assertTrue("Проверка деления ", completing(3, 3, 5) == 0.5);
    }
    
    @Test
    public void test2FXML() throws Exception {
        try {
            assertTrue("Проверка деления на 0", completing(0, 0, 4) == 0);
            fail("Нет ошибки при делении на 0");
        } catch (Exception thrown) {
            assertNotEquals("", thrown.getMessage());
        }
        try {
            assertTrue("Проверка деления 0 на 0", completing(0, 0, 0) == 0);
            fail("Нет ошибки при делении 0 на 0");
        } catch (Exception thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

}
