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

    /**
     * Предоставляет тестовые данные и задаёт читаемое имя для каждого набора параметров.
     */
    @Parameters(name = "Пол: {0}, Ожидаемое наличие гривы: {1}")
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
    public void testDoesHaveMane_shouldMatchExpectedValue() {
        boolean actualMane = lion.doesHaveMane();
        assertEquals(expectedMane, actualMane);
    }

    @Test
    public void testGetKittens_shouldReturnDefaultCount() {
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetFood_returnsExpectedDietList() throws Exception {
        when(mockPredator.eatMeat())
                .thenReturn(List.of("Олень", "Буйвол"));

        List<String> food = lion.getFood();

        assertEquals(List.of("Олень", "Буйвол"), food);
    }

    @Test
    public void testGetFood_verifiesEatMeatCalledOnce() throws Exception {
        when(mockPredator.eatMeat())
                .thenReturn(List.of());

        lion.getFood();

        verify(mockPredator).eatMeat();
    }

    @Test
    public void testConstructor_withInvalidSex_shouldThrowException() {
        mockPredator = mock(Predator.class);

        try {
            new Lion(mockPredator, "Неизвестный");
            fail("Ожидалось исключение при неверном значении пола");
        } catch (Exception e) {
            assertEquals(
                    "Используйте допустимые значения пола животного — самец или самка",
                    e.getMessage()
            );
        }
    }
    @Test
            public void testGetKittens_zero () {
                int kittens = lion.getKittens(0);
                assertEquals(0, kittens);
            }

            @Test
            public void testGetKittens_maxAllowed () {
                int kittens = lion.getKittens(10);
                assertEquals(10, kittens);
            }

            @Test(expected = IllegalArgumentException.class)
            public void testGetKittens_negativeCount () {
                lion.getKittens(-1);
            }

            @Test(expected = IllegalArgumentException.class)
            public void testGetKittens_exceedsMax () {
                lion.getKittens(11);
            }

            @Test
            public void testGetKittens_defaultReturnsOne () {
                int kittens = lion.getKittens();
                assertEquals(1, kittens);
            }

        }

