import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String kindOfAnimal;
    private final List<String> expectedFood;

    public AnimalParameterizedTest(String kindOfAnimal, List<String> expectedFood) {
        this.kindOfAnimal = kindOfAnimal;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getNameAnimal() {
        return Arrays.asList(new Object[][] {
            {"Травоядное", Arrays.asList("Трава", "Различные растения")},
            {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void getListFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(kindOfAnimal);

        Assert.assertEquals(expectedFood, actualFood);
    }
}