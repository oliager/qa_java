import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensInvokesFelineGetKittens() throws Exception {

        Lion lion = new Lion(feline, "Самка");
        lion.getKittens();

        verify(feline, times(1)).getKittens();

    }
    @Test
    public void getKittensReturnsOne() throws Exception {
        int expectedKittens = 1;
        when(feline.getKittens()).thenReturn(expectedKittens);

        Lion lion = new Lion(feline, "Самка");
        int actualKittens = lion.getKittens();

        assertEquals(expectedKittens, actualKittens);

    }

    @Test
    public void getKittensThrowsExceptionWhenSexIsLittleRegister() throws Exception {

        assertThrows(Exception.class, () -> {
            Lion lion = new Lion(feline, "cамка");
        });
    }

    @Test
    public void getKittensThrowsCorrectMessageExceptionWhenThrowsException() throws Exception {
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самей или самка";

        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(feline, "cамей");
        });
        String actualExceptionMessage = e.getMessage();

        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void getFoodReturnListOfFelineFood() throws Exception{
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Lion lion = new Lion(feline, "Самка");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood,actualFood);
    }
    @Test
    public void getFoodInvokesFelineGetFoodWithParamPredator() throws Exception{
        Lion lion = new Lion(feline, "Самка");

        lion.getFood();
        verify(feline, times(1)).getFood("Хищник");
    }


    @Test
    public void getFoodThrowsExceptionWhenFelineGetFoodThrowException() throws Exception {
        Lion lion = new Lion(feline, "Самка");

        when(feline.getFood("Хищник")).thenThrow(new Exception());

        assertThrows(Exception.class, () -> {
            lion.getFood();
        });
    }

}