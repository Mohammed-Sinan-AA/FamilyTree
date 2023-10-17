import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class FindNthGeneration {
    public static void main(String[] args) {
        Map<String, List<String>> familyTree = new HashMap<>();

        familyTree.put("Alice", Arrays.asList("Bob", "Carol"));
        familyTree.put("Bob", Arrays.asList("Dave", "Eve"));

        List<String> secondGeneration = getNthGeneration(familyTree, 2);

        System.out.println("2nd generation:");
        for (String member : secondGeneration) {
            System.out.println(member);
        }
    }
    private static List<String> getNthGeneration(Map<String, List<String>> familyTree, int n) {
        if (familyTree == null) {
            return null;
        }

        if (n == 0) {
            return new ArrayList<>(familyTree.keySet());
        } else {
            List<String> nextGeneration = new ArrayList<>();
            for (String member : getNthGeneration(familyTree, n - 1)) {
                if (familyTree.get(member) != null) {
                    nextGeneration.addAll(familyTree.get(member));
                }
            }
            return nextGeneration;
        }
    }
}
