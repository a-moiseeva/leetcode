package `2_base`

fun main(){
    val a = readln().split(" ")
    val lie = readln().split(" ").map { it.toInt() }
    val line = ArrayDeque<Int>()
    for(i in lie){
        line.add(i)
    }

    repeat(line.size-3){
        var war_main= line.first()

        var left = line.last()
        var right = line[1]
        if (war_main<left&& war_main<right){
            line.removeFirst()
            if(left>right){
                line.removeLast()
                line.addFirst(left)
            }
        }else if(left<war_main&& left<right){
            line.removeLast()
            if(right>war_main){
                line.removeFirst()
                line.addLast(war_main)
            }
        }else if(right<war_main && right<left){
            line.removeFirst()
            line.removeFirst()
            line.addFirst(war_main)
            if(left>war_main){
                line.removeLast()
                line.addFirst(left)
            }
        }
       // println(line)

    }
    val minim= line.min()
    val answ=line.filter { it != minim }
    println(answ.joinToString(" "))


}