import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@RunWith(Parameterized.class)
public class LionTest {
    @Parameter
    public String sex;
    @Parameter(1)
    public boolean expectedMane;
    private Predator mockPredator;
    private Lion lion;
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }
    @Before
    public void setUp() throws Exception {
        mockPredator = mock(Predator.class);
        lion = new Lion(mockPredator, sex);
    }
    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedMane, lion.doesHaveMane());
    }
    @Test
    public void testGetKittens() {
        assertEquals(1, lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        when(mockPredator.eatMeat()).thenReturn(List.of("Олень", "Буйвол"));
        List<String> food = lion.getFood();
        assertEquals(List.of("Олень", "Буйвол"), food);
        verify(mockPredator).eatMeat();
    }
    @Test
    public void testConstructorInvalidSex() {
        mockPredator = mock(Predator.class);
        try {
            new Lion(mockPredator, "Неизвестный");
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного — самец или самка", e.getMessage());
        }
    }
}