import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final Boolean hasManeExpected;

    public LionParameterizedTest(String sex, Boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][] {
            {"Самец", true},
            {"Самка", false},
        });
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        Assert.assertEquals(hasManeExpected, lion.doesHaveMane());
    }
}