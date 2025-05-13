import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void testGetSound() {
        Feline felineMock = Mockito.mock(Feline.class);
        Cat cat = new Cat(felineMock);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expected);

        Cat cat = new Cat(felineMock);
        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
    }}