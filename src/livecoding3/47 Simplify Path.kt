package livecoding3

fun simplifyPath(path: String): String {
    val stack = ArrayDeque<String>()

    for (part in path.split("/")) {
        when (part) {
            "", "." -> {
                // Игнорируем пустые элементы и текущую директорию
            }

            ".." -> {
                if (stack.isNotEmpty()) {
                    stack.removeLast()
                }
            }

            else -> {
                // Любые другие последовательности точек —
                // обычные имена директорий
                stack.addLast(part)
            }
        }
    }

    return if (stack.isEmpty()) {
        "/"
    } else {
        "/" + stack.joinToString("/")
    }
}
