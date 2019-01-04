/**
 * 
 */
package sjsu.Katariya.cs146.project2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jay & Julia
 *Testing class for the maze.
 *
 */
public class CellMazeTest {

	CellMaze fourElementMaze;
	CellMaze sevenElementMaze;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpfourElementMaze() throws Exception {
		
		this.fourElementMaze = new CellMaze(4);
	}
	
	@Test
	public void test4() {
		
		System.out.println("-------4 Element Maze---------");
		
		Maze m  = new Maze(this.fourElementMaze);
		this.fourElementMaze.generateDFSCellMaze();
		System.out.println();
		String maze = m.drawMaze();
		System.out.println("DFS:");
		System.out.println();
		String dfsorder = m.drawDFSOrderMaze();
		System.out.println();
		String dfsSolution = m.drawDFSsolutionMaze();
		System.out.println("BFS:");
		System.out.println();
		String bfsOrd = m.drawBFSOrderMaze();
		System.out.println();
		String bfsSol = m.drawBFSsolutionMaze();
		System.out.println();
		
		
		String maje = 	"+ +-+-+-+\n" + 
						"| |     | \n" + 
						"+ + +-+-+\n" + 
						"| |     | \n" + 
						"+ +-+-+ +\n" + 
						"|   |   | \n" + 
						"+-+ + + +\n" + 
						"|     | | \n" + 
						"+-+-+-+ +\n" +
						"\n" ;
		
		String dfsOrderSol =    "+ +-+-+-+\n" + 
								"|0|2 3 4| \n" + 
								"+ + +-+-+\n" + 
								"|1|1 0 9| \n" + 
								"+ +-+-+ +\n" + 
								"|2 3|7 8| \n" + 
								"+-+ + + +\n" + 
								"|5 4 6|5| \n" + 
								"+-+-+-+ +\n" + 
								"\n" ;
		
		
		
		String dfsSol = "+ +-+-+-+\n" + 
						"|#|     | \n" + 
						"+ + +-+-+\n" + 
						"|#|     | \n" + 
						"+ +-+-+ +\n" + 
						"|# #|# #| \n" + 
						"+-+ + + +\n" + 
						"|  # #|#| \n" + 
						"+-+-+-+ +\n" + 
						"\n" ;
		
		
		String bfsOrder = 	"+ +-+-+-+\n" + 
							"|0|     | \n" + 
							"+ + +-+-+\n" + 
							"|1|    9| \n" + 
							"+ +-+-+ +\n" + 
							"|2 3|7 8| \n" + 
							"+-+ + + +\n" + 
							"|5 4 6|0| \n" + 
							"+-+-+-+ +\n" + 
							"\n" ;
		
		String bfsSolution = 	"+ +-+-+-+\n" + 
							 	"|#|     | \n" + 
							 	"+ + +-+-+\n" + 
							 	"|#|     | \n" + 
							 	"+ +-+-+ +\n" + 
							 	"|# #|# #| \n" + 
							 	"+-+ + + +\n" + 
							 	"|  # #|#| \n" + 
							 	"+-+-+-+ +\n" + 
							 	"\n" ;
		
		
		
		assertEquals(maze,maje);
		assertEquals(dfsorder,dfsOrderSol);
		assertEquals(dfsSolution,dfsSol);
		assertEquals(bfsOrd,bfsOrder);
		assertEquals(bfsSolution,bfsSol);
		
		
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDownfourElementMaze() throws Exception {
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpSevenElementMaze() throws Exception {
		
		this.sevenElementMaze = new CellMaze(7);
	}
	
	@Test
	public void test7() {
		
		System.out.println("-------7 Element Maze---------");
		
		Maze m  = new Maze(this.sevenElementMaze);
		this.sevenElementMaze.generateDFSCellMaze();
		System.out.println();
		String maze = m.drawMaze();
		System.out.println("DFS:");
		System.out.println();
		String dfsorder = m.drawDFSOrderMaze();
		System.out.println();
		String dfsSolution = m.drawDFSsolutionMaze();
		System.out.println("BFS:");
		System.out.println();
		String bfsOrd = m.drawBFSOrderMaze();
		System.out.println();
		String bfsSol = m.drawBFSsolutionMaze();
		System.out.println();
		
		
		String maje = 	"+ +-+-+-+-+-+-+\n" + 
						"| | |     |   | \n" + 
						"+ + + + +-+ + +\n" + 
						"| |   |     | | \n" + 
						"+ +-+ +-+-+-+ +\n" + 
						"|   |     | | | \n" + 
						"+-+ +-+-+ + + +\n" + 
						"| | |   | | | | \n" + 
						"+ + + + + + + +\n" + 
						"| | | |     | | \n" + 
						"+ + +-+-+ +-+ +\n" + 
						"| | |   | |   | \n" + 
						"+ + + + +-+ + +\n" + 
						"|     |     | | \n" + 
						"+-+-+-+-+-+-+ +\n" + 
						"\n" ;
		
		String dfsOrderSol =    "+ +-+-+-+-+-+-+\n" + 
								"|0|3|0 9 7|5 4| \n" + 
								"+ + + + +-+ + +\n" + 
								"|1|2 1|8 7 6|3| \n" + 
								"+ +-+ +-+-+-+ +\n" + 
								"|2 3|4 5 6|5|2| \n" + 
								"+-+ +-+-+ + + +\n" + 
								"|1|4|1 0|7|4|1| \n" + 
								"+ + + + + + + +\n" + 
								"|0|5|2|9 8 3|0| \n" + 
								"+ + +-+-+ +-+ +\n" + 
								"|9|6|3 4|6|8 9| \n" + 
								"+ + + + +-+ + +\n" + 
								"|8 7 2|5 6 7|8| \n" + 
								"+-+-+-+-+-+-+ +\n" + 
								"\n";
		
		
		
		String dfsSol = "+ +-+-+-+-+-+-+\n" + 
						"|#| |     |   | \n" + 
						"+ + + + +-+ + +\n" + 
						"|#|   |     | | \n" + 
						"+ +-+ +-+-+-+ +\n" + 
						"|# #|     | | | \n" + 
						"+-+ +-+-+ + + +\n" + 
						"| |#|   | | | | \n" + 
						"+ + + + + + + +\n" + 
						"| |#| |     | | \n" + 
						"+ + +-+-+ +-+ +\n" + 
						"| |#|# #| |# #| \n" + 
						"+ + + + +-+ + +\n" + 
						"|  # #|# # #|#| \n" + 
						"+-+-+-+-+-+-+ +\n" + 
						"\n" ;
		
		
		String bfsOrder = 	"+ +-+-+-+-+-+-+\n" + 
							"|0| |     |   | \n" + 
							"+ + + + +-+ + +\n" + 
							"|1|   |     | | \n" + 
							"+ +-+ +-+-+-+ +\n" + 
							"|2 3|     | | | \n" + 
							"+-+ +-+-+ + + +\n" + 
							"|4|4|   | | | | \n" + 
							"+ + + + + + + +\n" + 
							"|2|5| |     |0| \n" + 
							"+ + +-+-+ +-+ +\n" + 
							"|0|6|1 3| |8 9| \n" + 
							"+ + + + +-+ + +\n" + 
							"|8 7 9|5 6 7|1| \n" + 
							"+-+-+-+-+-+-+ +\n" + 
							"\n" ;
		
		String bfsSolution = 	"+ +-+-+-+-+-+-+\n" + 
								"|#| |     |   | \n" + 
								"+ + + + +-+ + +\n" + 
								"|#|   |     | | \n" + 
								"+ +-+ +-+-+-+ +\n" + 
								"|# #|     | | | \n" + 
								"+-+ +-+-+ + + +\n" + 
								"| |#|   | | | | \n" + 
								"+ + + + + + + +\n" + 
								"| |#| |     | | \n" + 
								"+ + +-+-+ +-+ +\n" + 
								"| |#|# #| |# #| \n" + 
								"+ + + + +-+ + +\n" + 
								"|  # #|# # #|#| \n" + 
								"+-+-+-+-+-+-+ +\n" +  
							 	"\n" ;
		
		
		
		assertEquals(maze,maje);
		assertEquals(dfsorder,dfsOrderSol);
		assertEquals(dfsSolution,dfsSol);
		assertEquals(bfsOrd,bfsOrder);
		assertEquals(bfsSolution,bfsSol);
		
		
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDownSevenElementMaze() throws Exception {
	}
	

	
	

	

	

}
