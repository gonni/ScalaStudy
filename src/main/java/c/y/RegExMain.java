package c.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMain {

    public static void extractTagsAndAttributes(String html) {
        // Define regex pattern for HTML tags and attributes
        String tagPatternString = "<(\\w+)([^>]*)>";
        String attributePatternString = "\\s*(\\w+)\\s*=\\s*\"([^\"]*)\"";

        // Compile regex patterns
        Pattern tagPattern = Pattern.compile(tagPatternString);
        Pattern attributePattern = Pattern.compile(attributePatternString);

        // Match HTML tags and attributes
        Matcher tagMatcher = tagPattern.matcher(html);
        while (tagMatcher.find()) {
            String tagName = tagMatcher.group(1); // Extract tag name
            System.out.println("Tag: " + tagName);

            // Extract attributes
            String attributesText = tagMatcher.group(2);
            System.out.println("Attr Text: " + attributesText);
            Matcher attributeMatcher = attributePattern.matcher(attributesText);
            while (attributeMatcher.find()) {
                String attributeName = attributeMatcher.group(1); // Extract attribute name
                String attributeValue = attributeMatcher.group(2); // Extract attribute value
                System.out.println("Attribute: " + attributeName + ", Value: " + attributeValue);
            }
        }
    }


    public static void extract(String target) {
        String pattern = "[0-9]*[1-2][0-6]\\#([0-9])*";

        Pattern pt = Pattern.compile(pattern);
        Matcher matcher = pt.matcher(target);
        while(matcher.find()) {
            System.out.println("->" + matcher.group());
        }
    }

    public static String convertToLetters(String input) {
        // Define regex pattern for numbers from 1 to 9
        String patternNumbers1to9 = "[1-9]";
        // Define regex pattern for numbers from 10 to 26
        String patternNumbers10to26 = "(10#|1[1-9]|2[0-6]#)";

        // Compile regex patterns
        Pattern pattern1to9 = Pattern.compile(patternNumbers1to9);
        Pattern pattern10to26 = Pattern.compile(patternNumbers10to26);

        // Match and replace numbers from 1 to 9
        Matcher matcher1to9 = pattern1to9.matcher(input);
        input = matcher1to9.replaceAll(matchResult -> String.valueOf((char) ('a' + Integer.parseInt(matchResult.group()) - 1)));

        // Match and replace numbers from 10 to 26
        Matcher matcher10to26 = pattern10to26.matcher(input);
        input = matcher10to26.replaceAll(matchResult -> {
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
//        String html = "<div class=\"container\" witdh=\"500\"><h1 id=\"title\">Hello, World!</h1></div>";
//        extractTagsAndAttributes(html);

        String target = "11211#";
        System.out.println(convertToLetters(target));
    }

}
