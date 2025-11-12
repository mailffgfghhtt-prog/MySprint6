import com.example.Cat;
import com.example.Predator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;
public class CatTest {
    @Test
    public void testGetSound() {
        Cat cat = new Cat(mock(Predator.class));
        assertEquals("Мяу", cat.getSound());
    }
    @Test
    public void testGetFood() throws Exception {
        Predator mockPredator = mock(Predator.class);
        when(mockPredator.eatMeat()).thenReturn(List.of("Мыши"));
        Cat cat = new Cat(mockPredator);
        List<String> food = cat.getFood();
        assertEquals(List.of("Мыши"), food);
        verify(mockPredator).eatMeat();
    }
}