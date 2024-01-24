package c.x.basic

object DfsSample extends App {

  def dfs(adj:List[List[Int]], src:Int, vis:List[Int]): List[Int] = {
    if(vis.contains(src)) vis
    else{
      adj(src)
        .foldLeft(src :: vis)((b, a) => dfs(adj, a, b))
    }
  }

  println(dfs(List(List(1, 4), List(2, 3, 4), List(4), List(3), List(0)),0,List()).reverse)
}
