package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class FlipBitTest {
    @Test
    public void flipBit() {
        FlipBit flipBit = new FlipBit();
        for (int value = 5; value < 20; value++) {
            for (int bitIndex = 1; bitIndex < 10; bitIndex++) {
                int actualResult = flipBit.flipBit(value, bitIndex);
                int expectedResult = correctFlipBit(value, bitIndex);

                Assert.assertEquals("Test failed with parameter: value = " + value
                        + " bitIndex = " + bitIndex, expectedResult, actualResult);
            }
        }
    }

    public int correctFlipBit(int value, int bitIndex) {
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(value));
        StringBuilder result = new StringBuilder();
        int stringLength = binaryString.length();
        if (stringLength < bitIndex) {
            for (int i = 0; i < bitIndex - stringLength; i++) {
                result.append('0');
            }
        }
        result.append(binaryString);
        char flippedBit = (result.charAt(result.length() - bitIndex) == '0') ? '1' : '0';
        result.setCharAt(result.length() - bitIndex, flippedBit);
        return Integer.parseInt(result.toString(), 2);
    }
}
