// Run Length Encoding is a data compression technique in which consecutive data elements (pixels, characters, etc.) are replaced by just one data value and a count.
// It's most efficient on data that contains many such runs, makint it well-suited for compressing images, text documents with many spaces, or any data with repeated elements.

// Imagine you have a document scanning app, and you need to compress black-and-white images where large areas of the image are the same color.
// In such cases, it's inefficient to store each pixel's color individually.
// Run-Length Encoding (RLE) offers a solution by encoding consecutive elements (pixels) of the same value (color) as a single data value and count.
