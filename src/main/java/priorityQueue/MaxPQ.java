package priorityQueue;

public class MaxPQ {
	
	private int[] heap;
	private int n; //size of max heap
	
	public MaxPQ(int capacity) {
		heap = new int[capacity+1]; //index 0 is kept 0
		n = 0;
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public int size() {
		return n;
	}
	
	public void insert(int x) {
		if(n == heap.length-1) {
			resize(2*heap.length);
		}
		n++;
		heap[n] = x;
		swim(n);
	}
	
	private void swim(int k) {
		while(k > 1 && heap[k/2] < heap[k]) {
			int temp = heap[k];
			heap[k] = heap[k/2];
			heap[k/2] = temp;
			k = k/2;
		}
		
	}

	private void resize(int capacity) {
		int[] temp = new int[capacity];
		for(int i=0; i<heap.length; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}
	
	public void printMaxHeap() {
		for(int i=1; i<=n; i++) {
			System.out.print(heap[i] + " ");
		}
	}

	public static void main(String[] args) {
		MaxPQ maxPQ = new MaxPQ(3);
		System.out.println(maxPQ.size());
		System.out.println(maxPQ.isEmpty());
		
		maxPQ.insert(4);
		maxPQ.insert(5);
		maxPQ.insert(2);
		maxPQ.insert(6);
		maxPQ.insert(1);
		maxPQ.insert(3);
		
		System.out.println(maxPQ.size());
		maxPQ.printMaxHeap();
	}
}
