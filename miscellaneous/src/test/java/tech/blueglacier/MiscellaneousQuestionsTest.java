package tech.blueglacier;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MiscellaneousQuestionsTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testStringTrim() {
        String stringToTrim = "    A BBBB CCCCC   ";

        String trimmedString = getTrimmedString(stringToTrim);

        Assert.assertTrue(trimmedString.equals(stringToTrim.trim()));
    }

    @Test
    public void testEmptyStringTrim() {
        String stringToTrim = "       ";

        String trimmedString = getTrimmedString(stringToTrim);

        Assert.assertTrue(trimmedString.equals(stringToTrim.trim()), stringToTrim.trim() + ":" + trimmedString);
    }

    @Test
    public void testFrontEmptyStringTrim() {
        String stringToTrim = "    A BBBB CCCCC";

        String trimmedString = getTrimmedString(stringToTrim);

        Assert.assertTrue(trimmedString.equals(stringToTrim.trim()));
    }

    @Test
    public void testRearEmptyStringTrim() {
        String stringToTrim = "A BBBB CCCCC      ";

        String trimmedString = getTrimmedString(stringToTrim);

        Assert.assertTrue(trimmedString.equals(stringToTrim.trim()));
    }

    private String getTrimmedString(String stringToTrim) {
        char[] stringToTrimArray = stringToTrim.toCharArray();

        int subStringStartIndex = 0;
        for (int startIndex = 0; startIndex < stringToTrimArray.length; startIndex++) {
            if (stringToTrimArray[startIndex] == ' ') {
                continue;
            } else {
                subStringStartIndex = startIndex;
                break;
            }
        }
        int subStringEndIndex = stringToTrimArray.length - 1;

        for (int endIndex = stringToTrimArray.length - 1; endIndex >= 0; endIndex--) {
            if (stringToTrimArray[endIndex] == ' ') {
                continue;
            } else {
                subStringEndIndex = endIndex;
                break;
            }
        }

        //Empty String
        if(subStringStartIndex == 0 && subStringEndIndex == stringToTrimArray.length - 1){
            return "";
        }

        return new String(Arrays.copyOfRange(stringToTrimArray, subStringStartIndex, subStringEndIndex + 1));
    }
}
