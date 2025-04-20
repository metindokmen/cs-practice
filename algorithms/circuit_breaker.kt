enum class State { CLOSED, OPEN, HALF_OPEN }

class CircuitBreaker(
    private val failureThreshold: Int = 3,
    private val recoveryTimeout: Long = 5000
) {
    private var state = State.CLOSED
    private var failureCount = 0
    private var lastFailureTime = 0L

    fun <T> call(operation: () -> T): T? {
        val now = System.currentTimeMillis()

        when (state) {
            State.OPEN -> {
                if (now - lastFailureTime > recoveryTimeout) {
                    state = State.HALF_OPEN
                } else {
                    println("Circuit is OPEN. Request blocked.")
                    return null
                }
            }
            State.HALF_OPEN -> {
                return try {
                    val result = operation()
                    println("Circuit is CLOSED again.")
                    reset()
                    result
                } catch (e: Exception) {
                    println("Half-open test failed. Back to OPEN.")
                    trip()
                    null
                }
            }
            State.CLOSED -> {
                return try {
                    operation()
                } catch (e: Exception) {
                    failureCount++
                    println("Failure count: $failureCount")
                    if (failureCount >= failureThreshold) {
                        trip()
                    }
                    null
                }
            }
        }
        return null
    }

    private fun trip() {
        state = State.OPEN
        lastFailureTime = System.currentTimeMillis()
        println("Circuit tripped to OPEN.")
    }

    private fun reset() {
        state = State.CLOSED
        failureCount = 0
    }
}
