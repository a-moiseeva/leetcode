


interface Swimmer {
    fun swimmer()
}

class MyCat (val name: String, val age: Int, val isCute: Boolean): Swimmer {
    fun purr(){
        println("I am purr")
    }

    override fun swimmer() {
        println("I am swimmer")
    }
}


data class Cat(val name:String, val age:Int): Swimmer{
    override fun swimmer() {
        println("I am swimmer")
    }

    fun printMe(){
        println("My name is $name")
        println("My age is $age")
    }

    override fun hashCode(): Int {
        val a= super.hashCode()
        return a+10
    }


}
fun main(){
    val Mishka = Cat("Mishka", 23)
    val Murka = Mishka.copy()
    println(Murka.toString())

    val a = hashMapOf<Int,Int>(10 to 2, 3 to 4, 5 to 6)
    for (i in a){
        println(i)
    }

}