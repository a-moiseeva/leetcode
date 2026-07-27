package `2_base`


fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val stack = mutableListOf<Int>()
    stack.add(0)
    var result =0

    for (i in 1 until n) {
        var k = i
        while (k>0&&a[k-1]<a[i]){
            k--
            if (stack[k]==0&&k>0&&a[k-1]>=a[i]) {break}
            k=k-stack[k]
        }
        stack.add(i-k)
    //    println(stack)
    }

    println( stack.joinToString(" "))
}
