//comentario 
/*hghghj
   */
fun main() {
    println("Hello, world!!!")
    val myVal = 3
    var myVar = 4
    myVar = 6
    var myInt:Int = 5
    //var myUn:Int
    val texto = "minha \nstring"
    val textoLongo = """
    sdfsdf
    fsdfsdf
    """
    println(textoLongo)
    println("${texto.length} = $myInt")
    var textoNullable:String? = "abc"
    println(textoNullable?.length)
    
    println(textoNullable?.length ?: 0)
    
    textoNullable = null
    println(textoNullable?.length)
    println(textoNullable?.length ?: 0)
    fun hello(name:String ="world") :String{
        return "Hello $name"
    }
    println(hello("mark"))
    println(hello(name="mark"))
    println(hello())
	fun ola(name:String):String = "Ola $name"
    println(ola("teste"))
    fun varArgFun(vararg nums:Int){
        println("tamanho:${nums.size}")
    }
    varArgFun()
    varArgFun(1,2,3)
    varArgFun(1,2,3,4,55)
    fun not(f: (Int) -> Boolean):(Int)->Boolean{
        return {n -> !f.invoke(n)}
    }
    fun even(x:Int) = x%2 ==0
    val odd = not(::even)
    val notZero = not{n -> n == 0}
    val notPositive = not{it > 0}
    for(i in 0..4){
       	println("$i ${odd(i)} ${notZero(i)} ${notPositive(i)}") 
    }
    data class MinhaClasse(var x:Int,var y:Int)
    var mCl = MinhaClasse(4,3)
    println(mCl)
    var copyMCL = mCl.copy(y=5)
    val (x,y) = copyMCL
    println("$x $y")
    for(i in listOf(mCl)){
        println("$i")
    }
    data class MinhaClasse2(var x:Int,var y:Int,var z:Int)
	val mCl2 = MinhaClasse2(3,3,3)
    /*with (mCl2){
        x -= 3
        y += 66
        z++
    }*/
    println(mCl2)
    class Classe(var x:Int){
        fun somar(y:Int):Int{
            return x+y
        }
        infix fun teste(y:Int):String{
            return "teste $y"
        }
    }
    val c = Classe(3)
    print(c.somar(5))
    println(c teste 3)
    val myList = listOf(1,2,3,4)
    myList.first()
    myList[0]
    val myMutaList = mutableListOf(1,2,3,4)
    val map = mapOf("a" to 1,"b" to 3)
    for((key,value) in map){
        println("$key $value")
        
    }
    val z = (1..9).map{it * 3}
    				.filter {it < 20}
                    .groupBy {it % 2 == 0}
                    .mapKeys {if(it.key) "even" else "odd"}
    print(z)
    var e = 3
    val result = when (e){
        0,7 -> "0 ou 7"
        in 1..6 -> "entre 1 e 6"
        else -> ""
    }
    fun isTeste(x:Any) = when(x){
        is String -> "String"
        is Boolean -> "Bool"
        else -> "nenhum"
    }
    object Obj{
        fun hello(){
            println("hello")
        }
    }
    fun useSingleton(){
        Obj.hello()
    }
    useSingleton()
    
}