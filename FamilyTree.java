import java.util.*;

public class FamilyTree {
    private static class Member {
        private String name;
        private List<Member> children;
        public Member(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
        public void addChild(Member child) {
            children.add(child);
        }
        public String getName() {
            return name;
        }
        public List<Member> getChildren() {
            return children;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the root member: ");
        String rootName = scanner.next();

        Member root = new Member(rootName);
        addChildren(scanner, root);

        for (Member child : root.getChildren()) {
            Collections.sort(child.getChildren(), Comparator.comparing(Member::getName));
        }

        printFamilyTree(root, 0);
    }

    private static void addChildren(Scanner scanner, Member parent) {
        System.out.print("Enter the number of children for " + parent.getName() + ": ");
        int numChildren = scanner.nextInt();
        for (int i = 0; i < numChildren; i++) {
            System.out.print("Enter the name of child #" + (i + 1) + ": ");
            String childName = scanner.next();
            Member child = new Member(childName);
            parent.addChild(child);
            addChildren(scanner, child);
        }
    }

    private static void printFamilyTree(Member member, int level) {
        String spaces = "  ".repeat(level);
        System.out.println(spaces + member.getName());
        for (Member child : member.getChildren()) {
            printFamilyTree(child, level + 1);
        }
    }
}
