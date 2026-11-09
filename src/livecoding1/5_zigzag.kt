package livecoding1


class ZigzagIteratorFinal2(
    private val v1: List<Int>,
    private val v2: List<Int>
) {
    val m = v1.size
    val n = v2.size
    val v = listOf(v1, v2)
    var sizes = listOf(m, n)
    var poses = IntArray(2){0}
    var cur = 0
    fun hasNext(): Boolean {
        if (poses[cur] < sizes[cur]) return true

        cur = (cur + 1) % 2
        if (poses[cur] < sizes[cur]) return true
        return false
    }
    fun next(): Int {
        hasNext()
        val answ = v[cur][poses[cur]]
        poses[cur]++
        cur = (cur + 1) % 2
        return answ
    }
}
fun main(){
    val z = ZigzagIteratorFinal2(listOf(1,2,3,4,5), listOf(8,9))
    println(z.next())
    println(z.hasNext())
    println(z.next())
    println(z.next())
    println(z.hasNext())
    println(z.next())
    println(z.next())
    println(z.next())
    println(z.next())
    println(z.hasNext())
    println(z.next())
    println(z.next())
    println(z.hasNext())
    println(z.next())
    println(z.hasNext())
    println(z.next())
}



class ZigzagIteratorFinal(
    private val v1: List<Int>,
    private val v2: List<Int>
) {
    private val vectors = listOf(v1, v2)
    private val indexes = IntArray(2)
    private var currentVector = 0

    fun next(): Int {
        if (!hasNext()) {
            throw NoSuchElementException("Iterator has no more elements")
        }
        val result = vectors[currentVector][indexes[currentVector]]
        indexes[currentVector]++
        currentVector = (currentVector + 1) % 2
        return result
    }

    fun hasNext(): Boolean {
        repeat(2) {
            if (indexes[currentVector] < vectors[currentVector].size) {
                return true
            }
            // Текущий вектор закончился — переходим к следующему
            currentVector = (currentVector + 1) % 2
        }

        return false
    }
}


class ZigzagIterator(
    v1: List<Int>,
    v2: List<Int>
) {
    val answer = mutableListOf<Int>()
    var n = 0
    var j = 0

    init {
        var i = 0
        while (i < v1.size && i < v2.size) {
            answer.add(v1[i])
            answer.add(v2[i])
            i++
        }
        while (i < v1.size) {
            answer.add(v1[i])
            i++
        }
        while (i < v2.size) {
            answer.add(v2[i])
            i++
        }
        n = answer.size
    }

    fun next(): Int {
        return answer[j].also { j++ }

    }

    fun hasNext(): Boolean {
        return (j < n)
    }

}

class Solution55 {
    fun compress(v1: List<Int>, v2: List<Int>): List<Int> {
        var i = 0
        val answer = mutableListOf<Int>()
        while (i < v1.size && i < v2.size) {
            answer.add(v1[i])
            answer.add(v2[i])
            i++
        }
        while (i < v1.size) {
            answer.add(v1[i])
            i++
        }
        while (i < v2.size) {
            answer.add(v2[i])
            i++
        }
        return answer
    }
}

fun main4() {
    /*    val a=listOf(1,2)
        val b=listOf(5,6,7,8)*/
    val a = listOf<Int>()
    val b = listOf<Int>(1)
    println(Solution55().compress(a, b).joinToString(" "))

    val iterator = ZigzagIterator(
        listOf(1, 2),
        listOf(3, 4, 5, 6)
    )


    while (iterator.hasNext()) {
        print("${iterator.next()} ")
    }

}


class ZigzagIteratorFinal1(
    private val v1: List<Int>,
    private val v2: List<Int>
) {
    val vectors = listOf(v1, v2)
    var currentVector = 0
    var vectorSizes = listOf(v1.size, v2.size)
    var curPoses = mutableListOf(0, 0)
    fun hasNext(): Boolean {
        repeat(2) {
            currentVector = (currentVector + 1) % 2
            if (curPoses[currentVector] < vectorSizes[currentVector]) {
                return true
            }
        }
        return false
    }

    fun next(): Int {
        hasNext()
        val answ = vectors[currentVector][curPoses[currentVector]]
        curPoses[currentVector]++
        return answ
    }

}