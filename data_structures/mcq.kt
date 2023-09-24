// A multiple choice questionnaire consists of a series of questions, each with a set of possible answers.
// Each question only has one correct answer.

// Think of an online quiz application where users answer a set of questions to test their knowledge on a given subject.
// Each question provides 4 possible answers, and users have to select the correct answer.
// At the end, the application evaluates the user's responses and provides a score.

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

class Quesstionnaire(private val questions: List<Question>) {
    fun administer(answers: List<Int>): Int {
        if (answers.size != questions.size) {
            throw IllegalArgumentException("Number of answers given does not match the number of questions.")
        }

        return answers.zip(questions) { answer, question ->
            if (answer == question.correctAnswerIndex) 1 else 0
        }.sum()
    }
}

fun main() {
    val questions = listOf(
        Question("What is the capital of France?", listOf("Berlin", "Istanbul", "Paris", "Rome"), 2),
        Question("Which planet is known as the Red Planet?", listOf("Earth", "Mars", "Jupiter", "Venus"), 1)
    )

    val quiz = Quesstionnaire(questions)
    val userAnswers = listOf(2, 1) // User selected "Paris" and "Mars" for the first and second questions respectively.

    val score = quiz.administer(userAnswers)
    println("User scored: $score/${questions.size}")
}