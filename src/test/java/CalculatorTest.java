import org.example.Calculator;
import org.junit.Test;
import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    @BeforeAll
    public void intilialize() {
        // This method will be executed only once before any test method in this class
        System.out.println("Before All is called");
    }

    @BeforeEach
    public void setup() {
        // This method will be executed before each test method in this class
        System.out.println("Before Each is called");
    }

    @AfterEach
    public void methodCleanup() {
        // This method will be executed after each test method in this class
        System.out.println("After Each is called");
    }

    @AfterAll
    public void classCleanup(){
        // This method will be executed only once after all test methods in this class have run
        System.out.println("After All is called");
    }

    public int result =0;
    @Test
    @Order(1)
    public void testTambah(){
        int angka =10;
        Calculator calculator = new Calculator(result, angka);
        result = calculator.tambah();
        Assertions.assertEquals(10,result);
    }

    @Test
    @Order(2)
    public void testKali10(){
        int kali = 10;
        Calculator calculator = new Calculator(result, kali);
        result = calculator.kali();
        Assertions.assertEquals(100,result);
    }


}