// The BCNF Decomposition Algorithm is used in database normalization to decompose relation that is not in BCNF into a set of relations that are in BCNF.
// BCNF, a stricter version of the Third Normal Form (3NF), aims to resolve anomalies resulting from functional dependencies in a database.

// Imagine you're designing a database for a university.
// The database includes information about courses, the departments they belong to, and the professors teaching them.
// Over time, you notice that there are redundancies and anomalies due to the way this data is structured.
// To optimize the database, reduce redundancy, and improve data integrity, you can use the BCNF Decomposition Algorithm.
// It helps restructure the database into tables that better represent the relationship between different types of data.

// Represents a table or relation in a database
data class Relation(val attributes: Set<String>, val dependencies: Set<FunctionalDependency>)

// Represents a functional dependency, e.g., "A -> B"
data class FunctionalDependency(val determinant: Set<String>, val dependent: Set<String>)
