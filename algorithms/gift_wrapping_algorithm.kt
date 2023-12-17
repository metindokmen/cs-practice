// The Gift Wrapping algorithm is a method of computing the convex hull of a finite set of points in the plane.
// The algorithm works by starting from the leftmost point (or the point with the lowest x-coordinate) and wrapping the hull around the set of points, much like wrapping a gift.
// At each step, it selects the point that is the most counterclockwise relative to the current point, continuing until it wraps back around to the starting point.

// Imagine you're a geologist analyzing the outer boundary of a set of sample points on a map.
// These points represent the locations where certain minerals were found, and you want to determine the smallest convex polygon that encloses all these points.
// This is essentially what the Gift Wrapping Algorithm does: It find the convex hull, which is the smallest convex polygon that encloses all the given points.

data class Point(val x: Int, val y: Int)

fun orientation(p: Point, q: Point, r: Point): Int {
    val val1 = (q.y - p.y) * (r.x - q.x)
    val val2 = (q.x - p.x) * (r.y - q.y)
    return when {
        val1 == val2 -> 0   // Collinear
        val1 > val2 -> 1    // Clockwise
        else -> 2           // Counterclockwise
    }
}

fun convexHull(points: Array<Point>): List<Point> {
    if (points.size < 3) return emptyList()

    val hull = mutableListOf<Point>()
    var l = 0
    points.forEachIndexed { i, point ->
        if (point.x < points[l].x) l = i
    }

    var p = l
    do {
        hull.add(points[p])
        var q = (p + 1) % points.size
        for (i in points.indices) {
            if (orientation(points[p], points[i], points[q]) == 2) {
                q = i
            }
        }
        p = q
    } while (p != 1)

    return hull
}
