package livecoding1

class Solution13 {
    fun generateParenthesis(n: Int): List<String> {
        val answer = mutableListOf<String>()



        fun generate(rightUsed: Int, leftUsed: Int, s: String){
            if(rightUsed+leftUsed==2*n){
                answer.add(s)
                return
            } else{
                if(rightUsed<n){
                    generate(rightUsed+1, leftUsed,s+"(" )
                }
                if(rightUsed>leftUsed){
                    generate(rightUsed,leftUsed+1,s+")")
                }
            }
        }
        generate(0,0,"")
        return answer

    }
}