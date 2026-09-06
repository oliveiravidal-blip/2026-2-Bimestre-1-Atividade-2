import kotlin.concurrent.thread

fun minhaFuncao() {
    println("Thread iniciada!")
   
    Thread.sleep(2000)
    println("Thread finalizada!")
}

fun main() {
    
    val minhaThread = thread(start = false) {
        minhaFuncao()
    }

   
    minhaThread.start()

    
    minhaThread.join()
    println("Programa principal finalizado!")
}