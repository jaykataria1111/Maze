/**
 * 
 */
package sjsu.Katariya.cs146.project2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;

/**
 * @author jay and Julia
 *
 */
public class CellMaze {

	int numOfRows;
	boolean[][] adjacencyMatrix;
	ArrayList<Cell> AllCells;
	private Random random;
	//private Queue<Cell> queue;
	private Queue queue;
	private int dfsOrder;
    private boolean dfsHelper;


	/**
	 * Creates a cellMaze using the number of rows one wants in a maze.
	 * The underlying implementation is and adjacencey matrix which is boolean.
	 * Arraylist is used to hold the references of cells and their neighbours for ease of access.
	 */
	public CellMaze(int numOfRows) {
		// TODO Auto-generated constructor stub
		random = new Random();
		this.AllCells = new ArrayList<Cell>(0);
		this.numOfRows = numOfRows;
		this.adjacencyMatrix = new boolean[numOfRows*numOfRows][numOfRows*numOfRows];
		for(int i=0;i<(numOfRows*numOfRows);i++)
		{
			Cell m = new Cell(i,new ArrayList<Cell>());
			this.AllCells.add(m);
		}
		this.makeNeighbours();
		//this.queue = new PriorityQueue<Cell>();
		this.queue = new Queue(AllCells.size());

	}



	/**
	 * Calls Breadth First Search on the maze using a cell location. 
	 * @param cell is the cell from which we want to the call BFS
	 */
	public void BFSMaze(Cell cell)
	{
		this.refreshColors();
		this.refreshCellOrder();
		cell.setParent(null);
		
		//this.queue.add(cell); //ENQUEUE(Q,s);
		queue.enqueue(cell);
		
		Cell currentCell;
		
		int order = 0;
		boolean flag = false;
		
		
		while(!this.queue.isEmpty())  //While the queue is not empty.
		{
			
			 //currentCell = this.queue.remove();   //Dequeue.
			currentCell = this.queue.dequeue();
			
			 if(!flag)
				 currentCell.setIterationOrder(order%10);
			 
			 if(currentCell == AllCells.get(AllCells.size()-1))
				 flag = true;
			 
			 order++;
	 
			 ArrayList<Cell> adjacentNeighbours = this.getAdjacentNegihbours(currentCell);
			 for(Cell neighbour : adjacentNeighbours)
			 {
				 if(neighbour.getColor() == Color.WHITE)
				 {
					 
					 
					 
					 
					 neighbour.setColor(Color.GRAY);
					 neighbour.setDistance(currentCell.getDistance()+1);
					 neighbour.setParent(currentCell);
					 //this.queue.add(neighbour);
					 this.queue.enqueue(neighbour);
				 }
				 
			 }
			 currentCell.setColor(Color.BLACK);
			 
		}
		
	}
	
	
	/**
	 * Solves the maze using Breadth First Search and returns an array of cells which give the unique path of the solution
	 * @return returns an ArrayList<Integer> which represent the unique solution path. 
	 */
	public ArrayList<Integer> solveBFSMaze()
	{
		this.BFSMaze(this.AllCells.get(0));
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		Cell currentCell = AllCells.get(AllCells.size()-1);
	
		while(currentCell.getParent() != null)
		{
			path.add(currentCell.getNum());
			currentCell = currentCell.getParent();
		}
		path.add(0);
		return path;
		
	}
	
	
	
	
	
	/**
	 * Refreshes the iteration order of the cells.
	 * is important when we call BFS and DFS since it is used to initialize cells.
	 */
	private void refreshCellOrder()
	{
		for(Cell c: AllCells)
		{
			c.setIterationOrder(Integer.MIN_VALUE);
		}
	}
	
	
	
	/**
	 * Solves the maze using Depth First Search and returns an array of cells which give the unique path of the solution
	 * @return returns an ArrayList<Integer> which represent the unique solution path. 
	 */
	public ArrayList<Integer> solveMazeUsingDFS()
	{
		solveDFSMaze();
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		Cell currentCell = AllCells.get(AllCells.size()-1);
	
		while(currentCell.getParent() != null)
		{
			path.add(currentCell.getNum());
			currentCell = currentCell.getParent();
		}
		path.add(0);
		return path;
		
	}
	
	
	
	/**
	 * is the initial Call for DFS Maze 
	 */
	public void solveDFSMaze()
	{
		this.refreshColors();
		this.refreshCellOrder();
		dfsOrder = 0;
		this.dfsHelper = false;
		for(Cell eachCell : this.AllCells)
		{
			if(eachCell.getColor() == Color.WHITE)
			{
				DFS_visit(eachCell);
			}
		}
	}


	

	/**
	 * Is the recursive call for each element 
	 * @param eachCell is the cell which is being visited.
	 */
	private void DFS_visit(Cell eachCell) 
	{
		eachCell.setColor(Color.GRAY);
		
		
		 if(!dfsHelper)
			 eachCell.setIterationOrder(dfsOrder%10);
		 
		 if(eachCell == AllCells.get(AllCells.size()-1))
			 dfsHelper = true;
		 
		 dfsOrder++;
		
		
		ArrayList<Cell> adjacentNeighbours = this.getAdjacentNegihbours(eachCell);
		
		for(Cell neighbour : adjacentNeighbours)
		{
			
			if(neighbour.getColor() == Color.WHITE)
			{
				neighbour.setParent(eachCell);
				DFS_visit(neighbour);
			}
		}
		
		eachCell.setColor(Color.BLACK);
		
		
	}
	


	/**
	 * Refresh's the colors of the cell.
	 * is important when we call BFS and DFS since it is used to initialize cells.
	 */
	private void refreshColors()
	{
		for(Cell eachCell: AllCells)
			eachCell.setColor(Color.WHITE);
	}
	
	
	
	/**
	 * The following method returns an arraylist of neighbours when a cell is passed
	 * @param cell is the Cell who's neighbours we want.
	 * @return Returns an ArrayList<Cell> who are the adjacent neighbours of the current Cell.
	 */
	public ArrayList<Cell> getAdjacentNegihbours(Cell cell)
	{
	
		ArrayList<Cell> adjacentNeighbours = new ArrayList<Cell>();

			for(int j=0; j< numOfRows*numOfRows; j++)
			{
				if(this.adjacencyMatrix[cell.getNum()][j])
				{
					Cell neighbourcell = AllCells.get(j);
					adjacentNeighbours.add(neighbourcell);
				}
			}
		if(!adjacentNeighbours.isEmpty())	
			return adjacentNeighbours;
		else
			return null;
		
	}


	
	
	
	
	
	/**
	 * Generates a Maze using DFS implementation.
	 */
	public void generateDFSCellMaze()
	{
		Stack<Cell> cellStack = new Stack<>();
		int totalCells = numOfRows*numOfRows;
		Cell currentCell = this.AllCells.get(0);
		int visitedCells = 1;
		while(visitedCells<totalCells)
		{
			if(getNeighboursWithIntactWalls(currentCell) != null)
			{
				Cell newCell = getRandomElement(getNeighboursWithIntactWalls(currentCell));
				knockDownWall(currentCell, newCell);
				cellStack.push(currentCell);
				currentCell = newCell;
				visitedCells++;

			 

			}
			else 
			{
				currentCell = cellStack.pop();

			}
		}
		
	}
	


	/**
	 * Returns a random element from a list
	 * @param cellList is the lest that we want a random element from
	 * @return a Cell at random from the cellList.
	 */
	public Cell getRandomElement(ArrayList<Cell> cellList)
	{
		int i = random.nextInt(cellList.size());
		return cellList.get(i);
	}


	/**
	 * The following knocks down walls between the maze.
	 * @param a The first Cell 
	 * @param b The Second Cell
	 */
	public void knockDownWall(Cell a,Cell b)
	{
		a.setFlag(true);
		b.setFlag(true);
		this.adjacencyMatrix[a.getNum()][b.getNum()] = true;
		this.adjacencyMatrix[b.getNum()][a.getNum()] = true;

	}

	/**
	 * Returns the neighbours with intact walls 
	 * @param cell is the cell who's neighbours we want with intact walls.
	 * @return  ArrayList of cells whos walls are intact null if the list is empty.
	 */
	public ArrayList<Cell> getNeighboursWithIntactWalls(Cell cell)
	{
		ArrayList<Cell> neighbours = cell.getNeighbours();
		ArrayList<Cell> neighboursWithIntactWalls = new ArrayList<Cell>();
		for(Cell cells : neighbours)
		{
			if(!cells.isFlag())
			{
				neighboursWithIntactWalls.add(cells);
			}
		}

		if(!neighboursWithIntactWalls.isEmpty())
			return neighboursWithIntactWalls;
		else
			return null;	
	}



	/**
	 * The following method assigns neighbours to the elements in the maze.
	 */
	private void makeNeighbours() 
	{
		for(Cell eachcell: AllCells)
		{
			int cellNum = eachcell.getNum();
			if(checkValidity(cellNum-numOfRows))
			{
				eachcell.addNeighbour(AllCells.get(cellNum-numOfRows));
			}
			if(checkValidity(cellNum-1) && (cellNum-1)%numOfRows!= numOfRows-1)
			{
				eachcell.addNeighbour(AllCells.get(cellNum-1));
			}
			if(checkValidity(cellNum+1) && (cellNum+1)%numOfRows != 0)
			{
				eachcell.addNeighbour(AllCells.get(cellNum+1));
			}
			if(checkValidity(cellNum+numOfRows))
			{
				eachcell.addNeighbour(AllCells.get(cellNum+numOfRows));
			}
		}

	}

	/**
	 * The following mathod checks if the integer is a valid neighbour of certain integer.
	 * @param i is the integer
	 * @return returns true if the element is a memnber of the array.
	 */
	private boolean checkValidity(int i)
	{
		if(i>=0 && i<(numOfRows*numOfRows))
			return true;
		else 
			return false;
	}


	/**
	 * @return the numOfRows
	 */
	public int getNumOfRows() {
		return numOfRows;
	}

	/**
	 * @return the adjacencyMatrix
	 */
	public boolean[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}


	/**
	 * @return the allCells
	 */
	public ArrayList<Cell> getAllCells() {
		return AllCells;
	}

	
	/**
	 * Helper method for debugging purposes.
	 */
	public void printAdjacencyMatrix()
	{
		for(int i=0; i<numOfRows*numOfRows; i++)
		{
			for(int j=0; j< numOfRows*numOfRows; j++)
			{
				System.out.print(this.adjacencyMatrix[i][j] + ", ");
			}
			System.out.println();
		}
		
	}


	
	/**
	 * Testing method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CellMaze maj = new CellMaze(4);

		
		//maj.knockDownWall(maj.getAllCells().get(6),maj.getAllCells().get(7));

		 maj.generateDFSCellMaze();
		 ArrayList<Integer> path = maj.solveMazeUsingDFS();
		
		//maj.printAdjacencyMatrix();
		//maj.getAllCells().get(5).showNeighbours();
		
		//System.out.println(path); 
		Maze m = new Maze(maj);
		m.drawMaze();
		m.drawDFSsolutionMaze();
		m.drawDFSOrderMaze();
		m.drawBFSOrderMaze();
		m.drawBFSsolutionMaze();
		


		


	}


}
