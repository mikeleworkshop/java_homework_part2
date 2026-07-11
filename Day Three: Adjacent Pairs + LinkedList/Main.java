public class Main {
	public static final LinkedList ll = new LinkedList();
	
	public static void main(String[] args) {		
		LinkedListItem item1 = new LinkedListItem();
		LinkedListItem item2 = new LinkedListItem();
		
		item1.value = 10;
		item2.value = 20;
	
		ll.addAtEnd(item1);
		System.out.println(ll.get(0));
		ll.addAtEnd(item2);
		System.out.println(ll.get(1));
		
		ll.addAtIndex(item1, 0);
		ll.addAtIndex(item2, 1);
		showAll();
		
		ll.remove(1);
		ll.remove(3);
		showAll();
	
		
	}
	
	static void showAll() {
		System.out.println(ll.get(0));
		System.out.println(ll.get(1));
		System.out.println(ll.get(2));
		System.out.println(ll.get(3));
	}
}
