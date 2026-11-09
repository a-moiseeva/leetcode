package livecoding2

class Solution34 {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        if (firstList.isEmpty() || secondList.isEmpty()) return mutableListOf<IntArray>().toTypedArray()
        val sum = mutableListOf<IntArray>()
        var b = 0
        for (a in firstList) {
            val starta = a[0]
            val enda = a[1]
            while (b < secondList.size - 1 && secondList[b][1] < starta) {
                b++
            }

            val x = minOf(enda, secondList[b][1]) - maxOf(starta, secondList[b][0])
            if (x >= 0) {
                sum.add(intArrayOf(maxOf(starta, secondList[b][0]), minOf(enda, secondList[b][1])))
            }
            while (secondList[b][0] <= enda) {
                b++
                val x = minOf(enda, secondList[b][1]) - maxOf(starta, secondList[b][0])
                if (x >= 0) {
                    sum.add(intArrayOf(maxOf(starta, secondList[b][0]), minOf(enda, secondList[b][1])))
                }
            }
        }
        return sum.toTypedArray()
    }
}

class Solution34g {
    fun intervalIntersection(
        firstList: Array<IntArray>,
        secondList: Array<IntArray>
    ): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        var i = 0
        var j = 0

        while (i < firstList.size && j < secondList.size) {
            val start = maxOf(firstList[i][0], secondList[j][0])
            val end = minOf(firstList[i][1], secondList[j][1])

            if (start <= end) {
                result.add(intArrayOf(start, end))
            }
            if(firstList[i][1]<=secondList[j][1]) {
                i++
            }else j++

        }

        return result.toTypedArray()
    }
}
