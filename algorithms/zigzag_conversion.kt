// The Zigzag Conversion Algorithm rearranges characters of a string into a specified number of rows in a zigzag pattern.
// When reading the text line by line, it results in a different string.
// The algorithm calculates the position of each character in the original string for each row of the zigzag pattern.

// Imagine you're developing a text formatting tool that needs to display text in a zigzag pattern for stylistic purposes.
// For instance, the word "KOTLIN" could be displayed in a two-row zigzag like this:

//K   I
//O T L N

// This kind of pattern is common in certain types of artistic text rendering or playful user interfaces.

fun convertToZigzag(s: String, numRows: Int): String {
    if (numRows == 1) return s

    val rows = MutableList(minOf(numRows, s.length)) { StringBuilder() }
    var curRow = 0
    var goingDown = false

    for (c in s) {
        rows[curRow].append(c)
        if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown
        curRow += if (goingDown) 1 else -1
    }

    return rows.joinToString("") { it.toString() }
}

fun main() {
    val input = "KOTLIN"
    val numRows = 2
    val zigzag = convertToZigzag(input, numRows)
    println(zigzag)
}
