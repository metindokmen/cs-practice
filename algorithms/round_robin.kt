// The Round Robin algorithm is a load-balancing algorithm
// that distributes requests sequentially among a list of servers,
// cycling back to the first server once it reaches the last one.

// This approach ensures even distribution of traffic across all servers
// and is often used in scenarious like reverse-proxy load balancers
// where each server in a replica set receives rougly the same amount of traffic over time.


// Representative of each replica server
class Server(val name: String) {
    fun handleRequest(request: String) {
        println("Request '$request' is handled by server: $name")
    }
}

// Reverse Proxy Server to Distribute Incoming Traffic Evenly
class RoundRobinLoadBalancer(servers: List<Server>) {
    private val servers = servers.toList()  // Copy of the server list
    private var currentIndex = 0            // Track the next server to handle a request

    // Select the next server and handle the request
    fun getNextServer(): Server {
        val server = servers[currentIndex]
        currentIndex = (currentIndex + 1) % servers.size    // Move to the next server
        return server
    }
}

fun main() {
    val servers = listOf(
            Server("Server 1"),
            Server("Server 2"),
            Server("Server 3")
    )

    val loadBalancer = RoundRobinLoadBalancer(servers)

    val requests = listOf("Request A", "Request B", "Request C", "Request D", "Request E")

    // Distribute across servers
    for (request in requests) {
        val server = loadBalancer.getNextServer()
        server.handleRequest(request)
    }
}
