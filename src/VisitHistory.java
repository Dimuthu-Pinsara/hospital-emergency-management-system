public class VisitHistory {
	private static class Node {
		private final Visit visit;
		private Node next;

		private Node(Visit visit) {
			this.visit = visit;
		}
	}

	private Node head;

	public void addVisit(Visit visit) {
		Node node = new Node(visit);
		if (head == null) {
			head = node;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	public Visit searchVisit(String visitId) {
		Node current = head;
		while (current != null) {
			if (current.visit.getVisitId().equals(visitId)) {
				return current.visit;
			}
			current = current.next;
		}
		return null;
	}

	public void display() {
		if (head == null) {
			System.out.println("No previous visits found.");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.println(current.visit);
			current = current.next;
		}
	}
}
