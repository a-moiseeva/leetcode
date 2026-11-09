package livecoding2
import java.util.ArrayDeque
class HitCounter(){
    val deque = ArrayList<Int>()
    fun hit(time: Int){
        deque.add(time)
    }
    fun getHits(time:Int): Int{
        var numb = search(time-300+1)
        return deque.size-numb
    }
    fun search(time:Int): Int {
        var left=0
        var right=deque.size
        var mid=0
        while(left<right){
            mid = (left+right)/2
            if(time<deque[mid]){
                right=mid
            }
            else left=mid+1
        }
        return mid
    }


}
fun main(){
    val hitCounter = HitCounter();
    hitCounter.hit(1);       // hit at timestamp 1.
    hitCounter.hit(2);       // hit at timestamp 2.
    hitCounter.hit(3);       // hit at timestamp 3.
    println(hitCounter.getHits(4));   // get hits at timestamp 4, return 3.
    hitCounter.hit(300);     // hit at timestamp 300.
    println(hitCounter.getHits(300)); // get hits at timestamp 300, return 4.
    println(hitCounter.getHits(301)); // get hits at timestamp 301, return 3.
}