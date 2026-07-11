

public class LinkedList {
	public LinkedListItem head;
	
	// O(n)
	void addAtEnd(LinkedListItem item) {
		if (head == null) {
			head = item;
			return;
		}
		
		LinkedListItem current = head;
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = item;
		
	}
	
	// O(n)
	void addAtIndex(LinkedListItem item, int index) {
		
		if (index == 0) {
			item.next = head;
			head = item;
			return;
		}
		
		LinkedListItem current = head;
		for (int i = 0; i < index - 1 && current != null; i++) {
			current = current.next;
		}
		
		item.next = current.next;
		current.next = item;
		
	}
	
	// O(n)
	void remove(int index) {
		LinkedListItem current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		current.next = current.next.next;
	}
	
	// O(n)
	int get(int index) {
		if (index == 0) {
			return head.value;
		}
		
		LinkedListItem current = head;
		for (int i = 0; i < index - 1 && current != null; i++) {
			current = current.next;
		}
		
		return current.next.value;
			
	}
	
}
