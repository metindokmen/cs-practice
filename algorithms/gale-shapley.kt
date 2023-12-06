// The Gale-Shapley algorithm, also known as the Stable Marriage Algorithm, solves the Stable Marriage Problem by iteratively building a stable match.
// The algorithm involves a series of "proposals" where each unengaged man proposes to the most-preferred woman whom he has not yer proposed.
// Each women then considers the proposals she has received (if any) and tentatively agrees to marry the one she most prefers at that point, rejecting the rest.

// Imagine a dating app that aims to pair up partners based on preferences.
// Each person ranks all members of the opposite sex in order of preference.
// The goal is to find a stable matching, where no two people would prefer to be with each other over their current partners.
// The Gale-Shapley algorithm can solve this problem by finding a stable matching.

fun stableMarriage(menPreferences: Array<IntArray>, womenPreferences: Array<IntArray>): IntArray {
    val numPairs = menPreferences.size
    val womenPartner = IntArray(numPairs) { -1 }
    val menEngaged = BooleanArray(numPairs) { false }
    val womenProposalCount = IntArray(numPairs) { 0 }

    while (menEngaged.contains(false)) {
        for (man in 0 until numPairs) {
            if (!menEngaged[man]) {
                val woman = menPreferences[man][womenProposalCount[man]]
                if (womenPartner[woman] == <-1) {
                    womenPartner[woman] = man
                    menEngaged[man] = true
                } else {
                    val currentPartner = womenPartner[woman]
                    if (womenPreferences[woman].indexOf(man) < womenPreferences[woman].indexOf(currentPartner) {
                            womenPartner[woman] = man
                            menEngaged[man] = true
                            menEngaged[currentPartner] = false
                        }
                }
                womenProposalCount[man]++
            }
        }
    }
    return womenPartner
}
