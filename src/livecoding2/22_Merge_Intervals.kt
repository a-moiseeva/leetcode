package livecoding2
class Solution22 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size<=1) return intervals
        val newIntervals =intervals.sortedBy{it[0]}
        val answer = mutableListOf<IntArray>()
        answer.add(newIntervals[0])
        for (i in 1..newIntervals.size-1){
            if(answer[answer.size-1][1]>=newIntervals[i][0]){
                answer[answer.size-1][1]=maxOf(answer[answer.size-1][1],newIntervals[i][1])
            }else{
                answer.add(newIntervals[i])
            }
        }
        return answer.toTypedArray()


    }
}

class Solution322 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val newIntervals = intervals.sortedBy{it[0]}
        val answer = mutableListOf<IntArray>()
        answer.add(intervals[0])
        for(i in 1..newIntervals.size-1){
            if(answer[answer.size-1][1]>=newIntervals[i][0]){
                answer[answer.size-1][1]=maxOf(newIntervals[i][1],answer[answer.size-1][1])
            }
            else answer.add(newIntervals[i])
        }
        return answer.toTypedArray()
    }
}