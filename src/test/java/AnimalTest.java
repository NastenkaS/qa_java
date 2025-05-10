import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class )
public class AnimalTest {
    private final String kindOfAnimal;
    private final List<String> expectedFood;

    public AnimalTest(String kindOfAnimal, List<String> expectedFood) {
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

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String familyInfo = animal.getFamily();

        String expectedFamilyInfo = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamilyInfo, familyInfo);
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithNullAnimalKind() throws Exception {
        Animal animal = new Animal();
        animal.getFood(null);
    }
}
