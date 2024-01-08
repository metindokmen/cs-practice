// KNN is a simple and effective algorithm based on the principle that similar data points are close to each other in the feature space.
// It classifies a new data point or predicts its value by considering the majority class or average value of its k-nearest neighbors.

// Imagine you are working on a movie recommendation system.
// Users who liked a certain movie are potential candidates for similar movie recommendations.
// The K-Nearest Neighbors algorithm can identify movies liked by users with similar preferences, helping to recommend movies based on the preferences of their "neighbors".

data class Movie(val name: String, val genre: String, val rating: Double)

class KNNClassifier(private val k: Int, private val movies: List<Movie>) {
    fun classify(newMovie: Movie): String {
        val neighbors = findKNearestNeighbors(newMovie)
        val majorityGenre = neighbors.groupingBy { it.genre }.eachCount().maxByOrNull { it.value }?.key
        return majorityGenre ?: "Unknown"
    }

    private fun findKNearestNeighbors(newMovie: Movie): List<Movie> {
        return movies
            .filter { it != newMovie } // Exclude the new movie itself
            .sortedBy { it.rating } // Assume lower rating indicates closer similarity
            .take(k)
    }
}
