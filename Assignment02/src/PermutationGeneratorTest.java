import java.util.List;

public class PermutationGeneratorTest {

    public static void main(String[] args) {
        // Create an instance of PermutationGenerator
        PermutationGenerator generator = new PermutationGenerator();
        
        // Define a test input
        String input = "ABCD";
        
        // Generate permutations
        List<String> permutations = generator.generatePermutations(input.toCharArray());
        
        // Print the results
        System.out.println("Permutations of \"" + input + "\":");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
