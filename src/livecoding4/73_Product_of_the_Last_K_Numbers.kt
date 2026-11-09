package livecoding4

class ProductOfNumbers() {
    var xPrefix = mutableListOf(1)

    fun add(num: Int) {
        if(num==0){
            xPrefix  = mutableListOf(1)
        }
        else xPrefix.add(num*(xPrefix[xPrefix.size-1]))
    }

    fun getProduct(k: Int): Int {
        if(xPrefix.size-k<1) return 0
        return (xPrefix[xPrefix.size-1]/xPrefix[xPrefix.size-k-1])
    }

}