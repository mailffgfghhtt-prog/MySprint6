import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.List;

public class CatTest {

    @Test
    public void testGetSound() {
        Feline realFeline = new Feline();
        Cat cat = new Cat(realFeline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood_returnsExpectedList() throws Exception {
        Feline realFeline = new Feline();
        Cat cat = new Cat(realFeline);
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFood_callsEatMeatOnce() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));


        Cat cat = new Cat(mockFeline);
        cat.getFood();

        verify(mockFeline, times(1)).eatMeat();
    }
        @Test(expected = Exception.class)
        public void testGetFood_throwsExceptionWhenFelineEatMeatFails () throws Exception {
            Feline mockFeline = mock(Feline.class);
            when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка при получении пищи"));

            Cat cat = new Cat(mockFeline);
            cat.getFood();  // Должно выбросить исключение
        }

        @Test
        public void testGetFood_handlesNullFromEatMeat () throws Exception {
            Feline mockFeline = mock(Feline.class);
            when(mockFeline.eatMeat()).thenReturn(null);

            Cat cat = new Cat(mockFeline);
            List<String> food = cat.getFood();

            assertEquals(null, food);
        }
    }

