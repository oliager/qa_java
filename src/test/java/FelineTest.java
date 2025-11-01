import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

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
    public void getFamilyReturnsFelineFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи", actualFamily);
    }
}
