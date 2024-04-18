package c.y;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayMain {

    public static void main(String[] args) {
//        String input = "1(9)123#1(3)212#(2)";
//        String regx = "(([1-2]{1}[0-9]{1}#)|([1-9]{1}))(\\([1-9]\\))*";
//
//        Pattern pattern = Pattern.compile(regx);
//        Matcher matcher = pattern.matcher(input);
//
//        while(matcher.find())
//            System.out.println(matcher.group());

        // -----

        String tagPatternString = "<(\\w+)([^>]*)>";
        Pattern tagPattern = Pattern.compile(tagPatternString);
        Matcher matcher = tagPattern.matcher("<h1|src=\"111\" src=\"111\">");

        while(matcher.find()) {
            System.out.println("Group Count -> " + matcher.groupCount());
            System.out.println(matcher.group(1) + " -> " + matcher.group(2));
        }
    }

}
