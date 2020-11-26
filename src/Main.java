import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] values = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "A", "3", "4"}
        };
        CheckArray check = new CheckArray();
        check.checkSize(values);


    }
}
