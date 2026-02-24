import java.util.Scanner;

// PalindromeChecker class encapsulates the palindrome logic
class PalindromeChecker {

    private String input;

    // Constructor to set the string
    public PalindromeChecker(String input) {
        this.input = input;
    }

    // Method to check if the string is palindrome
    public boolean checkPalindrome() {
        if (input == null || input.isEmpty()) {
            return true; // Empty string is considered a palindrome
        }

        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

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
}

public class UseCase11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Use the PalindromeChecker service class
        PalindromeChecker checker = new PalindromeChecker(input);

        if (checker.checkPalindrome()) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}