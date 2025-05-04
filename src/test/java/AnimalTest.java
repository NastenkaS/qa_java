import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;


@RunWith(Parameterized.class )
public class AnimalTest {
    private final String kindOfAnimal;
    private final String expectedFirst;
    private final String expectedSecond;
    private final String expectedThird;

    public AnimalTest(String kindOfAnimal, String expectedFirst, String expectedSecond, String expectedThird) {
        this.kindOfAnimal = kindOfAnimal;
        this.expectedFirst = expectedFirst;
        this.expectedSecond = expectedSecond;
        this.expectedThird = expectedThird;
    }

    @Parameterized.Parameters
    public static Object[][] getNameAnimal() {
        return new Object[][] {
            {"Травоядное", "Трава", "Различные растения", ""},
            {"Хищник", "Животные", "Птицы", "Рыба"},
        };
    }

    @Test
    public void gerListFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood(kindOfAnimal);
        List<String> expected = Arrays.asList(expectedFirst, expectedSecond, expectedThird);

        for(int i = 0; i < food.size(); i++) {
            Assert.assertEquals(food.get(i), expected.get(i));
        }

    }
}
