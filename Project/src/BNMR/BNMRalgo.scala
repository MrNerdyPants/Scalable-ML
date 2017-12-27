package BNMR

object BNMRalgo {
  def BlindNakedMoleRatAlgorithm(){
    var data=BNMR.bnmr.getData()
    var FV=List[Double]()
    var Population = List[(Int,Double)]()
    Population=BNMR.bnmr.populationInitialization(data._1,data._2,data._3,data._4)
    FV=BNMR.bnmr.FitnessCalculation(Population,data._2)
    var s=FV.foldLeft(0.0)(_ + _)
    var pc=BNMR.bnmr.probabilityCalculation(FV,s)
    var pop=Population.grouped(data._2).toList
    println(pop +"\n")
   var popWithProbability=pop.map(x=>(pc(pop.indexOf(x)),x))
   println(popWithProbability +"\n")
   var sortedPopulation=popWithProbability.sortBy(_._1).map(_._2).reverse
   println(sortedPopulation +"\n")
   val m = new MoleRat(sortedPopulation.head,data._3,data._4,data._2)
	val r=m.localMove(sortedPopulation.head)
	println(r)
  }
}