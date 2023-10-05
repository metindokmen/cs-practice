// A Segment Tree is a binary tree used for multiple purposes, most notably for:

// 1. Range query problems (like finding the minimum, maximum, or sum between two indices of an array)
// 2. Lazy propagation (deferring updates to optimize multiple updates)

// Each leaf node of the Segment Tree represents an element of the array, and each internal node represents some merging of its children nodes (e.g. sum, minimum)

// Suppose you have a series of weather stations across a long highway, each recording the temperature every hour.
// You're tasked with building a system where you can quickly find out:

// 1. The average temperature between two stations.
// 2. Update the temperature reading of a station.

// The Segment Tree can efficiently handle these operations.