import java.util.stream.Stream;

public class TupleMapper {

    private static final String[] ONES = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] TENS = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] HUNDREDS = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] THOUSANDS = {"M", "MM", "MMM"};

    private int[][] tuples;

    public TupleMapper (int[][] tuples) {
        this.tuples = tuples;
    }

    public String map() {
        return Stream.of(tuples)
                .map(t -> mapper(t))
                .reduce("", String::concat);
    }

    private String mapper(int[] t) {
        switch (t[1]){
            case 0:
                return ONES[t[0]-1];
            case 1:
                return TENS[t[0]-1];
            case 2:
                return HUNDREDS[t[0]-1];
            case 3:
                return THOUSANDS[t[0]-1];
        }
        return "";
    }
}
