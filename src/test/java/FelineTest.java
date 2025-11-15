import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
public class FelineTest {
    private final Feline feline = new Feline();
    @Test
    public void testEatMeatShouldReturnTypicalCarnivoreDiet() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
    @Test
    public void testGetFamilyShouldReturnFelidaeFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }
    @Test
    public void testGetKittensWithoutParameterShouldReturnDefaultCount() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }
    @Test
    public void testGetKittensWithParameterShouldReturnSpecifiedCount() {
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }
}