// A 2D array is an array of arrays. They're also known as a matrix.
// You can visualize it as a table with rows and columns.
// Each element in the matrix can be accessed using two indices: one for the row and one for the column.

// Think of a cinema hall with multiple rows and seats in each row.
// To specificy a particular seat, you would refer to its row number and its position within that row.

// The cinema hall is the 2D array.
// Each row in the hall represents a sub-array.
// Individual seats within a row are elements of those sub-arrays.

fun main() {	
	// We initialize a 2D array with 3 rows and 4 columns.
	val cinemaHall: Array<Array<Number>> = Array(3) { Array(4) {"Empty"} }

	// When visualized, it would look like this (replace seat numbers with the string 'empty' in the above case):
	// val cinemaHall = arrayOf(
	// 	arrayOf(1, 2, 3, 4),
	// 	arrayOf(5, 6, 7, 8),
	// 	arrayOf(9, 10, 11, 12)
	// )

	for (row in cinemaHall) {
		for (seat in row) {
			print("$seat \t")
		}
		println("\n")
	}

	cinemaHall[2][3] = "Booked"

	if (cinemaHall[2][3] == "Booked") {
		// This is the last seat, numbered 12.
		println("The seat in the third row, fourth column is booked.")
	}
}