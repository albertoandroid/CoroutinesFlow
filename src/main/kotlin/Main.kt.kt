import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.system.measureTimeMillis

fun main(args: Array<String>){
    /*
    //show()
    runBlocking {
        runAsynchronous().forEach{i-> println(i)}
    }


    runBlocking {
        launch {
            for(j in 1..3){
                println("No estoy bloqueado $j")
                kotlinx.coroutines.delay(1000)
            }
        }
        firstFlow().collect{value->println(value)}
    }


    runBlocking {
        println("Llamando Flow...")
        var flow = firstFlow();
        println("Collect...")
        flow.collect{value->println(value)}
        println("Collect again...")
        flow.collect{value->println(value)}
    }

    runBlocking {
        withTimeoutOrNull(2500){
            firstFlow().collect{value->println(value)}
        }
        println("Finalizado")
    }

    runBlocking {
        //secondFlow().collect{value->println(value)}
        thirdFlow().collect{value->println(value)}
    }

     */

    /*
    runBlocking {
        (1..3).asFlow()
            .map{request->performRequest(request)}
            .collect{response-> println(response)}
    }



    runBlocking {
        (1..3).asFlow()
            .filter{request->request>1}
            .map{request->performRequest(request)}
            .collect{response->println(response)}
    }



    runBlocking {
        (1..3).asFlow()
            .transform{
                request->
                    emit("Making request $request")
                    emit(performRequest(request))
            }
            .collect{
                response->println(response)
            }

    }

    runBlocking {
        (1..3).asFlow()
            .take(2)
            .collect{response->println(response)}
    }



    runBlocking {
        var lista: List<Int> = (1..3).asFlow().toList()
        println(lista)
    }



    runBlocking {
        var numero = (6..90).asFlow()
            .first()
        println(numero)
    }



    runBlocking {
        var resultado = (1..5).asFlow()
            .reduce{a,b->a+b}
        println(resultado)
    }



    runBlocking {
        (1..5).asFlow()
            .filter{
                i->
                println("Filtrado $i")
                i%2==0
            }
            .map{
                i->
                println("Map $i")
                "String $i"
            }
            .collect{
                i->
                println("Collect $i")
            }
    }


    runBlocking {
        val time = measureTimeMillis {
            firstFlow()
                .buffer()
                .collect{
                value ->
                kotlinx.coroutines.delay(300)
                println(value)
            }
        }
        println("$time ms")
    }


    runBlocking {
        val time = measureTimeMillis {
            firstFlow()
                .conflate()
                .collect{
                        value ->
                    kotlinx.coroutines.delay(300)
                    println(value)
                }
        }
        println("$time ms")
    }
    */


    runBlocking {
        val time = measureTimeMillis {
            firstFlow()
                .collectLatest{
                        value ->
                    println("Collecting $value")
                    kotlinx.coroutines.delay(300)
                    println("Finalizado $value")
                }
        }
        println("$time ms")
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
        kotlinx.coroutines.delay(100)
        emit(i)
    }
}

fun secondFlow(): Flow<Int> {
    return flowOf(1,2,3)
}

fun thirdFlow(): Flow<Int>{
    return (1..3).asFlow()
}

suspend fun performRequest(request: Int): String{
    delay(1000)
    return "response $request"
}