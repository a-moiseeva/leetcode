package live_coding

fun main() {
    val points = mutableListOf<Pair<Int, Int>>(Pair(1, 1),Pair(1, 1), Pair(-1,1), Pair(-1,1), Pair(0,0))
    val points_map = mutableMapOf<Pair<Int, Int>, Int>()
    var max = points[0].first
    var min = max
    for (point in points) {
        if (point.first > max) max = point.first
        if (point.first < min) min = point.first
        points_map[point] = (points_map[point] ?: 0) + 1
    }
    val the_line = (max + min) / 2
    println(the_line)
    for (point in points_map) {
        var need_to_find = the_line
        if (point.key.first < the_line) need_to_find = the_line + the_line - point.key.first
        if (point.key.first > the_line) need_to_find = the_line + the_line - point.key.first
        if (!points_map.contains(Pair(need_to_find, point.key.second))) println("false").also{ return}
        if (points_map[point.key] != points_map[Pair(need_to_find, point.key.second)]) println("false").also{ return}

    }
    println("true")

}