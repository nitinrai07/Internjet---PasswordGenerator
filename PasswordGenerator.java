package Npackage;
import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the length of the password: ");
	        int length = sc.nextInt();

	        System.out.println("Select password complexity:");
	        System.out.println("1. Uppercase letters");
	        System.out.println("2. Lowercase letters");
	        System.out.println("3. Numbers");
	        System.out.println("4. Symbols");
	        System.out.println("5. All of the above");

	        int complexityOption = sc.nextInt();

	        String password = generatePassword(length, complexityOption);
	        System.out.println("Generated Password: " + password);

	        sc.close();
	    }

	    private static String generatePassword(int length, int complexityOption) {
	        String uppercaseLetters = "JORDAN";
	        String lowercaseLetters = "jordan";
	        String numbers = "0123456789";
	        String symbols = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

	        StringBuilder validChars = new StringBuilder();

	        switch (complexityOption) {
	            case 1:
	                validChars.append(uppercaseLetters);
	                break;
	            case 2:
	                validChars.append(lowercaseLetters);
	                break;
	            case 3:
	                validChars.append(numbers);
	                break;
	            case 4:
	                validChars.append(symbols);
	                break;
	            case 5:
	                validChars.append(uppercaseLetters).append(lowercaseLetters).append(numbers).append(symbols);
	                break;
	            default:
	                System.out.println("Invalid option. Using default: Uppercase letters, lowercase letters, numbers, and symbols.");
	                validChars.append(uppercaseLetters).append(lowercaseLetters).append(numbers).append(symbols);
	                break;
	        }

	        SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(validChars.length());
	            password.append(validChars.charAt(index));
	        }

	        return password.toString();
	    }
	}



