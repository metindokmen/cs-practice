// Bresenham's Algorithm is an efficient way to draw a straight line between two points in a computer graphics context.
// It determines which pixels should be plotted in order to form a close approximation of a straight line between two points.
// The algorithm works by iterating over the dominant axis (either x or y) and calculating the minor axis pixel based on a decision variable.
// It requires only integer addition, subtraction, and bit shifting, all of which are very fast operations.

// Imagine you're developing a graphics drawing application where you need to draw straight lines between points on a raster grid (like pixels on a computer screen).
// While you could use a simple equation of a line for this, it would require floating-point arithmetic, which is computationally expensive.
// Bresenham's Line Drawing Algorithm provides an efficient way to draw lines using only integer arithmetic, making it well-suited for computer graphics where performance is key.

fun drawLine(x0: Int, y0: Int, x1: Int, y1: Int): List<Pair<Int, Int>> {
    val pixels = mutableListOf<Pair<Int, Int>>()

    var dx = Math.abs(x1 - x0)
    var dy = Math.abs(y1 - y0)

    var sx = if (x0 < x1) 1 else -1
    var sy = if (y0 < y1) 1 else -1

    var err = dx - dy
    var e2: Int

    var x = x0
    var y = y0

    while (true) {
        pixels.add(Pair(x, y))
        if (x == x1 && y == y1) break
        e2 = 2 * err
        if (e2 > -dy) {
            err -= dy
            x += sx
        }
        if (e2 < dx) {
            err += dx
            y += sy
        }
    }

    return pixels
}

fun main() {
    val linePixels = drawLine(0, 0, 8, 6)
    println("Line Pixels: $linePixels")
}
