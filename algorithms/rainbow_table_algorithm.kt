// A Rainbow Table is a data structure that's used to speed up the process of determining the plaintext input that corresponds to a given hash output.
// It's essentially a trade-off between time and space:
// by stroing precomputed hashes of possible plaintexts,
// you can quickly find the matching plaintext for a given hash,
// as long as the plaintext exists in your table.
