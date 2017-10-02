/**
  * I haven't tested this class, but I think it's time for me to get used to generics, implicits, and context
  * boundaries so I'm going to start writing classes like this. 
  *
  * A generic class that provides methods that operate on 2 dimensional IndexedSeq (like Vector)
  * These methods can be used like map(), filter(), or any other regular collections method.
  *
  * Example: vec.filterByCol(x => x.startsWith("Cool"))(3) // filter to inlcude all values in column 3 that start with "Cool".
  */

object Operations2d {

  implicit class Operations[T](vec: IndexedSeq[IndexedSeq[T]]){

    /** Grab a column of values and put them in a Vector */
    def col(colNum: Int): IndexedSeq[T] = vec.map(x => x(colNum))

    /** Grab a row of values and put them in a Vector */
    def row(value: Int): IndexedSeq[T] = vec(value)

    /** A method to filter by a boolean expression applied to a column */
    def filterByCol(op: T => Boolean)(colNum: Int): IndexedSeq[IndexedSeq[T]] = {
      val result =
        for{ value <- vec
        if op(value(colNum)) == true
      } yield value
      result
    } // END filterByCol()

  } // END implicit class Operations[T]
} // END Operations2d object
