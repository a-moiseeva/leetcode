package `2_base`

fun main(){
    val n = readln().toInt()
    val m = mutableMapOf<String, Pair<Int,String>>()
    var pairs=0
    repeat(n){
        val word = readln().trim()
        val s =word.length
        for (i in 0 until s){
            val newword = word.substring(0, i)+"*"+word.substring(i+1, s)
            if (m.containsKey(newword)){
                val (inn,str)= m[newword]!!
                if(!str.contains(word[i])){
                    pairs=pairs + inn
                    m[newword] = Pair(inn+1, str+word[i])
                }
            }
            else{
                m[newword] = Pair(1,word[i].toString())
            }
        }
    }
    println(pairs)
}