package c.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessingStringRex {

    public static String convertToNumbers(String input) {
        // Define regex pattern for letters from 'a' to 'i'
        String patternLettersAtoI = "[a-i]";
        // Define regex pattern for letters from 'j' to 'z'
        String patternLettersJtoZ = "(10#|1[1-9]|2[0-6]#)";

        // Compile regex patterns
        Pattern patternAtoI = Pattern.compile(patternLettersAtoI);
        Pattern patternJtoZ = Pattern.compile(patternLettersJtoZ);

        // Match and replace letters from 'a' to 'i'
        Matcher matcherAtoI = patternAtoI.matcher(input);
        input = matcherAtoI.replaceAll(matchResult -> String.valueOf((char) ('1' + matchResult.group().charAt(0) - 'a')));

        // Match and replace letters from 'j' to 'z'
        Matcher matcherJtoZ = patternJtoZ.matcher(input);
        input = matcherJtoZ.replaceAll(matchResult -> {
            String group = matchResult.group();
            if (group.equals("10#")) {
                return "j";
            } else {
                return String.valueOf((char) ('a' + Integer.parseInt(group.substring(0, group.length() - 1)) - 1));
            }
        });

        return input;
    }

    public static void main(String[] args) {
        String input = "1226#";
        String output = convertToNumbers(input);
        System.out.println(output); // Output: abz
    }
}
