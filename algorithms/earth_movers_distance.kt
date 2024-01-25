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
