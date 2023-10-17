// A* is a popular pathfinding and graph traversal algorithm that is used to find the shortest path from starting point to a goal.
// It uses a combination of the actual distance from the start and an estimate (heuristic) of the distance to the goal and prioritize nodes.

// Consider a GPS navigation system that helps you find the shortest route from your current location to a destination.
// While there might be many possible routes, A* helps identify the most efficient one, taking into account the actual distance traveled and an estimate of the remaining distance.

data class Node(
    val position: Pair<Int, Int>,
    var: parent : Node? = null,
    var g: Int = Int.MAX_VALUE,
    var h: Int = 0,
    var f: Int = Int.MAX_VALUE
)

fun aStartSearch(start: Node, goal: Node, neighbors: (Node) -> List<Node>, heuristic: (Node, Node) -> Int): List<Node>? {
    val openList = mutableListOf(start)
    val closedList = mutableListOf<Node>()

    start.g = 0
    start.h = heuristic(start, goal)
    start.f = start.g + start.h

    while (openList.isNotEmpty()) {
        val currentNode = openList.minByOrNull { it.f }!!

        if (currentNode.position == goal.position) {
            // Reconstruct the path
            val path = mutableListOf<Node>()
            val node: Node? = currentNode
            while (node != null) {
                path.add(node)
                node = node.parent
            }
            return path.reversed()
        }

        openList.remove(currentNode)
        closedList.add(currentNode)

        for (neighbor in neighbors(currentNode)) {
            if (neighbor in closedList) continue

            val tentativeG = currentNode.g + 1 // Assuming each move has a cost of 1

            if (tentativeG < neighbor.g) {
                neighbor.parent = currentNode
                neighbor.g = tentativeG
                neighbor.h = heuristic(neighbor, goal)
                neighbor.f = neighbor.g + neighbor.h

                if (neighbor !in openList) {
                    openList.add(neighbor)
                }
            }
        }
    }
    return null
}

fun main() {
    // Simple grid: 0 is open, 1 is blocked
    val grid = arrayOf(
        intArrayOf(0, 0, 0, 1, 0),
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 0)
    )

    fun neighbors(node: Node): List<Node> {
        val dirs = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        return dirst.mapNotNull { (dx, dy) ->
            val newPos = node.position.first + dx to node.position.second _ dy
            if (newPos.first in grid.indices && newPos.second in grid[0].indices && grid[newPos.first][newPos.second] == 0) {
                Node(newPos)
            } else null
        }
    }

    fun heuristic(node: Node, goal: Node): Int {
        return Math.abs(node.position.first - goal.position.first) + Math.abs(node.position.second - goal.position.second)
    }

    val start = Node(0 to 0)
    val goal = Node(4 to 4)

    val path = aStarSearch(start, goal, ::neighbors, ::heuristic)
    path?.forEach { println(it.position) }
    // Expected Output:
    //    (0, 0)
    //    (0, 1)
    //    (0, 2)
    //    (1, 2)
    //    (2, 2)
    //    (2, 3)
    //    (2, 4)
    //    (3, 4)
    //    (4, 4)
}