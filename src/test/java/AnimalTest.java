import com.example.Animal;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
public class AnimalTest {
    private final Animal animal = new Animal();
    @Test
    public void testGetFoodHerbivore() throws Exception {
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }
    @Test
    public void testGetFoodPredator() throws Exception {
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
    @Test(expected = Exception.class)
    public void testGetFoodInvalidKind() throws Exception {
        animal.getFood("Неизвестный");
    }
    @Test
    public void testGetFamily() {
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}