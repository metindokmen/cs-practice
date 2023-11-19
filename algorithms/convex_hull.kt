// The Graham Scan algorithm is a method of computing the convex hull of a finite set of points in the plane.
// The convex hull of a set of points is the smallest convex polygon that contains all the points.
// The algorithm works by first finding the point with the lowest y-coordinate (and the leftmost one in case of a tie),
// and then sorting the remaining points based on the angle they and the initial point make with the x-axis.
// After sorting, it constructs the hull using a stack and by traversing the sorted array of points.

// Imagine you're a land surveyor tasked with finding the smallest polygonal area that encloses a set of points on a map.
// These points could represent the locations of various landmarks.
// The convex hull is the smallest convex oolygon that encompasses all these points.
// Using the Graham Scan algorithm, you can efficiently compute this convex polygon.

data class Point(val x: Int, val y: Int)

fun orientation(p: Point, q: Point, r: Point): Int {
    val val1 = (q.y - p.y) * (r.x - q.x)
    val val2 = (q.x - p.x) * (r.y - q.y)

    return when {
        val1 == val2 -> 0   // colinear
        val1 > val2 -> 1    // clockwise
        else -> 2           // counterclockwise
    }
}
