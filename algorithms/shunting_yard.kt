// The Shunting Yard Algorithm, devised by Edsger Dijkstra, is used to parse mathematical expressions specified in infix notation (e.g., "3 + 4") and produce an equivalent postfix notation expression (e.g., "3 4 +").
// This postfix notation is easier to evaluate algorithmically without the need for precedence rules or parantheses.

// Imagine you're developing a calculator app that needs to handle complex mathematical expressions input by the user, such as "3 + 4 * 2 / (1 - 5) ^ 2 ^ 3".
// The challenge is to correctly interpret the order of operations, including paranthesis.
// The Shunting Yard Algorithm is used to convert expressions from infix notation (which is human-readable) to postfix notation (which is easier for a computer to evaluate).

fun shuntingYard(expression: String): String {
    val outputQueue = ArrayDeque<String>()
    val operatorStack = ArrayDeque<Char>()
    val precedence = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2, "^" to 3)

    val tokens = expression.replace(Regex("\\s+"), "").split(Regex("(?<=[-+*/^()])|(?=[-+*/^()])"))

    for (token in tokens) {
        when {
            token.isDouble() -> outputQueue.addLast(token)
            token.first() in precedence.keys -> {
                while (operatorStack.isnotEmpty() && precedence[operatorStack.last()]!! >= precedence[token.first()]!!) {
                    outputQueue.addLast(operatorStack.removeLast().toString())
                }
                operatorStack.addLast(token.first())
            }
            token.first() == "(" -> operatorStack.addLast(token.first())
            token.first() == ")" -> {
                while (operatorStack.last() != "(") {
                    outputQueue.addLast(operatorStack.removeLast().toString())
                }
                operatorStack.removeLast() // Remove the "(" from the stack
            }
        }
    }

    while (operatorStack.isNotEmpty()) {
        outputQueue.addLast(operatorStack.removeLast().toString())
    }

    return outputQueue.joinToString(" ")
}

fun String.isDouble(): Boolean = this.toDoubleOrNull() != null

fun main() {
    val expression = "3 + 4 * 2 / (1 - 5) ^ 2 ^ 3"
    println("Postfix: ${shuntingYard(expression)}")
}
