package Classes

abstract class People
{
    abstract val Age:Int
    abstract val  Name:String
    abstract val Job:String
    abstract val Sex:Boolean
    abstract fun goToJob()
}

class Joe(
    override val Age: Int,
    override val Name: String,
    override val Job: String,
    override val Sex: Boolean = false

): People()
{

    override fun goToJob() {
        println("${Age},$Name,$Job,$Sex")
    }
}

class Klara(
    override val Age: Int,
    override val Name: String,
    override val Job: String,
    override val Sex: Boolean,
): People()
{
    override fun goToJob(){
        println("Go to gym")
    }
}