package livecoding1

class Solution7(){
    fun oneEditDistance(s:String,t:String): Boolean {
        var modify=0
        val sl=s.length
        val tl=t.length
        var i = 0
        var j=0

        while(i<sl){
            if (s[i]==t[j]){
                i++
                j++
            }
            else{
                if(modify!=0) return false
                modify++
                if(sl==tl){
                    i++
                    j++
                }
                if (sl>tl){
                    i++
                }
                if (tl>sl){
                    j++
                }
            }
        }
        if(j!=tl) return false
        if(modify!=1) return false
        return true
    }

}
fun main(){
    println(Solution7().oneEditDistance("ab","acb"))
    println(Solution7().oneEditDistance("ab","ab"))
}