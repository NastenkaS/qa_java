import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class LionTest {

    @Mock
    Feline feline;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();

        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void invalidSexExceptionTest() throws Exception {
        new Lion("Неизвестный", feline);
    }
}