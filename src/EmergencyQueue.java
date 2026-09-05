public class EmergencyQueue {
	private static class Node {
		private final Patient patient;
		private Node next;

		private Node(Patient patient) {
			this.patient = patient;
		}
	}

	private Node front;
	private Node rear;

	public void enqueue(Patient patient) {
		Node node = new Node(patient);
		if (rear == null) {
			front = node;
			rear = node;
			return;
		}
		rear.next = node;
		rear = node;
	}

	public Patient dequeue() {
		if (front == null) {
			return null;
		}
		Patient patient = front.patient;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		return patient;
	}

	public void display() {
		if (front == null) {
			System.out.println("The emergency queue is empty.");
			return;
		}
		Node current = front;
		while (current != null) {
			System.out.println(current.patient);
			current = current.next;
		}
	}
}
