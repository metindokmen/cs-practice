// Bit Manipulation is a technique which involves performing operations directly on individual bits within binary representations of numbers.
// It's commonly used in various fields like computer science, cryptography, and hardware design.

// 1. Concept: Bit manipulation involves performing logical operations (AND, OR, XOR, NOT)
// and bitwise shifts (left shift, right shift) on individual bits within binary representations of numbers.

// 2. Applications:
// - Flag Manipulation: Efficiently manage boolean flags using individual bits within an integer.
// - Bitwise Operations: Perform operations like setting, clearing, or toggling specific bits.
// - Bitwise Arithmetic: Perform arithmetic operations (addition, subtraction, multiplication, division) using bitwise operations.
// - Bitwise Representation: Represent data compactly and efficiently, such as encoding information in network protocols or file formats.

// 3. Advantages:
// - Offers efficient and compact representation of data, especially in scenarios where memory or bandwidth is limited.
// - Provides fast execution due to the direct manipulation of bits at the hardware level.


// Consider a scenario where you need to optimize memory usage in a system by packing multiple boolean flags into a single integer variable.
// Bit manipulation allows you to efficiently set, toggle, and check these flags without the need for separate boolean variables.

fun main() {
    // Example of setting and checking individual bits
    var flags = 0b0000_0000 // Initialize with all flags turned off
    val FLAG_A = 0b0000_0001 // Define flag A
    val FLAG_B = 0b0000_0010 // Define flag B

    // Setting flag A
    flags = flags or FLAG_A

    // Checking if flag B is set
    val isFlagBSet = flags and FLAG_B != 0

    println("Flag A is set: ${flags and FLAG_A != 0}") // Output: Flag A is set: true
    println("Flag B is set: $isFlagBSet") // Output: Flag B is set: false

    // Example of toggling individual bits
    flags = flags xor FLAG_A // Toggle flag A

    println("Flag A after toggling: ${flags and FLAG_A != 0}") // Output: Flag after toggling: false

    // Example of bitwise arithmetic
    val num1 = 0b1010 // Binary representation of 10
    val num2 = 0b1100 // Binary representation of 12

    val bitwiseAnd = num1 and num2 // Bitwise AND operation
    val bitwiseOr = num1 or num2 // Bitwise OR operation
    val bitwiseXor = num1 xor num2 // Bitwise XOR operation
    val bitwiseNot = num1.inv() // Bitwise NOT operation (complement)

    println("Bitwise AND: $bitwiseAnd") // Output: Bitwise AND: 8
    println("Bitwise OR: $bitwiseOr") // Output: Bitwise OR: 14
    println("Bitwise XOR: $bitwiseXor") // Output: Bitwise XOR: 6
    println("Bitwise NOT of $num1: ${bitwiseNot.toString(2)}") // Output: Bitwise NOT of 10: -11 (in two's complement)
}
