package `2_base`

fun main(){
    val n = readln().toInt()
    val m = mutableMapOf<Drob, Int>()
    var win_numb=0
    var win= Drob(0,0)
    var win_znach =0f
    repeat(n){
        val (a,b)= readln().split(" ").map{it-> it.toInt()}
        val dd: Drob= sokratit(a,b)
        val d= m.getOrDefault(dd,0)+1
        m[dd]=d
        val my_znach =a.toFloat()/b.toFloat()
        if((d>win_numb) or ((d==win_numb) && (win_znach>my_znach))){
            win=dd
            win_numb=d
            win_znach=my_znach
        }
    }
    println("${win.a} ${win.b}")

}

data class Drob(val a: Int, val b: Int){
}

fun sokratit(a: Int, b: Int): Drob {
    val c = nod(a,b)
    return Drob(a/c, b/c)
}

fun nod(a: Int, b: Int): Int{
    if (a%b==0){
        return b
    }
    return nod(b, a%b)

}