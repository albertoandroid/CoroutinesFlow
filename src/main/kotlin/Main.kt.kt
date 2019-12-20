
fun main(args: Array<String>){
    show()
}

fun show(){
    //listar().forEach{i->println(i)}
    secuencia().forEach { i->println(i) }
}

fun listar(): List<Int> = listOf(3,78,90)

fun secuencia(): Sequence<Int> = sequence {
    for(i in 1..3){
        Thread.sleep(1000)
        yield(i)
    }
}