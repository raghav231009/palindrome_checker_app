import java.util.Scanner;

public class UseCase10 {

    // Method to check palindrome (case-insensitive & space-ignored)
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        // Remove all spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply two-pointer technique
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}