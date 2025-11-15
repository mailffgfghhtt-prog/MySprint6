import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;
public class LionTest {
    private Feline mockFeline;
    private Lion lion;
    @Before
    public void setUp() {
        mockFeline = mock(Feline.class);  // ИЗМЕНЕНО
        lion = new Lion(mockFeline, "Самец");  // ИЗМЕНЕНО
    }
    @Test
    public void testGetKittensShouldReturnDefaultCount() {
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }
    @Test
    public void testGetFoodReturnsExpectedDietList() throws Exception {
        when(mockFeline.eatMeat())  // ИЗМЕНЕНО: mockFeline вместо mockPredator
                .thenReturn(List.of("Олень", "Буйвол"));
        List<String> food = lion.getFood();
        assertEquals(List.of("Олень", "Буйвол"), food);
    }
    @Test
    public void testGetFoodVerifiesEatMeatCalledOnce() throws Exception {
        when(mockFeline.eatMeat())
                .thenReturn(List.of());
        lion.getFood();
        verify(mockFeline).eatMeat();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidSexShouldThrowException() {
        new Lion(mockFeline, "Неизвестный");
    }
    @Test
    public void testGetKittensZero() {
        int kittens = lion.getKittens(0);
        assertEquals(0, kittens);
    }
    @Test
    public void testGetKittensMaxAllowed() {
        int kittens = lion.getKittens(10);
        assertEquals(10, kittens);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetKittensNegativeCount() {
        lion.getKittens(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetKittensExceedsMax() {
        lion.getKittens(11);
    }
    @Test
    public void testGetKittensDefaultReturnsOne() {
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }
}