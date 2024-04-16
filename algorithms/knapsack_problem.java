// The Knapsack Problem is a classic optimization problem where the goal is to maximize the total value of items selected, given a weight constraint.
// There are two main variations of the problem: 0/1 Knapsack (where items cannot be divided) and Fractional Knapsack (where items can be taken in fractions).

// Steps for 0/1 Knapsack:
// 1. Initialize a 2D array `dp` where `dp[i][j]` represents the maximum value that can be achieved with the first `i` items and a knapsack capacity of `j`.
// 2. Use dynamic programming to fill the `dp` table:
// - If adding the `i`-th item exceeds the current capacity `j`, then `dp[i][j]` is the same as `dp[i-1][j]`.
// - Otherwise, consider the maximum value between including and excluding the `i`-th item: `dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])`

// Imagine you are a thief trying to maximize the value of items you can steal from a store, but you have a limited capacity (weight) that you can carry in your knapsack.
// Each items has a specific weight and value, and the goal is to select a combination of items that maximizes the total value without exceeding the kanpsack's capacity.
