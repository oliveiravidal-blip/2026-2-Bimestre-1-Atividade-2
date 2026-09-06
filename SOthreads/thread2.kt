import kotlinx.coroutines.*

fun saudar(nome: String, vezes: Int) {
    for (i in 0 until vezes) {
        println("Olá, $nome! (mensagem ${i + 1})")
    }
}

fun main() = runBlocking {
    val nome = "Mundo"
    val vezes = 5

    val meuJob = launch {
        saudar(nome, vezes)
    }

    meuJob.join()
    println("Programa principal finalizado!")
}