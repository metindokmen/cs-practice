// The Luhn Algorithm works by performing a sum of digits with some digits being doubled and transformed according to specific rules.
// The validity of an identification number can be determined if the total modulo 10 is equal to 0.

// Suppose you're developing an e-commerce application and need to validate credit card numbers entered by users.
// The Luhn Algorithm is a simple checksum formula used to validate various identification numbers, such as credit card numbers.
// It's designed to protect against accidental errors, like a digit mistyped.

fun isValidLuhnNumber(number: String): Boolean {
    var sum = 0
    var alternate = false
    for (i in number.length - 1 downTo 0) {
        var n = number[i].digitToInt()
        if (alternate) {
            n *= 2
            if (n > 9) {
                n = (n % 10) + 1
            }
        }
        sum += n
        alternate = !alternate
    }
    return sum % 10 == 0
}
