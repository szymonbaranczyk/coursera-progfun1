package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = (c,r) match {
      case (0,0) => 1
      case (c1,r1) if c1==0 => pascal(0,r1-1)
      case (c1,r1) if c1==r1 => pascal(r1-1,r1-1)
      case (c1,r1) => pascal(c1-1,r1-1) + pascal(c1,r1-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def help(chars: List[Char],opened: Int):Boolean = {
        (chars,opened) match {
          case (ch,o) if o < 0 => false
          case (ch,o) if ch.isEmpty => opened==0
          case (ch,o) => help(
            ch.tail,
            opened + (ch.head match {
              case ')' => -1
              case '(' => 1
              case _ => 0
            })
          )
        }
      }
      help(chars,0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if(money < 0 || coins.isEmpty) 0
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)

    }
  }
