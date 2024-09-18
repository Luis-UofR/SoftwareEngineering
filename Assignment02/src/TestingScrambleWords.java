import java.util.List;

public class TestingScrambleWords {

    public static void main(String[] args) {
        // create ScrambleWords
        ScrambleWords generator = new ScrambleWords();
        
        String input = "hello";
        
        // make a list of all the permutations
        List<String> permutations = generator.createPerms(input.toCharArray());
        
        // Print the words
        System.out.println("Permutations of \"" + input + "\":");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
