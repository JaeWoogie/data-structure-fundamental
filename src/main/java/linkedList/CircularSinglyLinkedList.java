package linkedList;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

	private ListNode last;
	private int length;
	
	private class ListNode{
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public CircularSinglyLinkedList() {
		last=null;
		length=0;
		
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void createCircularLinkList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(6);
		ListNode fourth = new ListNode(10);
		
		first.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=first;
		
		last=fourth;
	}
	
	public void display() {
		if(last == null) {
			return;
		}
		
		ListNode first = last.next;
		
		while(first != last) {
			System.out.print(first.data + " ");
			first = first.next;
			
		}
		System.out.println(first.data);
		
	}
	
	public void insertFirst(int data) {
		ListNode temp = new ListNode(data);
		
		if(last == null) {
			last = temp;
		}
		else {
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}
	
	//Insert element to the last element
	public void insertLast(int data) {
		ListNode temp = new ListNode(data);
		
		if(last == null) {
			last = temp;
			last.next = last;
		}
		else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
	}
	
	public ListNode removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException("Circular Singly Linked List is already empty");
		}
		
		ListNode temp = last.next;
		
		if(last.next == last) {
			last = null;
		}
		else {
			last.next = temp.next;
		}
		temp.next = null;
		length--;
		return temp;
	}
	
	public static void main(String[] args) {
		CircularSinglyLinkedList cll = new CircularSinglyLinkedList();
		
		cll.insertFirst(40);
		cll.insertFirst(30);
		cll.insertLast(500);
		
		cll.removeFirst();
		
//		cll.createCircularLinkList();
		
		cll.display();
	}
}
