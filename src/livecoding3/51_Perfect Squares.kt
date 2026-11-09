package livecoding3

import kotlin.math.sqrt
class Solution51 {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n+1){n+1}
        dp[0]=0
        for(i in 1..n){
            var square = 1
            while(square*square <= i){
                dp[i]=minOf(dp[i], dp[i-square*square]+1)
                square++
            }
        }
        println(dp.joinToString(" "))
        return dp[n]
    }
}



class Solution51l {
    fun numSquares(n: Int): Int {
        var num = n

        // 1. Check if it's a perfect square itself -> Answer is 1
        if (isSquare(num)) return 1

        // 2. Shrink the number by removing factors of 4 (Legendre's Theorem preparation)
        while (num % 4 == 0) {
            num /= 4
        }

        // 3. If the remaining number is of the form 8b + 7 -> Answer is 4
        if (num % 8 == 7) return 4

        // 4. Check if it can be split into 2 perfect squares -> Answer is 2
        // We only need to check up to the square root of the original n
        val limit = sqrt(n.toDouble()).toInt()
        for (i in 1..limit) {
            val remaining = n - (i * i)
            if (isSquare(remaining)) return 2
        }

        // 5. If it's not 1, 2, or 4, by elimination it MUST be 3
        return 3
    }

    private fun isSquare(x: Int): Boolean {
        val s = sqrt(x.toDouble()).toInt()
        return s * s == x
    }
}