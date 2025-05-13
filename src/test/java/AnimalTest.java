import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;


public class AnimalTest {
    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String familyInfo = animal.getFamily();

        String expectedFamilyInfo = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamilyInfo, familyInfo);
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithInvalidAnimalKind() throws Exception {
        Animal animal = new Animal();
        String invalidAnimalKind = "Всеядное";

        animal.getFood(invalidAnimalKind);
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithNullAnimalKind() throws Exception {
        Animal animal = new Animal();
        animal.getFood(null);
    }
}
