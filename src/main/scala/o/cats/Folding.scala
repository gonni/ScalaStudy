package o.cats

object Folding {
  object ListExcersize {
    def map[A, B](list: List[A])(f: A => B): List[B] =
      list.foldRight(List.empty[B])((a, currentList) => f(a) :: currentList)
  }
}
