/**
 * 
 */
package sjsu.Katariya.cs146.project2;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author jay and Julia
 *
 */
public class Cell implements Comparable<Cell>{

	private int num;
	private ArrayList<Cell> neighbours;
	private boolean flag = false;
	private Color color;
	private Cell parent;
	private int distance;
	private int iterationOrder;
	
	
	/**
	 * Generates a cell which has its number and a list of neighbours which we are going to assign.
	 */
	public Cell(int num,ArrayList<Cell> neighbours) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.neighbours = neighbours;
		this.color = Color.WHITE;
		this.parent = null;
		this.distance = 0;
		iterationOrder = Integer.MIN_VALUE;
	}

	
	/**
	 * @return the iterationOrder
	 */
	public int getIterationOrder() {
		return iterationOrder;
	}


	/**
	 * @param iterationOrder the iterationOrder to set
	 */
	public void setIterationOrder(int iterationOrder) {
		this.iterationOrder = iterationOrder;
	}


	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}


	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}


	/**
	 * @return the parent
	 */
	public Cell getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Cell parent) {
		this.parent = parent;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the neighbours
	 */
	public ArrayList<Cell> getNeighbours() {
		return neighbours;
	}

	/**
	 * @param neighbours the neighbours to set
	 */
	public void setNeighbours(ArrayList<Cell> neighbours) {
		this.neighbours = neighbours;
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	/*
	 * 
	 */
	public void addNeighbour(Cell cell) {
		this.neighbours.add(cell);
	}
	
	
	/**
	 * Helper method for debugging purposes.
	 */
	public void showNeighbours()
	{
		for(Cell i: this.neighbours)
		{
			System.out.println(i.num);
		}
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}


	@Override
	public int compareTo(Cell o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.getNum(), o.getNum());
		
	}
    
	public String toString()
	{
		return "" + this.iterationOrder%10 ;
		
	}
	
	
}
