package com.rtj.trees

object TreeProblem {
  def hasPathSum(tree: BTree[Int], target1: Int): Boolean = {
    def hasPathSumStack(tree: BTree[Int], target: Int): Boolean = {
      if (tree.isEmpty) target == 0
      else if (tree.isLeaf) {
        println("->" + tree.value)
        target == tree.value
      }
      else if (tree.left.isEmpty) hasPathSumStack(tree.right, target - tree.value)
      else hasPathSumStack(tree.left, target - tree.value)
    }

    hasPathSumStack(tree, target1)
  }

  def main(args: Array[String]): Unit = {
    val root = BNode(1,
      BNode(2,
        BNode(3, BEnd, BEnd),
        BNode(4,
          BEnd,
          BNode(5, BEnd, BEnd)
        )
      ),
      BNode(6,
        BNode(7, BEnd, BEnd),
        BNode(8, BEnd, BEnd)
      )
    )


    println(hasPathSum(root, 15))
//    println(hasPathSum(root, 6))

//    for(i <- 1 to 30) {
//      println(i + "->" + hasPathSum(root, i))
//    }

  }
}
