package livecoding2
import java.util.ArrayDeque
import java.util.Stack


class MyQueue {
    private val inputStack = ArrayDeque<Int>()
    private val outputStack = ArrayDeque<Int>()

    fun push(x: Int) {
        inputStack.addLast(x)
    }

    fun pop(): Int {
        moveElementsIfNeeded()
        return outputStack.removeLast()
    }

    fun peek(): Int {
        moveElementsIfNeeded()
        return outputStack.peekLast()
    }

    fun empty(): Boolean {
        return inputStack.isEmpty() && outputStack.isEmpty()
    }

    private fun moveElementsIfNeeded() {
        if (outputStack.isEmpty()) {
            while (inputStack.isNotEmpty()) {
                outputStack.addLast(inputStack.removeLast())
            }
        }
    }
}
