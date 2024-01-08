// Second Approach --> By taking user input

import java.util.ArrayList;
import java.util.Scanner;

class NewspaperTitleSecond {
    static Scanner scanner = new Scanner(System.in);

    public static String titleProcessing(ArrayList<String> titles) {

        // Step 1: Creating a single String by concatenating the strings into the array.
        StringBuilder stringConcatenation = new StringBuilder();
        for (String title : titles) {
            if (title != null) {
                stringConcatenation.append(title).append(" ");
            }
        }

        // Step 2: Delete all numeric symbols from the string
        String stringDeleteNumbers = stringConcatenation.toString().replaceAll("[0-9]", "");

        // Step 3: Capitalize the first character of each word in the string
        String[] words = stringDeleteNumbers.trim().split("[\\W_]+");
        StringBuilder stringCapitalize = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (word.endsWith(":") || word.endsWith("!")) {
                    // Keep the punctuation mark at the end
                    stringCapitalize.append(word.substring(0, word.length() - 1).substring(0, 1).toUpperCase())
                            .append(word.substring(0, word.length() - 1).substring(1))
                            .append(word.charAt(word.length() - 1)).append(" ");
                } else {
                    stringCapitalize.append(word.substring(0, 1).toUpperCase())
                            .append(word.substring(1)).append(" ");
                }
            }
        }
        return "\"" + stringCapitalize.toString().trim() + "\"";
    }

    public static void main(String[] args) {
        // Taking user input for titles using ArrayList
        ArrayList<String> titlesList = new ArrayList<>();
        System.out.println("Enter newspaper titles (type 'exit' to finish input):");
        String inputTitle;
        while (true) {
            inputTitle = scanner.nextLine().trim();
            if (inputTitle.equalsIgnoreCase("exit")) {
                break;
            }
            titlesList.add(inputTitle);
        }

        // Process titlesList and print the result
        String expectedTitle = titleProcessing(titlesList);
        System.out.println("Expected Newspaper title: " + expectedTitle);
    }
}
/*
 * <-------Output------->
 * 
 * User Input --->
 * Enter newspaper titles (type 'exit' to finish input):
 * ["break3ing news5:", "1A 1circle is round!"]
 * exit
 * 
 * Output --->
 * Expected Newspaper title: "Breaking News A Circle Is Round"
 * 
 */