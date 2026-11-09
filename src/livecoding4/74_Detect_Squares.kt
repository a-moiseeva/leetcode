package livecoding4

class DetectSquares() {
    //x, y, freq
    val dots = HashMap<Int, HashMap<Int,Int>>()


    fun add(point: IntArray) {
        val x = point[0]
        val y = point[1]

        if(!dots.containsKey(x)){
            dots[x]=hashMapOf()
        }
        dots[x]!![y]= (dots[x]!![y] ?: 0)+1
    }

    fun count(point: IntArray): Int {
        var sum = 0
        val x1= point[0]
        val y1= point[1]
        if(dots.containsKey(x1)) {
            for (i in dots[x1]!!){
                val y2 = i.key
                if(y1==y2) continue
                val a = Math.abs(y2-y1)
                val count1= i.value
                //квадрат справа
                val x3=x1+a
                if(dots.containsKey(x3)) {
                    if(dots[x3]!!.containsKey(y2) && dots[x3]!!.containsKey(y1)){
                        sum=sum+count1*dots[x3]!![y2]!!*dots[x3]!![y1]!!
                    }
                }
                val x4=x1-a
                if(dots.containsKey(x4)) {
                    if(dots[x4]!!.containsKey(y2) && dots[x4]!!.containsKey(y1)){
                        sum=sum+count1*dots[x4]!![y2]!!*dots[x4]!![y1]!!
                    }
                }
            }
        }

        return sum

    }

}