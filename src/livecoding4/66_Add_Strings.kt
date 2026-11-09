package livecoding4

class Solution66 {
    fun addStrings(num1: String, num2: String): String {
        var i = num1.length-1
        var j = num2.length-1
        var dop=0
        var answ = StringBuilder()
        while (i>=0 ||j>=0|| dop!=0){
            var cur = dop
            if(i>=0) cur=cur+num1[i].code-'0'.code
            if(j>=0) cur=cur+num2[j].code-'0'.code
            i--
            j--
            val tt=cur%10
            answ.append(tt)
            dop=cur/10
        }
        return answ.reverse().toString()
    }
}