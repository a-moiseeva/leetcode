package livecoding3

import java.util.ArrayDeque

class Solution45 {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) {
            when (token) {
                "+" -> {
                    val right = stack.removeLast()
                    val left = stack.removeLast()
                    stack.addLast(left + right)
                }

                "-" -> {
                    val right = stack.removeLast()
                    val left = stack.removeLast()
                    stack.addLast(left - right)
                }

                "*" -> {
                    val right = stack.removeLast()
                    val left = stack.removeLast()
                    stack.addLast(left * right)
                }

                "/" -> {
                    val right = stack.removeLast()
                    val left = stack.removeLast()
                    stack.addLast(left / right)
                }

                else -> {
                    stack.addLast(token.toInt())
                }
            }
        }

        return stack.removeLast()
    }
}
