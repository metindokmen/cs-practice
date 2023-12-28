// Monte Carlo Simulation is a computational algorithm that relis on repeated random sampling to obtain numerical results.
// The underlying concept is to use randomness to solve problems that might be deterministic in principle.
// It's often used when it's infeasible or impossible to compute an exact result with a deterministic algorithm.

// Imagine you are working in finance and need to assess the risk of an investment portfolio.
// Predicting future stock prices accurately is complex due to numerous uncertain factors.
// Monte Carlo Simulation can help in such scenarios.
// It uses randomness to simulate a range of possibilities, computing the probability distribution of potential outcomes.
// This method is widely used in finance, physics, engineering, and gaming for risk assessment and predicting system behavior in uncertain conditions.

import kotlin.random.Random

fun estimatePi(numSamples: Int): Double {
    var insideCircle = 0

    for (i in 0 until numSamples) {
        val x = Random.nextDouble(-1.0, 1.0)
        val y = Random.nextDouble(-1.0, 1.0)

        if (x * x + y * y <= 1.0) {
            insideCircle++
        }
    }

    return 4.0 * insideCircle / numSamples
}
