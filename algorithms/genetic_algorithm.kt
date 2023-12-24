// Genetic Algorithms (GAs) are adaptive heuristic search algorithms based on the evolutionary ideas of natural selection and genetics.
// They represent an intelligent exploitation of a random search used to solve optimization problems.
// Essentially, you start with a population of random solutions (chromosomes), evolve the population over several generations, and select the best ones.

// Imagine you're designing an AI for a racing game, where the goal is to find the optimal path and speed for completing a track in the shortest time.
// There are countless combinations of turns, accelerations, and braking points.
// A genetic algorithm can evolve solutions over generations, much like natural selection, to find an optimal or near-optimal solution that represents the best racing strategy.

data class Individual(val genes: IntArray, var fitness: Int = 0)

fun calculateFitness(individual: Individual): Int {
    // Define a fitness function
    return individual.genes.sum()
}

fun selection(population: List<Individual>): Pair<Individual, Individual> {
    // Select two individuals based on fitness
    return population.sortedByDescending { it.fitness }.take(2).let { it[0] to it[1] }
}

fun crossover(parent1: Individual, parent2: Individual): Individual {
    // Create a new offspring
    val crossoverPoint = parent1.genes.size / 2
    val genes = parent1.genes.copyOf()
    for (i in crossoverPoint until parent2.genes.size) {
        genes[i] = parent2.genes[i]
    }
    return Individual(genes)
}

fun mutate(individual: Individual) {
    // Randomly mutate the individual's genes
    individual.genes.indices.random().let { index ->
        individual.genes[index] = (individual.genes[index] + 1) % 2 // Example mutation
    }
}

fun geneticAlgorithm(population: MutableList<Individual>, generations: Int): Individual {
    for (i in 0 until generations) {
        val (parent1, parent2) = selection(population)
        val offspring = crossover(parent1, parent2)
        mutate(offspring)
        offspring.fitness = calculateFitness(offspring)
        population.add(offspring)
    }
    return population.maxByOrNull { it.fitness } ?: population.first()
}

fun main() {
    val population = MutableList(10) { Individual(IntArray(5) { (0..1).random() }) }
    population.forEach { it.fitness = calculateFitness(it) }

    val generations = 20
    val fittest = geneticAlgorithm(population, generations)

    println("Fittest Individual: ${fittest.genes.joinToString()} with fitness ${fittest.fitness}")
}
