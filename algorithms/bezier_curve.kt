// A Bézier Curve is a parametric curve frequently used in computer graphics and related fields.
// The simplest form is the linear Bézier curve, which is a straight line.
// The quadratic and cubic Bézier curvers are more commonly used, defined by three and four points, respectively.
// The algorithm uses a recursive approach to divide the curve into smaller segments, each approximating the curve.

// Imagine you're developing a graphic design tool and need to allow users to draw smooth, curved lines that can be easily adjusted.
// Bézier curves are perfect for this purpose. They are defined by a set of control points, and the curve is drawn by linearly interpolating these points.
// This makes them very useful in vector graphic design software, computer animation, and user interface design.

data class Point(val x: Double, val y: Double)

fun quadraticBezier(p0: Point, p1: Point, p2: Point, t: Double): Point {
    val x = (1 - t).pow(2) * p0.x + 2 * (1 - t) * t * p1.x + t.pow(2) * p2.x
    val y = (1 - t).pow(2) * p0.y + 2 * (1 - t) * t * p1.y + t.pow(2) * p2.y
    return Point(x, y)
}
