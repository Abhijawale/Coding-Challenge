// First approach --->

class NewspaperTitle {

    public static String titleProcessing(String[] titles) {

        // Step 1: Creating a single String by concatinating the strings into the array.
        StringBuilder stringConcatenation = new StringBuilder();
        for (String title : titles) {
            if (title != null) {
                stringConcatenation.append(title).append(" ");
            }
        }

        // Step 2: Delete all numeric symbols from the string
        String stringDeleteNumbers = stringConcatenation.toString().replaceAll("[0-9]", "");

        // Step 3: Capitalize the first character of each word in the string
        String[] words = stringDeleteNumbers.toString().trim().split("\\s+");
        StringBuilder stringCapitalize = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                stringCapitalize.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1)).append(" ");
            }
        }

        // Remove trailing space and return the result
        return stringCapitalize.toString().trim();

    }

    // Main Method
    public static void main(String[] args) {
        // Assume the titles are in an array of strings.
        // Creating array of string titles.

        String[] titles = { "break3ing news5:", "1A 1circle is round!" };
        String expectedTitle = titleProcessing(titles);

        // Printing the Expected Newspaper title.
        System.out.println("\"" + expectedTitle + "\"");

    }
}
/*
 * <-----Output----->
 * 
 * javac NewspaperTitle.java
 * java NewspaperTitle
 * 
 * "Breaking News: A Circle Is Round!" ------------OUTPUT
 * 
 */