// The Ear Clipping Algorithm is a method for triangulating a polygon by dividing it into triangles.
// It works by finding 'ears' in the polygon, which are triangles that can be cut off (or 'clipped') without cutting into the rest of the polygon.
// An 'ear' is a set of three consecutive vertices A, B, C where the triangle ABC is entirely inside the polygon, and no other vertices of the polygon are inside ABC.

// Imagine you're developing a 3D modeling software where users can create complex shapes.
// To render these shapes efficiently, especially for non-convex polygons, you need to break them down into simpler components.
// The Ear Clipping Algorithm can triangulate a polygon, dividing it into triangles, which are the simplest shapes for rendering in computer graphics.

data class Point(val x: Double, val y: Double)

fun isConvex(p: Point, q: Point, r: Point): Boolean {
    val crossProduct = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)
    return crossProduct < 0
}

fun isEar(p: Point, q: Point, r: Point, remainingVertices: List<Point>): Boolean {
    if (!isConvex(p, q, r)) return false

    for (s in remainingVertices) {
        if (s != p && s != q && s != r && isInsideTriangle(p, q, r, s)) {
            return false
        }
    }
    return true
}

fun earClipping(vertices: MutableList<Point>): List<Triple<Point, Point, Point>> {
    val triangles = mutableListOf<Triple<Point, Point, Point>>()
    val remainingVertices = vertices.toMutableList()

    while (remainingVertices.size > 3) {
        var earFound = false

        for (i in remainingVertices.indices) {
            val prevIndex = if (i == 0) remainingVertices.size - 1 else i - 1
            val nextIndex = if (i == remainingVertices.size - 1) 0 else i + 1

            val p = remainingVertices[prevIndex]
            val q = remainingVertices[i]
            val r = remainingVertices[nextIndex]

            if (isEar(p, q, r, remainingVertices)) {
                triangles.add(Triple(p, q, r))
                remainingVertices.removeAt(i)
                earFound = true
                break
            }
        }

        if (!earFound) {
            throw Exception("No ear found. The polygon might be self-intersecting.")
        }
    }

    triangles.add(Triple(remainingVertices[0], remainingVertices[1], remainingVertices[2]))
    return triangles
}

fun isInsideTriangle(p: Point, q: Point, r: Point, s: Point): Boolean {
    // Implement point-in-triangle test (e.q., using barycentric coordinates)
    return true // Placeholder
}

fun main() {
    val polygonVertices = mutableListOf(
        Point(0.0, 0.0),
        Point(1.0, 0.0),
        Point(1.0, 1.0),
        Point(0.5, 1.5),
        Point(0.0, 1.0),
    )

    val triangles = earClipping(polygonVertices)
    println("Triangles: $triangles")
}
