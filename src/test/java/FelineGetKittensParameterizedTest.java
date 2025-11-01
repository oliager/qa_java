import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineGetKittensParameterizedTest {

    private final int kittens;
    private final int expectedNumOfKittens;


    public FelineGetKittensParameterizedTest(int kittens, int expectedNumOfKittens) {
        this.kittens = kittens;
        this.expectedNumOfKittens = expectedNumOfKittens;
    }
    @Parameterized.Parameters(name = "kittens: {0}, expectedKittens: {1}")
    public static Object[][] getNumberOfKittens(){
        return new Object[][]{
                {5,5},{2,2},{1,1},{0,0}
        };
    }
    @Test
    public void getKittensWithParameterReturnNumberInParameter(){
        Feline feline = new Feline();
        int actualKittens= feline.getKittens(kittens);
        assertEquals(expectedNumOfKittens, actualKittens);
    }
}
