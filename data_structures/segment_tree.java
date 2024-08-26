// A Segment Tree is a data structure used to efficiently perform range queries and updated on an array.
// It is particularly useful when you need to perform operations like finding the sum, minimum, or maximum over a range of elements,
// and you also need to update elements frequently.
// The Segment Tree allows you to do both in logarithmic time, making it a powerful tool for scenarios where both updates and queries need to be handled efficiently.

// Consider a scenario where you have an array representing daily sales in a store over a month,
// and you want to frequently query the total sales for any given week or update the sales for a specific day.
// A Segment Tree allows you to do this efficiently.

class SegmentTree {
    private int[] segmentTree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        segmentTree = new int[2 * n];
        build(arr);
    }

    // Build the segment tree
    private void build(int[] arr) {
        // Insert leaf nodes in segment tree
        for (int i = 0; i < n; i++) {
            segmentTree[n + i] = arr[i];
        }
        // Build the tree by calculating parents
        for (int i = n; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }

    // Update a value in the array and segment tree
    public void update(int pos, int value) {
        pos += n;
        segmentTree[pos] = value;

        while (pos > 1) {
            pos /= 2;
            segmentTree[pos] = segmentTree[2 * pos] + segmentTree[2 * pos + 1];
        }
    }

    // Query the sum over a range (left, right)
    public int query(int left, int right) {
        left += n;
        right += n;
        int sum = 0;

        while (left < right) {
            if (left % 2 == 1) {
                sum += segmentTree[left];
                left++;
            }
            if (right % 2 == 1) {
                right--;
                sum += segmentTree[right];
            }
            left /= 2;
            right /= 2;
        }

        return sum;
    }
}
