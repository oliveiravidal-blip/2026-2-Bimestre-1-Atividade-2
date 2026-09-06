import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


suspend fun trabalhador(numero: Int, tempoTrabalho: Long) {
    println("Trabalhador $numero começou")
    
    
    delay(tempoTrabalho * 1000) 
    
    println("Trabalhador $numero terminou (levou ${tempoTrabalho}s)")
}

fun main() = runBlocking {
    println("Iniciando 5 trabalhadores...")
    
    
    val tempoTotalMs = measureTimeMillis {
        
        
        val jobs = List(5) { i -> 
            launch {
                trabalhador(i, 2)
            }
        }
        
        
        jobs.joinAll() 
    }
    
    
    val tempoTotalS = tempoTotalMs / 1000.0
    
    println("\nTodos os trabalhadores terminaram!")
    
    
    println("Tempo total: %.2fs".format(tempoTotalS))
    println("(Se fosse sequencial, levaria ~10s)")
}