// The Hopcroft-Karp Algorithm is an efficient algorithm for finding the maximum cardinality matching in a bipartite graph.
// It's an improvement over the Ford-Fulkerson Algorithm for this specific problem.

// Imagine a scenario where you have a set of applicants and a set of job positions,
// and you want to match applicants to job positions such that each job position is filled with a suitable applicant.
// The Hopcroft-Karp Algorithm can efficiently find the maximum number of such matches in a bipartite graph,
// ensuring that every job position is assigned to exactly one applicant.

class HopcroftKarp(val graph: List<List<Int>>, val numApplicants: Int, val numJobs: Int) {
    private val NIL = 0
    private val INF = Int.MAX_VALUE
    private val matching = IntArray(numJobs + 1) { NIL }
    private val dist = IntArray(numApplicants + 1) { NIL }

    fun maxMatching(): Int {
        var matchingCount = 0
        while (bfs()) {
            for (applicant in 1..numApplicants) {
                if (matching[applicant] == NIL && dfs(applicant)) {
                    matchingCount++
                }
            }
        }
        return matchingCount
    }

    private fun bfs(): Boolean {
        val queue = mutableListOf<Int>()
        for (applicant in 1..numApplicants) {
            if (matching[applicant] == NIL) {
                dist[applicant] = 0
                queue.add(applicant)
            } else {
                dist[applicant] = INF
            }
        }
        dist[NIL] = INF

        while (queue.isNotEmpty()) {
            val u = queue.removeAt(0)
            if (dist[u] < dist[NIL]) {
                for (v in graph[u]) {
                    if (dist[matching[v]] == INF) {
                        dist[matching[v]] = dist[u] + 1
                        queue.add(matching[v])
                    }
                }
            }
        }
        return dist[NIL] != INF
    }

    private fun dfs(applicant: Int): Boolean {
        if (applicant != NIL) {
            for (job in graph[applicant]) {
                if (dist[matching[job]] == dist[applicant] + 1 && dfs(matching[job])) {
                    matching[job] = applicant
                    matching[applicant] = job
                    return true
                }
            }
            dist[applicant] = INF
            return false
        }
        return true
    }
}
