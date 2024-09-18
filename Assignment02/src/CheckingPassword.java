public class CheckingPassword {

	/**
	 * Checking if the password if strong by giving a password and looking at the
	 * largest block.
	 *
	 * @param password The given password to look at the blocks.
	 * @return How strong the password is.
	 */
	public String checkPasswordStrength(String password) {
		if (password.length() < 8 || password.length() > 12) {
			return "The password has to be 8-12 characters, please try again.";
		}
		// check if there is a space
		if (password.contains(" ")) {
			return "The password cannot contain spaces, please try again.";
		}

		// finding the biggest block
		int largestBlock = findLargestBlock(password);
		if (largestBlock > 2) {
			int tryReducing = largestBlock - 2;
			return "The largest block in the password is " + largestBlock
					+ ". This password can be made stronger by reducing this block by " + tryReducing + ".";
		} else {
			return "The largest block in the password is " + largestBlock + ". This is a decent password.";
		}
	}

	/**
	 * Find the biggest block in the password
	 *
	 * @param password The given password to look at the blocks.
	 * @return The size of the largest block
	 */
	private int findLargestBlock(String password) {
		int biggestBlock = 1, currentBlock = 1;
		for (int i = 1; i < password.length(); i++) {
			if (password.charAt(i) == password.charAt(i - 1)) {
				currentBlock++; // checking if they match
			} else {
				biggestBlock = Math.max(biggestBlock, currentBlock);
				currentBlock = 1;
			}
		}
		return Math.max(biggestBlock, currentBlock);
	}
}
