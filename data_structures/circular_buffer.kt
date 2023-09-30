// A Circular Buffer is a fixed-size data structure that uses a single, continuous block of memory.
// It behaves as if the memory is connected end-to-end, forming a circle.
// When the buffer is full and a subsequent write occurs, the oldest data in the circular buffer is overwritten with the newest data.
// It's useful in scenarios where old data has not significance after a certain point.

// Think of a music player that has a feature to replay the last 10 seconds of a song.
// The player doesn't need to store the entire song in memory, just the last 10 seconds.
// A circular buffer can be used to constantly store the last 10 seconds of audio data.
// When the buffer is full, the oldest data is overwritten with the newest chunk of audio.

class CircularBuffer<T>(private val size: Int) {
    private val buffer: Array<Any?> = arrayOfNulls(size)
    private var start = 0
    private var end = 0

    fun write(value: T) {
        if (end == start && buffer[end] != null) {
            // Buffer is full, increment start to overwrite oldest data
            start = (start + 1) % size
        }
        buffer[end] = value
        end = (end + 1) % size
    }

    fun read(): T? {
        if (start == end && buffer[start] == null) {
            // Buffer is empty
            return null
        }
        val value = buffer[start]
        buffer[start] = null
        start = (start + 1) % size
        return value as T?
    }

    fun isFull() = (end == start && buffer[end] != null)
    fun isEmpty() = (end == start && buffer[start] == null)
}
