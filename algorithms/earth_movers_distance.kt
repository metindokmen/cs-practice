// EMD measures the minimum amount of work needed to transform one distribution into another, considering the "cost" of moving material from one point to another.

// Consider comparing the color distribution of two images. EMD can be applied to measure how much effort (distance) it would take to transform the color distribution of one image into another.

// The following dependency is to be added to the build.gradle file:
// implementation 'org.apache.commons:commons-math3:3.6.1'

import org.apache.commons.math3.analysis.function.Abs
import org.apache.commons.math3.analysis.function.Multiply
import org.apache.commons.math3.analysis.function.Pow
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction
import org.apache.commons.math3.linear.RealMatrix
import org.apache.commons.math3.linear.SparseRealMatrix
import org.apache.commons.math3.optim.MaxIter
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunction
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer.Simplex
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer.SimplexFactory
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer.SimplexOptimizerBuilder
import org.apache.commons.math3.util.FastMath
import kotlin.math.abs
import kotlin.math.min

class EMDExample(private val distribution1: DoubleArray, private val distribution2: DoubleArray) {

    fun calculateEMD(): Double {
        val size = min(distribution1.size, distribution2.size)

        // Build the cost matrix based on the L1 distances between points
        val costMatrix = buildCostMatrix(distribution1, distribution2, size)

        // Use the Simplex algorithm to find the optimal flow
        val simplex = SimplexOptimizerBuilder()
            .setSimplex(SimplexFactory.Nelder.createSimplex(size))
            .setMaxIterations(1000)
            .build()

        val optimizer = SimplexOptimizer(simplex)

        val objectiveFunction = ObjectiveFunction(EMDObjectiveFunction(costMatrix))
        val result = optimizer.optimize(MaxIter(1000), GoalType.MINIMIZE, objectiveFunction)

        return result.value
    }

    private fun buildCostMatrix(distribution1: DoubleArray, distribution2: DoubleArray, size: Int): RealMatrix {
        val costMatrix = SparseRealMatrix(size, size)

        for (i in 0 until size) {
            for (j in 0 until size) {
                val distance = abs(i - j)
                costMatrix.setEntry(i, j, distance.toDouble())
            }
        }

        return costMatrix
    }

    private class EMDObjectiveFunction(private val costMatrix: RealMatrix) : org.apache.commons.math3.optim.univariate.ObjectiveFunction {
        override fun value(x: Double): Double {
            val flowMatrix = calculateFlowMatrix(x)
            return calculateTotalCost(flowMatrix)
        }

        private fun calculateFlowMatrix(x: Double): RealMatrix {
            val size = costMatrix.rowDimension
            val flowMatrix = SparseRealMatrix(size, size)

            for (i in 0 until size) {
                for (j in 0 until size) {
                    val flow = min(distribution1[i], distribution2[j]) * x
                    flowMatrix.setEntry(i, j, flow)
                }
            }

            return flowMatrix
        }

    }
}
