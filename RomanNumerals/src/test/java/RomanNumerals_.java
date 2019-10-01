import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class RomanNumerals_ {
    private final int number;
    private final String value;
    private final Class exceptionClass;

    public RomanNumerals_(int number, String value, Class exceptionClass) {
        this.number = number;
        this.value = value;
        this.exceptionClass = exceptionClass;
    }

    @Test
    public void execute() throws IllegalParameterException {
        try {
            assertThat(new RomanNumerals().toRoman(number)).isEqualTo(this.value);
            assertFalse(exceptionClass != null);
        }
        catch (Exception e) {
            assertTrue(exceptionClass != null);
        }
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {-1, null, IllegalParameterException.class},
                {0, null, IllegalParameterException.class},
                {4000, null, IllegalParameterException.class},
                {5000, null, IllegalParameterException.class},
                {1, "I", null},
                {2, "II", null},
                {3, "III", null},
                {9, "IX", null},
                {10, "X", null},
                {11, "XI", null},
                {20, "XX", null},
                {30, "XXX", null},
                {50, "L", null},
                {100, "C", null},
                {110, "CX", null},
                {159, "CLIX", null},
                {200, "CC", null},
                {348, "CCCXLVIII", null},
                {1000, "M", null},
                {1978, "MCMLXXVIII", null},
                {2000, "MM", null},
                {3000, "MMM", null}

        };
    }
}
