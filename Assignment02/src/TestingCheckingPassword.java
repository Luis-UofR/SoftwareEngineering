public class TestingCheckingPassword {

	public static void main(String[] args) {
		// make a PasswordStrengthChecker
		CheckingPassword checker = new CheckingPassword();

		// testing all possible passwords
		String[] passwordExamples = { "hello", // less than 8 characters
				"12345678", // no blocks
				"hiiiiiii", // block count
				"hheelloo", // multiple blocks
				"helloButReallyLong" // over 8 characters
		};
		
		// access class to test the passwords
		for (String password : passwordExamples) {
			String result = checker.checkPasswordStrength(password);
			System.out.println(password);
			System.out.println(result);
			System.out.println(); 
		}
	}
}
