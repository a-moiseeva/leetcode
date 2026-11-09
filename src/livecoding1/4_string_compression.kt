package livecoding1

class Solution4 {
    fun compress(chars: CharArray): Int {
        var count = 0
        var current = chars[0]
        var j = 0
        for (i in 0..chars.size - 1) {

            if (chars[i] == current) {
                count++
            }
            if (chars[i] != current) {
                chars[j] = current
                j++
                if (count > 9) {
                    val s = count.toString()
                    val l = s.length
                    var newcount = count
                    for (i in 1..l) {
                        val stepen = Math.pow(10.toDouble(), l.toDouble() - i.toDouble())
                        val x = newcount / stepen.toInt()
                        chars[j] = ('0'.code + x).toChar()
                        j++
                        newcount = newcount - stepen.toInt() * x
                    }
                } else if (count > 1) {
                    chars[j] = ('0'.code + count).toChar(); j++
                }
                current = chars[i]
                count = 1
            }
        }
        chars[j] = current
        j++
        if (count > 9) {
            val s = count.toString()
            val l = s.length
            var newcount = count
            for (i in 1..l) {
                val stepen = Math.pow(10.toDouble(), l.toDouble() - i.toDouble())
                val x = newcount / stepen.toInt()
                chars[j] = ('0'.code + x).toChar()
                j++
                newcount = newcount - stepen.toInt() * x
            }
        } else if (count > 1) {
            chars[j] = ('0'.code + count).toChar(); j++
        }
        return j

    }
}

class Solution7678 {
    fun compress(chars: CharArray): Int {
        var read = 0
        var write = 0
        val n = chars.size
        while (read < n) {
            var times = 0
            val cur_char = chars[read]
            while (read < n&&chars[read] == cur_char) {
                read++
                times++
            }
            chars[write] = cur_char
            write++
            if (times > 1) {
                val number = times.toString()
                for (i in number) {
                    chars[write] = i
                    write++
                }
            }
            println(chars.contentToString())

        }




        return write

    }

}

fun main() {

    // val chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    val chars = charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c')
    /*  val chars = charArrayOf('a')*/
    println(Solution7678().compress(chars))
}