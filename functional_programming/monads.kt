// Monads are a somewhat abstract and often misunderstood concept in programming, particularly prevalent in functional languages.
// They are a type of abstract data type used to represent computations instead of data in domain model.

// To understand monads in a real-world context, let's consider a scenario involving online shopping.
// When you shop online, you go through a series of steps:

// selecting items,
// adding them to a cart,
// applying discounts,
// calculating taxes,
// and finally making a payment.

// Each step is dependent on the successful completion of the previous one.
// If something goes wrong at any step (e.g., an item is out of stock, or payment fails), the process stops, and you might receive an error message.

// In programming, monads help manage these kinds of sequential operations, where each step depends on the outcome of the previous one.
// They can handle errors gracefully, allowing your program to continue when something goes wrong in the sequence.


// Kotlin, being more of a pragmatic language than a purely functional one, doesn't have built-in support for monads in the way haskell does.
// However, kotlin's 'Result' type and its support for higher-order functions allow you to use monadic patterns.

fun divide(x: Int, y: Int): Result<Int> = if (y != 0) Result.success(x, y) else Result.failure(Exception("Cannot divide by zero"))

fun main() {
    val result1 = divide(10, 2)
    val result2 = result1.flatMap { divide(it, 0) }
    val result3 = result2.map { it * 2 }

    result3.onSuccess { println("Success: $it") }
        .onFailure { println("Error: ${it.message}") }
}

// In the above example,

// 1. 'divide' is a function that returns a 'Result' type, representing a successful division or a failure.
// 2. 'flatMap' is used to chain another operation that depends on the successful result of the first operation.
// 3. 'map' transforms the successful result without the possibility of failure.
// 4. Finally, 'onSuccess' and 'onFailure' handle the final outcome.
