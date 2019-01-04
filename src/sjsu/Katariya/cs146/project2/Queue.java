/**
 * 
 */
package sjsu.Katariya.cs146.project2;

/**
 * @author jay & Julia
 *
 */
public class Queue {

	int  head;
	int  tail;
	Cell[] queue;
	int size;
	
	
	
	/**
	 * The following constructer generates a queue using a size
	 * @param size is the size of the array which the queue will use for implementation.
	 */
	public Queue(int size) {
		// TODO Auto-generated constructor stub
		queue = new Cell[size];
		head = 0;
		tail = 0;
		this.size = size;
		
	}

	/**
	 * Enqueue's a cell to the queue i.e. adds a cell to the queue
	 * @param cell
	 */
	public void enqueue(Cell cell)
	{
		if(isEmpty())
		{
			queue[head%size] = cell;
			queue[tail%size] = cell;
			tail++;
		}
		else
		{
			queue[tail%size] = cell;
			tail++;
		}
		
		
	}
	
	
	/**
	 * Dequeue's a cell fromt the queue i.e. removes the head of the queue in FIFO order.
	 * @return returns a Cell which is at the head of the queue
	 */
	public Cell dequeue()
	{
		Cell cell = queue[head%size];
		queue[head%size] = null;
		head++;
		return cell;
		
	}
	
	
	/**
	 * Checks if the queue is empty 
	 * @return true if the queue is empty, false if the queue is not empty.
	 */
	public boolean isEmpty()
	{
		if(head == tail && queue[head%size] == null)
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * Main method for testing purposes.
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		Queue q = new Queue(6);
		q.enqueue(new Cell(1,null));
		q.enqueue(new Cell(2,null));
		q.enqueue(new Cell(3,null));
		
		System.out.println(q.isEmpty());
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		System.out.println(q.isEmpty());
		
	}
	
}
