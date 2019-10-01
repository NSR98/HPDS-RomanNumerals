import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class TupleMapper_ {

    private int[][] tuples;
    private String number;

    public TupleMapper_(int[][] tuples, String number) {
        this.tuples = tuples;
        this.number = number;
    }

    @Parameterized.Parameters
    public static Object[][] cases () {
        return new Object[][] {
                {new int[0][], ""},
                {new int[][]{{1,0}}, "I"},
                {new int[][]{{2,0}}, "II"},
                {new int[][]{{9,0}}, "IX"},
                {new int[][]{{1,1},{9,0}}, "XIX"},
                {new int[][]{{9,1},{6,0}}, "XCVI"},
        };
    }

    @Test
    public void execute () {
        assertThat(new TupleMapper(tuples).map()).isEqualTo(this.number);
    }

}
