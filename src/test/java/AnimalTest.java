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

    @Test(expected = Exception.class)
    public void testGetFood_nullAnimalKind() throws Exception {
        animal.getFood(null);
    }

    @Test(expected = Exception.class)
    public void testGetFood_emptyString() throws Exception {
        animal.getFood("");
    }

    @Test(expected = Exception.class)
    public void testGetFood_whitespaceOnly() throws Exception {
        animal.getFood("   ");
    }

    @Test
    public void testGetFood_caseSensitivity() throws Exception {
        try {
            animal.getFood("хищник");
            fail("Ожидалось исключение при неверном регистре");
        } catch (Exception e) {
            assertEquals(
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage()
            );
        }
    }

    @Test
    public void testGetFood_trimmedInput() throws Exception {
        List<String> food = animal.getFood(" Хищник ");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
