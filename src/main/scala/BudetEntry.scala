/**
  * Created by ForestOden on 7/11/2017.
  */
/*
object Main extends App {
  case class Transaction(amount: Double, )
  case class BudgetEntry(transactions: Iterable[Transaction], budgetAmount: Double)

  def addNewTransaction(startingBudget: Double, t: Transaction) = startingBudget + t.amount
  def budgetBalance(budget: BudgetEntry) = budget.transactions.foldLeft(0.0)(addNewTransaction)

  val b = BudgetEntry(Iterable(Transaction(1), Transaction(1.5)), 5)
  val newBalance = budgetBalance(b)

  println(b)
  println(newBalance)

}
*/
class BudgetEntry(val amount: Double, val description: String , val date: java.time.LocalDateTime) {
  override def toString: String = "Amount: " + amount + " Description: \"" + description + "\" Date: \"" + date.toString + "\""
}

class BudgetLine(name: String, budgetedAmount: Double, transactions: List[BudgetEntry]) {
  def currentAmount : Double = {
    var sum = 0.0
    for (entry <- transactions) sum += entry.amount
    sum
  }

  def printTransactions = transactions.mkString("\n")

  override def toString: String = "Budgeted: " + budgetedAmount + ", Spent: " + currentAmount
}

object Main extends App {
  val a = new BudgetEntry(50, "memes", java.time.LocalDateTime.now())
  val b = new BudgetEntry(25, "memes", java.time.LocalDateTime.now())
  val c = new BudgetEntry(30, "memes", java.time.LocalDateTime.now())

  val budget = new BudgetLine("memes", 200, List(a,b,c))
  println(budget)

  println(budget.printTransactions)


}