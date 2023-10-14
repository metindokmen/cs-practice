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
