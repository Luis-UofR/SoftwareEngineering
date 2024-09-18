import java.util.ArrayList;
import java.util.List;

public class ScrambleWords {

    /**
     * Make permutations of the character array.
     * 
     * @param arr The character array to permute.
     * @return All permutations.
     */
    public List<String> createPerms(char[] arr) {
        List<String> results = new ArrayList<>();
        permute(arr, 0, results);
        return results;
    }

    /**
     * Using recursion, make permutations of the character array.
     * 
     * @param arr     The character array to permute.
     * @param index   The index for recursion.
     * @param results The list of permutations.
     */
    private void permute(char[] arr, int index, List<String> results) {
        if (index == arr.length - 1) {
            results.add(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permute(arr, index + 1, results);
            swap(arr, i, index);
        }
    }

    /**
     * Swaps the elements in a character array.
     * 
     * @param arr The character array.
     * @param i   The first index.
     * @param j   The second index.
     */
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
