import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline felineSpy;

    @Test
    public void getKittensWithoutParamInvokesGetKittensWith1() {
        felineSpy.getKittens();
        verify(felineSpy, times(1)).getKittens(1);

    }

    @Test
    public void getKittensWithoutParamReturnsDefaultOne() {
        Feline feline = new Feline();
        int actualNumOfKittens = feline.getKittens();
        assertEquals(1, actualNumOfKittens);
    }

    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> actualFoodList = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFoodList);
    }

    @Test
    public void eatMeatInvokesGetFoodWithParamPredator() throws Exception {
        felineSpy.eatMeat();
        verify(felineSpy, times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи", actualFamily);
    }
}
