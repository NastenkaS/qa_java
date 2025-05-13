import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

public class FelineTest {

    @Spy
    private Feline felineSpy;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> actualFoodList = feline.eatMeat();
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFoodList, actualFoodList);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithoutParameterTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy).getKittens(1);
    }

    @Test
    public void getKittensWithParameterReturnsCorrectValue() {
        Feline feline = new Feline();
        int expected = 5;
        int actual = feline.getKittens(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithoutParameterReturnsOne() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals(expected, actual);
    }
}
