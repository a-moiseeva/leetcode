package livecoding4

import jdk.internal.org.jline.utils.Colors.s

/*

Дана строка S, необходимо посчитать количество подстрок
в этой строке, которые содержат все символы из этой
строки хотя бы по одному разу.*/

fun countSubstrings(s: String): Int{
    val mm = mutableSetOf<Char>()
    for(i in s) mm.add(i)
    val n = mm.size
    val hm = mutableMapOf<Char,Int>()
    var sum =0
    var left = 0
    println(n)
    for(right in 0..s.length-1){
        val letter = s[right]
        hm[letter]= hm.getOrDefault(letter,0)+1
        while(hm.size==n){
            val l = s[left]
            if(hm[l]==1){/*
                println("hi! $left $right")*/
                sum=sum+(left+1)
                break
            }
            hm[l] = hm.getOrDefault(l,0)-1
            left++
        }/*
        print(letter)
        print(hm)
        println(left)*/
    }

    return sum
}
fun main(){
    println(countSubstrings("abcabb"))
}