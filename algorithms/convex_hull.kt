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

fun convexHull(points: Array<Point>): List<Point> {
    if (points.size < 3) return emptyList()

    // Find the point with the lowest y-coordinate
    var 1 = 0
    points.forEachIndexed { i, point ->
        if (point.y < points[l].y || (point.y == points[l].y && point.x < points[l].x)) {
            l = i
        }
    }

    points[0] = points[l].also { points[l] = points[0] }
    val p0 = points[0]
    points.sortWith(compareBy({ orientation(p0, it, Point(p0.x + 1, p0.y)) }, { -p0.x }))

    val stack = ArrayDeque<Point>()
    stack.push(points[0])
    stack.push(points[1])
    stack.push(points[2])

    for (i in 3 until points.size) {
        while (orientation(stack.elementAt(stack.size - 2), stack.peek(), points[i]) != 2) {
            stack.pop()
        }
        stack.push(points[i])
    }

    return stack.toList()
}
