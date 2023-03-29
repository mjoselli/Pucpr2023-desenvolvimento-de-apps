/* 1. Crie uma função que receba um número inteiro e retorne verdadeiro se o número for par e falso caso contrário. */

fun ehPar(num: Int): Boolean {
	return num % 2 == 0
}

/* 2. Crie uma função que receba um array de inteiros e retorne o maior número. */

fun maiorNumero(arr: Array<Int>): Int {
	var maior = arr[0]
	for (num in arr) {
		if (num > maior) {
			maior = num
		}
	}
	return maior
}

/* 3. Crie uma classe chamada "Pessoa" com os atributos "nome" e "idade". Em seguida, crie uma lista de objetos "Pessoa" e ordene a lista em ordem alfabética pelo atributo "nome". */

class Pessoa(val nome: String, val idade: Int)

fun teste3() {
	val pessoas = listOf(
		Pessoa("João", 25),
		Pessoa("Ana", 30),
		Pessoa("Maria", 20)
	)

	val pessoasOrdenadas = pessoas.sortedBy { it.nome }
	for (pessoa in pessoasOrdenadas) {
    println("${pessoa.nome} - ${pessoa.idade}")
	}


}

/* 4. Crie uma função que receba uma string e retorne verdadeiro se a string for um palíndromo (ou seja, pode ser lida da mesma forma de trás para frente). */

fun ehPalindromo(str: String): Boolean {
	val strInvertida = str.reversed()
	return str == strInvertida
}

/* 5. Crie uma classe "ContaBancaria" com os atributos "saldo" e "limite". Adicione um método chamado "saque" que recebe um valor como parâmetro e subtrai do saldo da conta. Se o valor do saque for maior que o saldo da conta, o método deve lançar uma exceção com a mensagem "Saldo insuficiente". */

class ContaBancaria(var saldo: Double, val limite: Double) {

	fun saque(valor: Double) {
    	if (valor > saldo + limite) {
        	throw Exception("Saldo insuficiente")
    	}
    	saldo -= valor
	}


}

/* 6. Crie uma função que receba uma lista de strings e retorne a string mais longa da lista. */

fun stringMaisLonga(lista: List<String>): String {
	var maisLonga = lista[0]
	for (str in lista) {
		if (str.length > maisLonga.length) {
			maisLonga = str
		}
	}
	return maisLonga
}

/* 7. Crie uma classe "Funcionario" com os atributos "nome", "idade" e "salario". Crie uma função que receba uma lista de funcionários e retorne o funcionário com o maior salário. */

class Funcionario(val nome: String, val idade: Int, val salario: Double)

fun funcionarioMaiorSalario(lista: List<Funcionario>): Funcionario {
	var maiorSalario = lista[0]
	for (funcionario in lista) {
		if (funcionario.salario > maiorSalario.salario) {
			maiorSalario = funcionario
		}
	}
	return maiorSalario
}


// 8. Crie uma função que receba uma lista de números inteiros e retorne uma lista com os números em ordem crescente, sem usar o método de ordenação da linguagem.

fun ordenarNumeros(lista: List<Int>): List<Int> {
	val tamanho = lista.size
	var numeros = lista.toMutableList()

    for (i in 0 until tamanho - 1) {
        for (j in i + 1 until tamanho) {
            if (numeros[i] > numeros[j]) {
                val temp = numeros[i]
                numeros[i] = numeros[j]
                numeros[j] = temp
            }
        }
    }

	return numeros
}

// 9. Crie uma classe "Triangulo" com os atributos "base" e "altura". Adicione um método chamado "area" que calcula e retorna a área do triângulo.

class Triangulo(val base: Double, val altura: Double) {
	fun area(): Double {
		return base * altura / 2
	}
}

// 10. Crie uma função que receba uma lista de strings e retorne uma lista com todas as strings que começam com a letra "A", em ordem alfabética.

fun filtrarStrings(lista: List<String>): List<String> {
	return lista.filter { it.startsWith("A") }.sorted()
}

fun main() {
	// Testando a função ehPar
	println("O número 4 é par? ${ehPar(4)}") // true
	println("O número 7 é par? ${ehPar(7)}") // false
    // Testando a função maiorNumero
    val numeros = arrayOf(5, 10, 2, 8, 1)
    println("O maior número é ${maiorNumero(numeros)}") // 10

    // Testando a classe Pessoa
    teste3()

    // Testando a função ehPalindromo
    println("A palavra 'arara' é palíndromo? ${ehPalindromo("arara")}") // true
    println("A palavra 'casa' é palíndromo? ${ehPalindromo("casa")}") // false

    // Testando a classe ContaBancaria
    val minhaConta = ContaBancaria(1000.0, 500.0)
    minhaConta.saque(200.0)
    println("Saldo atual: R$ ${minhaConta.saldo}") // 800.0
    try {
        minhaConta.saque(1000.0)
    } catch (e: Exception) {
        println(e.message) // Saldo insuficiente
    }

    // Testando a função stringMaisLonga
    val palavras = listOf("casa", "carro", "bicicleta", "computador")
    println("A palavra mais longa é '${stringMaisLonga(palavras)}'") // bicicleta


    // Teste da função funcionarioMaiorSalario
    val listaFuncionarios = listOf(
        Funcionario("João", 25, 2500.0),
        Funcionario("Maria", 30, 3500.0),
        Funcionario("Pedro", 40, 4000.0),
        Funcionario("Lucas", 22, 2000.0)
    )

    val funcionarioMaiorSalario = funcionarioMaiorSalario(listaFuncionarios)
    println("Funcionário com maior salário: ${funcionarioMaiorSalario.nome}")

    // Teste da função ordenarNumeros
    val listaNumeros = listOf(10, 5, 3, 8, 2, 7)
    val numerosOrdenados = ordenarNumeros(listaNumeros)
    println("Lista de números ordenados: $numerosOrdenados")

    // Teste da classe Triangulo
    val triangulo = Triangulo(10.0, 5.0)
    val areaTriangulo = triangulo.area()
    println("Área do triângulo: $areaTriangulo")

    // Teste da função filtrarStrings
    val listaStrings = listOf("Ana", "José", "Antônio", "Abigail", "Lucas", "André")
    val stringsFiltradas = filtrarStrings(listaStrings)
    println("Lista de strings filtradas: $stringsFiltradas")
}

    
