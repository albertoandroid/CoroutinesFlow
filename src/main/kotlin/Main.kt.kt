import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>){
    /*
    //show()
    runBlocking {
        runAsynchronous().forEach{i-> println(i)}
    }

     */
    runBlocking {
        launch {
            for(j in 1..3){
                println("No estoy bloqueado $j")
                kotlinx.coroutines.delay(1000)
            }
        }
        firstFlow().collect{value->println(value)}
    }
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

suspend fun runAsynchronous(): List<Int>{
    return runBlocking {
        kotlinx.coroutines.delay(1000)
        return@runBlocking listOf(1,2,3)
    }
}

fun firstFlow(): Flow<Int> = flow{
    for(i in 1..3){
        kotlinx.coroutines.delay(1000)
        emit(i)
    }
}