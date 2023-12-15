// Simulated Annealing is a probabilistic technique used for finding an approximate solution to an optimization problem.
// The algorithm randomly explores the solution space, accepting not only changes that improve the solution but also, with a certain probability, changes that worsen it.
// This probability decreases with time, mimicking the cooling of metal, thus reducing the changes of making bad moves as the algorithm progresses.

// Imagine you're trying to solve a complex optimization problem, like finding the most efficient route for a delivery truck that needs to visit multiple locations.
// Traditional algorithms might get stuck in a local minimum, where they find a good solution, but not the best one.
// Simulated Annealing, insipred by the process of annealing in metallurgy, offers a way to escape these local minima and search for a global minimum (or maximum) by allowing "bad" moves with decreasing probablility as the "temprerature" decreases.

import kotlin.math.exp
import kotlin.random.Random

fun simulatedAnnealing(startSolution: Double, temp: Double, coolingRate: Double, endTemp: Double): Double {
    var currentSolution = startSolution
    var bestSolution = startSolution
    var currentTemp = temp

    while (currentTemp > endTemp) {
        val newSolution = currentSolution + (Random.nextDouble() - 0.5)

        val currentEnergy = objectiveFunction(currentSolution)
        val newEnergy = objectiveFunction(newSolution)

        if (acceptanceProbability(currentEnergy, newEnergy, currentTemp) > Random.nextDouble()) {
            currentSolution = newSolution
        }

        if (objectiveFunction(currentSolution) < objectiveFunction(bestSolution)) {
            bestSolution = currentSolution
        }

        currentTemp *= 1 - coolingRate
    }
    return bestSolution
}

fun objectiveFunction(value: Double): Double {
    // Hypothetical objective function, e.g., f(x) = (x-2)^2
    return (value - 2) * (value - 2)
}

fun acceptanceProbability(currentEnergy: Double, newEnergy: Double, temperature: Double): Double {
    if (newEnergy < currentEnergy) return 1.0
    return exp((currentEnergy - newEnergy) / temperature)
}
