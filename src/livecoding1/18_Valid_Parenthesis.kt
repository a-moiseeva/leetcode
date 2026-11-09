package livecoding1

import java.util.ArrayDeque
class Solution18 {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        var count=0
        for(c in s){
            if((c=='(')||(c=='[')||(c=='{')){
                stack.addLast(c)
                count++
            }else{
                if(stack.isEmpty()) return false
                if(c==')'){
                    if (stack.last()!='(') return false
                    stack.removeLast()
                    count--
                }
                if(c==']'){
                    if (stack.last()!='[') return false
                    stack.removeLast()
                    count--
                }
                if(c=='}'){
                    if (stack.last()!='{') return false
                    stack.removeLast()
                    count--
                }
            }
        }
        if (count!=0) return false
        return true
    }
}
