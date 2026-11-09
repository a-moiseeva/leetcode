package livecoding2

import java.util.PriorityQueue
class Solution25(){
    fun meetingRooms(intervals:Array<IntArray>):Int{
        if(intervals.size<2) return intervals.size
        val rooms= PriorityQueue<Int>{a,b -> a.compareTo(b)}
        val times= intervals.sortedBy{it[0]}
        rooms.offer(times[0][1])
        for(i in 1..intervals.size-1){
            if(rooms.isNotEmpty()&&rooms.peek()<=times[i][0]){
                rooms.poll()
            }
            rooms.offer(times[i][1])
        }
        return rooms.size
    }
}

