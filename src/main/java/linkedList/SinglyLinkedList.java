package linkedList;

public class SinglyLinkedList {
	
	private ListNode head;
	
	private static class ListNode{
		
		private int data; //Generic type
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}	
	}
	
	public void display() {
		ListNode current = head;
		
		while(current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public int length() {
		int count=0;
		
		if(head==null) {
			return 0;
		}
		
		ListNode current = head;
		
		while(current != null) {
			count++;
			current = current.next;
		}
		
		return count;
	}
	
	//Method to insert the value to the first Node
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	//Method to insert the value to the end of the Node
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		ListNode current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		current.next=newNode;
	}
	
	//Search the key term
	public boolean searchValue(int searchKey) {
		if(head == null) {
			return false;
		}
		
		ListNode current = head;
		
		while(current != null) {
			if(current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	//Reverse the linked List
	public ListNode reverse() {
		if(head == null) {
			return head;
		}
		
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
	}
	
	//Find the mid point of the node
	public ListNode getMiddNode() {
		if(head == null) {
			return null;
		}
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		return slowPtr;
	}
	
	public ListNode getNthNode(int n) {
		if(head == null) {
			return null;
		}
		
		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value n: " + n);
		}
		
		ListNode mainPtr = head;
		ListNode refPtr = head;
		
		int count=0;
		
		while(count<n) {
			if(refPtr == null) {
				throw new IllegalArgumentException(n+ " is greater than the number of the nodes in the list");
			}
			refPtr = refPtr.next;
			count++;
		}
		
		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		
		return mainPtr;
	}
	
	//Delete duplicates in LinkedList
	public void deleteDuplicate() {
		if(head == null) {
			return;
		}
		
		ListNode current = head;
		
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			}
			else {
				current = current.next;
			}
		}
	}
	
	//Add elements in sorted Linked List
	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);
		
		if(head == null) {
			return newNode;
		}
		
		ListNode current = head;
		ListNode temp = null;
		
		while(current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;	
		}
		
		newNode.next = current;
		temp.next = newNode;
		return head;
	}
	
	//Remove specific value in LinkedList
	public void deleteNode(int key) {
		ListNode current = head;
		ListNode temp = null;
		
		if(current != null && current.data == key) {
			head = current.next;
			return;
		}
		
		while(current != null && current.data != key) {
			temp = current;
			current = current.next;
		}
		
		if(current == null) {
			return;
		}
		
		temp.next = current.next;
	}
	
	//Check the loop in Linked List
	public boolean checkLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(fastPtr == slowPtr) {
				return true;
			}
		}
		return false;
	}
	
	//create Linked List loop
	public void createLoop() {
		ListNode first = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		
		head = first;
		first.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = three;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		//Now connect with pointers
		sll.head.next = second;
		second.next = third;
		third.next = fourth;
		
		sll.insertFirst(11);
		sll.insertLast(100);
		
		sll.display();
		System.out.println("The length is: "+ sll.length());
		
//		if(sll.searchValue(1)) {
//			System.out.println("Search key found");
//		}
//		else {
//			System.out.println("Search key not found");
//		}
		
		ListNode newHead = sll.reverse();
		sll.head = newHead;
		sll.display();
		
		sll.deleteDuplicate();
//		sll.display();
		
		ListNode middleNode = sll.getMiddNode();
		System.out.println("The middle Node is--> " + middleNode.data);
		
		ListNode nthNode = sll.getNthNode(1);
		System.out.println(nthNode.data);
		
		sll.insertInSortedList(300);
		sll.display();
		
		sll.deleteNode(11);
		sll.display();
		
		sll.createLoop();
		System.out.println(sll.checkLoop());
		
		
	}
	
}
