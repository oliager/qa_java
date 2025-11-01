import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParameterizedTest {
    private final String sex;
    private final boolean expectedDoesHaveMane;
    @Mock
    private Feline feline;

    @Before
    public void init() {
        initMocks(this);
    }

    public LionDoesHaveManeParameterizedTest(String sex, boolean expectedDoesHaveMane) {

        this.sex = sex;
        this.expectedDoesHaveMane = expectedDoesHaveMane;
    }
    @Parameterized.Parameters(name = "sex: {0}, expectedDoesHaveMane: {1}")
    public static Object[][] getLionData(){
        return new Object[][]{
                {"Самец", true},{"Самка", false}
        };
    }
    @Test
    public void doesHaveManeReturnTrueIfSexIsMan() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedDoesHaveMane, actualHasMane);
    }

}
