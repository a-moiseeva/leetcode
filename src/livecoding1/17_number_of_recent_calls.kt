    package livecoding1

import java.util.ArrayDeque
class RecentCounter(){
    val requests = ArrayDeque<Int>()

    fun ping(t: Int):Int{
        requests.addLast(t)
        while (requests.first()<t-3000){
            requests.removeFirst()
        }
        return requests.size
    }
}




