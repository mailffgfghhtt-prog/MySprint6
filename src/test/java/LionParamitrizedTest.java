import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class LionParamitrizedTest {
    @Parameter
    public String sex;
    @Parameter(1)
    public boolean expectedMane;
    private Lion lion;
    private Feline mockFeline;
    @Parameters(name = "Пол: {0}, Ожидаемое наличие гривы: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }
    @Before
    public void setUp() {
        mockFeline = mock(Feline.class);
        lion = new Lion(mockFeline, sex);
    }
    @Test
    public void testDoesHaveManeShouldMatchExpectedValue() {
        boolean actualMane = lion.doesHaveMane();
        assertEquals(expectedMane, actualMane);
    }
}