package example

class Example extends Super {

  def adults(list: List[Int]) = {
    val foobar = list
    foobar.map(_.toString).filter(_.length >= 2)
  }
}
