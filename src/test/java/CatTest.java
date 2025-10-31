import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundReturnsMiyu() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound);
    }

    @Test
    public void getFoodThrowsNullPointerExceptionWhenFelineIsNull() {
        Cat cat = new Cat(null);

        assertThrows(NullPointerException.class, () -> cat.getFood());

    }

    @Test
    public void getFoodInvokesEatMeat() throws Exception {

        Cat cat = new Cat(feline);
        cat.getFood();

        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void getFoodReturnsFoodOfFeline() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFoodThrowsExceptionWhenFelineThrowException() throws Exception {
        Cat cat = new Cat(feline);

        when(feline.eatMeat()).thenThrow(new Exception());

        assertThrows(Exception.class, () -> {
            cat.getFood();
        });
    }

}