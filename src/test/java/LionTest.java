import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final Boolean hasManeExpected;

    public LionTest(String sex, Boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
            {"Самец", true},
            {"Самка", false},
        };
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        Assert.assertEquals(hasManeExpected,lion.doesHaveMane());
    }


    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test()
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        List<String> expectedList = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualList = lion.getFood();

        for(int i = 0; i < actualList.size(); i++) {
            Assert.assertEquals(expectedList.get(i), actualList.get(i));
        }

    }

}
