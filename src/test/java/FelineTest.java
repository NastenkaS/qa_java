import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class FelineTest {

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
    public void getKittenParameterTest() {
        Feline feline = Mockito.mock(Feline.class);
        feline.getKittens(1);
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void getKittensWithoutParameterTest() {
        Feline felineMock = Mockito.mock(Feline.class);

        Mockito.when(felineMock.getKittens()).thenCallRealMethod();
        Mockito.when(felineMock.getKittens(1)).thenReturn(1);

        int result = felineMock.getKittens();

        Mockito.verify(felineMock).getKittens(1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void getKittensWithParameterTest() {
        Feline felineMock = Mockito.mock(Feline.class);

        Mockito.when(felineMock.getKittens(5)).thenReturn(5);
        Mockito.when(felineMock.getKittens(10)).thenReturn(10);

        Assert.assertEquals(5, felineMock.getKittens(5));
        Assert.assertEquals(10, felineMock.getKittens(10));

        Mockito.verify(felineMock).getKittens(5);
        Mockito.verify(felineMock).getKittens(10);
    }

    @Test
    public void getKittensDefaultValueTest() {
        Feline feline = new Feline();

        Assert.assertEquals(1, feline.getKittens());
    }
}
