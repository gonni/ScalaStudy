package c.x.sample.hard

object TreeNode {
  trait TNode[+T] {
    def value: T
    def lChild: TNode[T]
    def rChild: TNode[T]
    def isLeaf: Boolean
    def setLeftChild[S >: T](base: TNode[S] = this, nd: TNode[S]): TNode[S] =
      new VNode[S](base.value, nd, base.rChild)
    def setRightChild[S >: T](base: TNode[S] = this, nd: TNode[S]): TNode[S] =
      new VNode[S](base.value, base.lChild, nd)
  }

  case object TNil extends TNode[Nothing] {
    override def value: Nothing = throw new NoSuchElementException()
    override def lChild: TNode[Nothing] = throw new NoSuchElementException()
    override def rChild: TNode[Nothing] = throw new NoSuchElementException()
    override def isLeaf: Boolean = true
    //    override def setLeftChild[S >: Nothing](nd: TNode[S]) = throw new NoSuchElementException()
    //    override def setRightChild[S >: Nothing](nd: TNode[S]) = throw new NoSuchElementException()
  }

  case class VNode[+T](override val value: T,
                       override val lChild: TNode[T],
                       override val rChild: TNode[T]) extends TNode[T] {
    override def isLeaf: Boolean = false

    //    override def setLeftChild[S >: T](nd: TNode[S])= ???
    //
    //    override def setRightChild[S >: T](nd: TNode[S]) = ???
  }
  //  case class ValNode[Int](override val value: Int,
  //                          override val lChild: TNode[Int],
  //                          override val rChild: TNode[Int]) extends TNode[Int] {
  //    override def isLeaf: Boolean = false
  //    override def setLeftChild[S >: Int](nd: TNode[S]): Unit = ???
  //    override def setRightChild[S >: Int](nd: TNode[S]): Unit = ???
  //  }
  //
  //  case class OperNode[String](override val value: String,
  //                              override val lChild: TNode[String],
  //                              override val rChild: TNode[String]) extends TNode[String] {
  //    override def isLeaf: Boolean = false
  //    override def setLeftChild[S >: String](nd: TNode[S]): Unit = ???
  //    override def setRightChild[S >: String](nd: TNode[S]): Unit = ???
  //  }

  //  val tree =
  //    VNode(1,
  //      VNode(2, TNil, TNil),
  //      VNode(3,
  //        VNode(4, TNil, TNil),
  //        VNode(5, TNil, TNil)
  //      )
  //    )
  //
  //  println("Tree => " + tree)
}
