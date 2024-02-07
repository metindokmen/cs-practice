// An R-tree is a tree data structure optimized for indexing spatial information in multi-dimensional space.
// Each node in an R-tree represents a bounding box that encompasses a group of spatial objects.
// The root node represents the entire space, and as you traverse down the tree, the bounding boxes become more specific.
// Each leaf node contains references to actual spatial objects.

// Consider a mapping application where you want to efficiently find all restaurants within a certain area on the map.
// The application needs to handle queries like "find all restaurants within this bounding box."
// An R-tree can efficiently index the spatial data of restaurants' locations and quickly answer such queries.
