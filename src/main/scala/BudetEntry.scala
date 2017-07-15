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
class Transaction(val amount: Double, val description: String, val date: java.time.LocalDateTime) {
  override def toString: String = "Amount: " + amount + " Description: \"" + description + "\" Date: \"" + date.toString + "\""
}

class BudgetLine(val name: String, val budgetedAmount: Double, val transactions: List[Transaction]) {
  def currentAmount : Double = {
    var sum = 0.0
    for (entry <- transactions) sum += entry.amount
    sum
  }

  def addTransaction(transaction: Transaction) : BudgetLine =
    new BudgetLine(name, budgetedAmount, transaction :: transactions)

  def printTransactions : String = transactions.mkString("\n")

  override def toString: String = "Category: " + name + ". Budgeted: " + budgetedAmount + ", Spent: " + currentAmount
}
class Budget(val name: String, val budgetLines: List[BudgetLine]) {

  def addBudgetLine(budgetLine: BudgetLine) : Budget = new Budget(name, budgetLine :: budgetLines)

  def printBudget : String = budgetLines.mkString("\n")
}

object Main extends App {
  val a = new Transaction(50, "memes", java.time.LocalDateTime.now())
  val b = new Transaction(25, "memes", java.time.LocalDateTime.now())
  val c = new Transaction(30, "memes", java.time.LocalDateTime.now())

  val budgetLine = new BudgetLine("memes", 200, List(a,b))
  println(budgetLine)

  println(budgetLine.printTransactions)

  val budgetAdd = budgetLine.addTransaction(c)
  println(budgetAdd)
  println(budgetAdd.printTransactions)


}