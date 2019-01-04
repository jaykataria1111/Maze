/**
 * 
 */
package sjsu.Katariya.cs146.project2;

import java.util.ArrayList;

/**
 * @author jay and Julia
 *
 */

public class Maze {


	int elements;
	boolean[][] maze;
	CellMaze cellMaze;


	/**
	 * @param adjacencyMatrix
	 */
	public Maze(boolean[][] adjacencyMatrix) {
		// TODO Auto-generated constructor stub
		this.maze = adjacencyMatrix;
		//this.elements = elements;
		elements= (int) Math.sqrt(adjacencyMatrix.length);

	}
	
	
	/**
	 * The following constructor creates  a Maze object which is used for drawing using a CellMazeObject.
	 * @param cellmaze is the cellMaze that we want to print.
	 */
	public Maze(CellMaze cellmaze)
	{
		this.maze = cellmaze.getAdjacencyMatrix();
		elements = (int) Math.sqrt(this.maze.length);
		this.cellMaze = cellmaze;
	}



	/**
	 * The following method draws an  maze using a cellMaze.
	 * @return returns the string Representation of the maze.
	 */
	public String drawMaze() {
		
		 String solution = new String();
		 
		for(int i = 0;i <= elements;i++)
		{
			 
			for(int j=0;j<=elements;j++)
			{
				//CallNum is the cell num.
				int callNum = i*(elements)+j;
				
				System.out.print("+");
				solution += "+";
				if(j!=elements)
				{
					if(i==0 &&j==0 || i==elements &&j==(elements-1))
					{
						System.out.print(" ");
						solution += " ";
					}
					else if(i<elements && isConnected(callNum,callNum - elements))
					{
						System.out.print(" ");
						solution += " ";
					}
					else
					{
						System.out.print("-");
						solution += "-";
					}
				}
			}
			
			System.out.println();
			solution += "\n";
			for(int k=0;k<=elements;k++)
			{
				int cellNum = i*(elements)+k;

				if(i!=elements)
				{
					if(k < elements && isConnected(cellNum, cellNum-1) )
					{
						System.out.print(" ");
						solution += " ";
					}
					else 
					{
						System.out.print("|");
						solution += "|";
					}
					
					System.out.print(" ");
					solution += " ";
				}
			}
			System.out.println();
			solution += "\n";
		}
		return solution;
	}


	
	/**
	 * The following method draws the solution of maze using BFS.
	 * Prints out # for the solution path of the maze.
	 * @return the string format of BFS solution.
	 */
	public String drawBFSsolutionMaze()
	{
		ArrayList<Integer> solutionElements = cellMaze.solveBFSMaze();
		String solution = new String();
		
		for(int i = 0;i <= elements;i++)
		{
			 
			for(int j=0;j<=elements;j++)
			{
				//CallNum is the cell num.
				int callNum = i*(elements)+j;
				
				System.out.print("+");
				solution += "+";
				if(j!=elements)
				{
					if(i==0 &&j==0 || i==elements &&j==(elements-1))
					{
						System.out.print(" ");
						solution += " ";
					}
					else if(i<elements && isConnected(callNum,callNum - elements))
					{
						System.out.print(" ");
						solution += " ";
					}
					else
					{
						System.out.print("-");
						solution += "-";
					}
				}
			}
			
			System.out.println();
			solution += "\n";
			for(int k=0;k<=elements;k++)
			{
				int cellNum = i*(elements)+k;
				
				if(i!=elements)
				{
					if(k < elements && isConnected(cellNum, cellNum-1) )
					{
						System.out.print(" ");
						solution += " ";
					}
					else 
					{
						System.out.print("|");
						solution += "|";
					}
					
					if(solutionElements.contains(cellNum) && k != elements)
						{System.out.print("#");
						solution += "#";}
					else
						{System.out.print(" ");
						solution += " ";}
				}
			}
			System.out.println();
			solution += "\n";
		}
		return solution;
		
	}
	
	
	/**
	 * The following method prints out the order of the iteration for the maze.
	 * The maze has digits from 0 to 9 and the order is produced as a result of BFS traversal.
	 * @return Returns the string representation of the maze.
	 */
	public String drawBFSOrderMaze()
	{
		cellMaze.solveBFSMaze();
		ArrayList<Cell> AllCells = cellMaze.getAllCells();
		String solution = new String();
		
		
		for(int i = 0;i <= elements;i++)
		{
			 
			for(int j=0;j<=elements;j++)
			{
				//CallNum is the cell num.
				int callNum = i*(elements)+j;
				
				System.out.print("+");
				solution += "+";
				if(j!=elements)
				{
					if(i==0 &&j==0 || i==elements &&j==(elements-1))
					{
						System.out.print(" ");
						solution += " ";
					}
					else if(i<elements && isConnected(callNum,callNum - elements))
					{
						System.out.print(" ");
						solution += " ";
					}
					else
					{
						System.out.print("-");
						solution += "-";
					}
				}
			}
			
			System.out.println();
			solution += "\n";
			for(int k=0;k<=elements;k++)
			{
				int cellNum = i*(elements)+k;
				
				if(i!=elements)
				{
					if(k < elements && isConnected(cellNum, cellNum-1) )
					{
						System.out.print(" ");
						solution += " ";
					}
					else 
					{
						System.out.print("|");
						solution += "|";
					}
					
					if(cellNum<AllCells.size() && AllCells.get(cellNum).getIterationOrder() != Integer.MIN_VALUE && k!=elements)
						{
						System.out.print(AllCells.get(cellNum).getIterationOrder());
						solution += "" + AllCells.get(cellNum);
						}
					else
					{
						System.out.print(" ");
						solution += " ";
					}
				}
			}
			System.out.println();
			solution += "\n";
		}
		
		return solution;
	}
	
	
	
	
	/**
	 * The following method draws the solution of maze using DFS.
	 * Prints out # for the solution path of the maze.
	 * @return returns a string which represents the solution of the maze.
	 */
	public String drawDFSsolutionMaze()
	{
		ArrayList<Integer> solutionElements = cellMaze.solveMazeUsingDFS();
		String solution = new String();
		
		for(int i = 0;i <= elements;i++)
		{
			 
			for(int j=0;j<=elements;j++)
			{
				//CallNum is the cell num.
				int callNum = i*(elements)+j;
				
				System.out.print("+");
				solution += "+";
				if(j!=elements)
				{
					if(i==0 &&j==0 || i==elements &&j==(elements-1))
					{
						System.out.print(" ");
						solution += " ";
					}
					else if(i<elements && isConnected(callNum,callNum - elements))
					{
						System.out.print(" ");
						solution += " ";
					}
					else
					{
						System.out.print("-");
						solution += "-";
					}
				}
			}
			
			System.out.println();
			solution += "\n";
			for(int k=0;k<=elements;k++)
			{
				int cellNum = i*(elements)+k;
				
				if(i!=elements)
				{
					if(k < elements && isConnected(cellNum, cellNum-1) )
					{
						System.out.print(" ");
						solution += " ";
					}
					else 
					{
						System.out.print("|");
						solution += "|";
					}
					
					if(solutionElements.contains(cellNum) && k != elements)
						{System.out.print("#");
						solution += "#";}
					else
					{
						System.out.print(" ");
						solution += " ";
					}
				}
			}
			System.out.println();
			solution += "\n";
		}
	
		return solution;
	}
	
	
	
	/**
	 * The following method prints out the order of the iteration for the maze.
	 * The maze has digits from 0 to 9 and the order is produced as a result of DFS traversal.
	 * @return returns a string which represents the maze.
	 */
	public String drawDFSOrderMaze()
	{
		String solution = new String();
		cellMaze.solveMazeUsingDFS();
		ArrayList<Cell> AllCells = cellMaze.getAllCells();
		
		
		for(int i = 0;i <= elements;i++)
		{
			 
			for(int j=0;j<=elements;j++)
			{
				//CallNum is the cell num.
				int callNum = i*(elements)+j;
				
				System.out.print("+");
				solution += "+";
				if(j!=elements)
				{
					if(i==0 &&j==0 || i==elements &&j==(elements-1))
					{
						System.out.print(" ");
						solution += " ";
					}
					else if(i<elements && isConnected(callNum,callNum - elements))
					{
						System.out.print(" ");
						solution += " ";
					}
					else
					{
						System.out.print("-");
						solution += "-";
					}
				}
			}
			
			System.out.println();
			solution += "\n";
			
			for(int k=0;k<=elements;k++)
			{
				int cellNum = i*(elements)+k;
				
				if(i!=elements)
				{
					if(k < elements && isConnected(cellNum, cellNum-1) )
					{
						System.out.print(" ");
						solution += " ";
					}
					else 
					{
						System.out.print("|");
						solution += "|";
					}
					
					if(cellNum<AllCells.size() && AllCells.get(cellNum).getIterationOrder() != Integer.MIN_VALUE && k!=elements)
						{
							System.out.print(AllCells.get(cellNum).getIterationOrder());
							solution += "" + AllCells.get(cellNum);
						}
					else
					{
						System.out.print(" ");
						solution += " ";
					}
				}
			}
			System.out.println();
			solution += "\n";
		}
		
		return solution;
		
	}
	
	
	
	
	
	/**
	 * The following method checks if two nodes in a graph are connected
	 * @param i is the first cell Number
	 * @param j is the second cell Number
	 * @return true if there is and edge between i and j, false if there is no edge.
	 */
	public boolean isConnected(int i,int j)
	{
		if(i<0 || j<0)
			return false;
		else 
			return maze[i][j];
	}

	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] m = new boolean[4][4];
				
		m[0][1] = true;
		m[1][0] = true;
		
		m[1][3] = true;
		m[3][1] = true;
		
		
		Maze ma = new Maze(m);
		ma.drawMaze();

	}

}
