enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String,val login: String, val password: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivelCurso: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun getInscritosList() : List<Usuario> {
        return inscritos
    }
    
}

fun main() {
    
    val usuario1 = Usuario("Alexandre", "iasato@outlook.com", "senha123")
    val usuario2 = Usuario("Sato", "iasato@email.com", "senha123")
    
    val conteudo_kotlin = ConteudoEducacional("Kotlin Experience", 60, Nivel.INTERMEDIARIO)
    val conteudo_flutter = ConteudoEducacional("Flutter Expert", 80, Nivel.AVANCADO)
    val conteudo_swift = ConteudoEducacional("Swift Fundamentals", 30, Nivel.INICIANTE)
    
    val formacao_android = Formacao("Android Developer", listOf(conteudo_kotlin, conteudo_flutter))
    val formacao_ios = Formacao("iOS Developer", listOf(conteudo_swift, conteudo_flutter))
        
    formacao_android.matricular(usuario1);
    formacao_android.matricular(usuario2);
    
	println("Usuários inscritos: ${formacao_android.getInscritosList()}:")
    
}