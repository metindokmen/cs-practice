// The Gift Wrapping algorithm is a method of computing the convex hull of a finite set of points in the plane.
// The algorithm works by starting from the leftmost point (or the point with the lowest x-coordinate) and wrapping the hull around the set of points, much like wrapping a gift.
// At each step, it selects the point that is the most counterclockwise relative to the current point, continuing until it wraps back around to the starting point.

// Imagine you're a geologist analyzing the outer boundary of a set of sample points on a map.
// These points represent the locations where certain minerals were found, and you want to determine the smallest convex polygon that encloses all these points.
// This is essentially what the Gift Wrapping Algorithm does: It find the convex hull, which is the smallest convex polygon that encloses all the given points.
