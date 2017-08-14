package objsets


object MainSubtyping extends App {


  def convertToFord[A>:Ford](a: A) = new Ford("converted to Ford" + a)
  def createFord[A<:Ford](a: A) = new Ford("createdFord" + a.name)

  def carConverted = convertToFord(new Toros("toros"))
  def carCreated = createFord(new Fiesta("fiesta"))

  val a: Array[Ford] =  Array[Ford] (carConverted, carCreated, new Ford("myFord"), new Fiesta("myFiesta"))

  a.foreach(a => println(a.name))

}



class Car (val name:String )
class Ford (name:String)  extends  Car(name: String)
class Mercedes (name:String) extends  Car(name:String)
class Toros (name:String)
class Fiesta (name:String) extends Ford(name:String)
