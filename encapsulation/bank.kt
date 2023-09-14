// Encapsulation restricts direct access to some components of an objects to prevent accidental interference and misuse.
// A real-world example is a bank account.
// Let's take a look at it through the code snippets.

class BankAccount(private var balance: Double) {
	// We declare the balance with var, meaning it's mutable, because we need it to be so.
	// But we only want it to be mutated under the conditions that we define.

	// This is a read-only getter. Want to know the balance? Call this function to read it.
	fun getBalance(): Double {
		return balance
	}

	// Want to deposit money into the account? Use this method to mutate the balance variable.
	fun deposit(amount: Double) {
		if (amount > 0) {
			balance += amount
		}
	}

	// Call this mehtod to withdraw from the account.
	fun withdraw(amount: Double) {
		// We check first to see if we have available balance.
		if (amount > 0 && balance >= amount) {
			balance -= amount
		} else {
			// We can't withdraw more than we have available.
			println("Withdrawal not allowed.")
		}
	}
}
