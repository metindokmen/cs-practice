// Sleep Sort is more of a conceptual and humorous sorting algorithm and is typically not used in practical applications due to its unreliablity and inefficiency.
// It's based on the idea of using sleep or delay in threads, where each element in the array causes the program to sleep for an interval proportional to the element's value before outputting the element.

// Imagine you're coordinating a series of timed events, where each event must start after a certain delay.
// You could simulate this by assigning a timer to each event, and as the timer expires, the event starts.
// Sleep Sort works in a similar way by creating a separate process or thread for each item in the array to be sorted.
// Each thread sleeps for an amount of time proportional to the item's value, then outputs the item.
// The result is that items are "woken up" (output) in ascending order.
