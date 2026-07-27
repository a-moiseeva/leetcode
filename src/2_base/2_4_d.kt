package `2_base`


fun main() {
    val n = readln().toInt()

    var line = readln()
    var line_length = line.length
    var start = 0
    var end = line.length - 1
    var printed=0
    while (printed!=line_length){
        val a = find_first_min(line)
        println(a.first)
        printed=printed+a.first.length
        if(a.second){
            line=line.substring(a.first.length,line.length)
        }else {
            line=line.substring(0,line.length-a.first.length)
        }
    }



}


fun find_first_min(line: String): Pair<String, Boolean>{
    val s = line.length
    if (s == 1) {
        return Pair(line[0].toString(), true)
    }
    if (line[0] < line[s - 1]) {
        return Pair(line[0].toString(), true)
    }
    if (line[0] > line[s - 1]) {
        return Pair(line[s - 1].toString(), false)
    }

    if (s == 2) {
        return Pair(line[0].toString(), true)
    }
    var (subline, b) = find_first_min(line.substring(1, line.length - 1))
    if (b) {
        return Pair(line[0] + subline, true)
    }
    return Pair(line[s - 1] + subline, false)

}