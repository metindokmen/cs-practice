// The Graham Scan algorithm is a method of computing the convex hull of a finite set of points in the plane.
// The convex hull of a set of points is the smallest convex polygon that contains all the points.
// The algorithm works by first finding the point with the lowest y-coordinate (and the leftmost one in case of a tie),
// and then sorting the remaining points based on the angle they and the initial point make with the x-axis.
// After sorting, it constructs the hull using a stack and by traversing the sorted array of points.
