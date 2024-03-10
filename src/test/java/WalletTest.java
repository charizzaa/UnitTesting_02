import org.example.Wallet;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all is called");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all is called");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each is called");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After all is called");
    }

    @Test
    public void testAddMoney() {
        Wallet dompet = new Wallet("Caca");
        dompet.addMoney(10000);
        dompet.addMoney(5000);

        assertEquals(1, dompet.getMoneys().get(10000).intValue());
        assertEquals(1, dompet.getMoneys().get(5000).intValue());

        System.out.println("Jumlah uang 10000 = " + dompet.getMoneys().get(10000));
        System.out.println("Jumlah uang 5000 = " + dompet.getMoneys().get(5000));

    }

    @Test
    public void testAddCoin() {
        Wallet dompet = new Wallet("John Doe");
        dompet.addCoin(500);
        dompet.addCoin(100);

        assertEquals(1, dompet.getCoins().get(500).intValue());
        assertEquals(1, dompet.getCoins().get(100).intValue());

        System.out.println("Jumlah koin 100 = " + dompet.getCoins().get(100));
        System.out.println("Jumlah koin 500 = " + dompet.getCoins().get(500));

    }

    @Test
    public void testAddCard() {
        Wallet dompet = new Wallet("John Doe");
        dompet.addCard("Debit");
        dompet.addCard("Tapcash");

        assertEquals(2, dompet.getCards().size());
        assertTrue(dompet.getCards().contains("Tapcash"));
        assertTrue(dompet.getCards().contains("Debit"));

        System.out.println("Daftar kartu = " + dompet.getCards());

    }

    @Test
    public void testTakeMoneys() {
        Wallet dompet = new Wallet("John Doe");

        dompet.addMoney(1000);
        dompet.addMoney(50000);
        dompet.addMoney(100000);

        dompet.takeMoney(1000);
        dompet.takeMoney(50000);

        assertEquals(0, dompet.getMoneys().get(1000).intValue());
        System.out.println("Jumlah uang setelah pengambilan = " + dompet.getMoneys());

    }
    @Test
    public void testTakeCoins() {
        Wallet dompet = new Wallet("John Doe");

        dompet.addCoin(100);
        dompet.addCoin(500);
        dompet.addCoin(1000);

        dompet.takeCoin(100);
        dompet.takeCoin(1000);

        assertEquals(0, dompet.getCoins().get(100).intValue());
        System.out.println("Jumlah koin setelah pengambilan = " + dompet.getCoins());
    }

    @Test
    public void testTakeCard() {
        Wallet dompet = new Wallet("John Doe");


        dompet.addCard("Credit");
        dompet.addCard("Debit");
        dompet.addCard("Tapcash");

        dompet.removeCard("Debit");

        assertEquals(2, dompet.getCards().size());
        assertTrue(dompet.getCards().contains("Credit"));
        assertFalse(dompet.getCards().contains("Debit"));
        assertTrue(dompet.getCards().contains("Tapcash"));

        System.out.println("Daftar kartu setelah pengambilan = " + dompet.getCards());
    }
    @Test
    public void testCalculateCoins() {
        Wallet dompet = new Wallet("John Doe");

        dompet.addCoin(200);
        dompet.addCoin(500);
        dompet.addCoin(1000);

        assertEquals(1500, dompet.calculateCoins());
        System.out.println("Total koin = " + dompet.calculateCoins());
    }

    @Test
    public void testCalculateMoneys() {
        Wallet dompet = new Wallet("John Doe");

        dompet.addMoney(20000);
        dompet.addMoney(5000);
        dompet.addMoney(10000);

        assertEquals(35000, dompet.calculateMoneys());
        System.out.println("Total uang kertas = " + dompet.calculateMoneys());
    }

    @Test
    public void testGetMoneyAvailable() {
        Wallet dompet = new Wallet("John Doe");

        dompet.addCoin(100);
        dompet.addCoin(500);
        dompet.addCoin(1000);
        dompet.addCard("Tapcash");
        dompet.addMoney(1000);
        dompet.addMoney(50000);
        dompet.addMoney(100000);

        assertEquals(152600, dompet.getMoneyAvailable());
        System.out.println("Isi dompet " + dompet.getOwner() +": " + dompet.getMoneyAvailable() + " rupiah");
        System.out.println("Daftar kartu " + dompet.getOwner()+ ": " + dompet.getCards());
    }
}
