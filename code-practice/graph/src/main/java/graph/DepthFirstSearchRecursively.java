package graph;

/**
 * http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Graph/dfs.html
 * 
 *
 */
public class DepthFirstSearchRecursively
{
   /* ------------------------------------------
      Data structure used to represent a graph
      ------------------------------------------ */
   int[][]  adjMatrix;
   int      rootNode = 0;
   int      NNodes;

   boolean[] visited; 

   /* -------------------------------
      Construct a graph of N nodes
      ------------------------------- */
   DepthFirstSearchRecursively(int N)
   {
      NNodes = N;
      adjMatrix = new int[N][N];
      visited = new boolean[N];
   }

   DepthFirstSearchRecursively(int[][] mat)
   {
      int i, j;

      NNodes = mat.length;

      adjMatrix = new int[NNodes][NNodes];
      visited = new boolean[NNodes];


      for ( i=0; i < NNodes; i++)
         for ( j=0; j < NNodes; j++)
            adjMatrix[i][j] = mat[i][j];
   }

   public void dfs(int i)
   {
      int j;

      visited[i] = true;

      printNode(i);

      
      for ( j = 0; j < NNodes; j++ )
      {
    	  if ( adjMatrix[i][j] > 0 && !visited[j] )
            dfs(j);
      }
   }

   
	int getUnvisitedChildNode(int n) {
		int j;

		for (j = 0; j < NNodes; j++) {
			if (adjMatrix[n][j] > 0 && !visited[j]) {
					return (j);
			}
		}

		return (-1);
	}
	

   public void clearVisited()
   {
      int i;

      for (i = 0; i < visited.length; i++)
         visited[i] = false;
   }

   public void printNode(int n)
   {
      System.out.println(n);
   }
   
   public static void main(String[] args)
   {
	   //0 is connected to 1 3 and 8
	   //1 is connected to 0 and 7
//                        0  1  2  3  4  5  6  7  8
// ===================================================
      int[][] conn = {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
    		  			{ 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
    		  			{ 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
						{ 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
						{ 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
						{ 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
						{ 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
						{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
						{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8


      DepthFirstSearchRecursively G = new DepthFirstSearchRecursively(conn);

      G.clearVisited();
      G.dfs(0);

   }
   
}

