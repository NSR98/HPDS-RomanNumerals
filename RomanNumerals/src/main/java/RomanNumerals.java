
public class RomanNumerals {
    private static final int MIN = 0;
    private static final int MAX = 4000;

    public String toRoman(int number) throws IllegalParameterException {
        if (number <= 0 || number >= 4000) throw new IllegalParameterException();
        return new TupleMapper(new NumberBreaker(number).breakdown()).map();
    }


}
