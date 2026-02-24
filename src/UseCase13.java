import java.util.Scanner;
import java.util.Stack;

public class UseCase13{

    // Iterative two-pointer method
    public static boolean iterativePalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive method
    public static boolean recursivePalindrome(String str, int start, int end) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        if (start >= end) return true;
        if (normalized.charAt(start) != normalized.charAt(end)) return false;
        return recursivePalindrome(normalized, start + 1, end - 1);
    }

    // Stack-based method
    public static boolean stackPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to test: ");
        String input = scanner.nextLine();

        // Iterative test
        long startTime = System.nanoTime();
        boolean iterativeResult = iterativePalindrome(input);
        long iterativeTime = System.nanoTime() - startTime;

        // Recursive test
        startTime = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(input, 0, input.replaceAll("\\s+", "").length() - 1);
        long recursiveTime = System.nanoTime() - startTime;

        // Stack-based test
        startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long stackTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("Iterative Method: Result=%b, Time=%d ns%n", iterativeResult, iterativeTime);
        System.out.printf("Recursive Method: Result=%b, Time=%d ns%n", recursiveResult, recursiveTime);
        System.out.printf("Stack Method:     Result=%b, Time=%d ns%n", stackResult, stackTime);

        scanner.close();
    }
}