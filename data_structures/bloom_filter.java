// A Bloom Filter is a probabilistic data structure that is used to test whether an element is a member of a set.
// It can return false positives but never false negatives.
// This means it might indicate that an element is in the set even when it's not,
// but if it says the element is not in the set, you can be sure that it isn't.

// Imagine you are building an email system that needs to quickly check if an incoming email is spam.
// You maintain a large list of known spam emails and want to quickly check if the sender's email address is in that list.
// Using a Bloom Filter, you can quickly determine if the email address might be spam.
// If the Bloom Filter says "no", you can be certain it isn't spam; if it says "yes", you can further investigate or apply more intensive checks.
