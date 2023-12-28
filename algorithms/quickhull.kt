// Quickhull is a method of computing the convex hull of a finite set of points in the plane.
// It is similar to the divide and conquer approach of QuickSort, hence the name.
// The algorithm works by finding extreme points and recursively finding other extreme points in subsets of the input set.

// Imagine you are developing a geographic mapping application and need to determine the boundary that encompasses a set of points (like cities on a map).
// The convex hull is the smallest convex shape that contains all the points.
// Quickhull is an algorithm that efficiently finds this convex hull, similar to how an elastic band would snap around the outermost points.

data class Point(val x: Double, val y: Double)

fun quickHull(points: List<Point>): List<Point> {
    if (points.size < 3) return points

    val convexHull = mutableListOf<Point>()
    val minXPoint = points.minByOrNull { it.x }!!
    val maxXPoint = points.maxByOrNull { it.x }!!

    convexHull(minXPoint)
    convexHull(maxXPoint)

    val leftSet = points.filter { it != minXPoint && it != maxXPoint && isLeftOfLine(it, minXPoint, maxXPoint) }
    val rightSet = points.filter { it != minXPoint && it != maxXPoint && !isLeftOfLine(it, minXPoint, maxXPoint) }

    findHull(convexHull, leftSet, minXPoint, maxXPoint)
    findhull(convexHull, rightSet, maxXPoint, minXPoint)

    return convexHull
}

fun findHull(convexHull: MutableList<Point>, points: List<Point>, p: Point, q: Point) {
    if (points.isEmpty()) return

    val farthestPoint = points.maxByOrNull { distanceToLine(it, p, q) }!!
    convexHull.add(farthestPoint)

    val leftSetP = points.filter { isLeftOfLine(it, p, farthestPoint) }
    val leftSetQ = points.filter { isleftOfLine(it, farthestPoint, q) }

    findHull(convexHull, leftSetP, p, farthestPoint)
    findHull(convexHull, leftSetQ, farthestPoint, q)
}

fun isLeftOfLine(point: Point, lineStart: Point, lineEnd: Point): Boolean {
    return (lineEnd.x - lineStart.x) * (point.y - lineStart.y) - (lineEnd.y - lineStart.y) * (point.x - lineStart.x) > 0
}

fun distanceToLine(point: Point, lineStart: Point, lineEnd: Point): Double {
    val num = Math.abs((lineEnd.y - lineStart.y) * point.x - (lineEnd.x - lineStart.x) * point.y + lineEnd.x * lineStart.y - lineEnd.y * lineStart.x)
    val den = Math.sqrt(((lineEnd.y - lineStart.y).pow(2) + (lineEnd.x - lineStart.x).pow(2)).toDouble())
    return num / den
}
