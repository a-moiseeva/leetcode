package livecoding1

import kotlin.random.Random
class RandomizedSet() {
    var hm = HashMap<Int,Int>()
    var l = mutableListOf<Int>()


    fun insert(`val`: Int): Boolean {
        if (hm.contains(`val`)) return false
        hm[`val`]=l.size
        l.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        val key = hm[`val`] ?: return false
        val lastV = l.last()
        l[key]=lastV
        hm[lastV]=key
        l.removeAt(l.size-1)
        hm.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        val ind = Random.nextInt(l.size) ?: 0
        return l[ind]
    }

}
fun main(){
    val r = RandomizedSet()/*
    r.insert(0)
    r.insert(1)
    r.remove(0)
    r.insert(2)
    r.remove(1)*/

    r.remove(0)
    r.remove(0)
    r.insert(0)
    println(r.getRandom())
    r.remove(0)
    println(r.insert(0))
}