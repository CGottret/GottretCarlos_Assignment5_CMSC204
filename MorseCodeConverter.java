import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree morseCodeTree = new MorseCodeTree();

    public MorseCodeConverter() {
        morseCodeTree.buildTree();
    }

    public static String printTree() {
        ArrayList<String> inorderList = morseCodeTree.toArrayList();
        String resultTree = "";
        for (int i = 0; i < inorderList.size(); i++) {
            resultTree += inorderList.get(i);
            if (i != inorderList.size() - 1) {
                resultTree += " ";
            }
        }
        return resultTree;
    }

    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        StringBuilder english = new StringBuilder();
        try {
            Scanner scanner = new Scanner(codeFile);
            while (scanner.hasNextLine()) {
                String code = scanner.nextLine();
                english.append(convertToEnglish(code));
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return english.toString().trim();
    }

    // Hello World = .... . .-.. .-.. --- / .-- --- .-. .-.. -..
    public static String convertToEnglish(String code) {
        StringBuilder english = new StringBuilder();
        // 1. split by / to get words => array of words
        String[] wordsCode = code.split("/");
        // 2. for each word, split by space to get letter => array of letters
        for (String s : wordsCode) {
            String[] lettersCode = s.split(" ");
            // 3. for each letter(morse code), call fetch method to get actual letter
            for (String letterCode : lettersCode) {
                if (!letterCode.isEmpty()) {
                    english.append(morseCodeTree.fetch(letterCode).toString());
                }
            }
            //4.  combine letters into one word
            english.append(" ");
        }
        // return combine words with space
        return english.toString().trim();
    }
}
