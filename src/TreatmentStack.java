public class TreatmentStack {
	private static class Node {
		private final TreatmentRecord record;
		private Node next;

		private Node(TreatmentRecord record) {
			this.record = record;
		}
	}

	private Node top;

	public void push(TreatmentRecord record) {
		Node node = new Node(record);
		node.next = top;
		top = node;
	}

	public TreatmentRecord pop() {
		if (top == null) {
			return null;
		}
		TreatmentRecord record = top.record;
		top = top.next;
		return record;
	}

	public void display() {
		if (top == null) {
			System.out.println("The treatment stack is empty.");
			return;
		}
		Node current = top;
		while (current != null) {
			System.out.println(current.record);
			current = current.next;
		}
	}
}
