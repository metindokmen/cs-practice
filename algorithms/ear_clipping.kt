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
