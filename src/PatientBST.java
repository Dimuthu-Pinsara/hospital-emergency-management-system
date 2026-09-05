public class PatientBST {
	private static class Node {
		private Patient patient;
		private Node left;
		private Node right;

		private Node(Patient patient) {
			this.patient = patient;
		}
	}

	private Node root;

	public boolean insert(Patient patient) {
		if (root == null) {
			root = new Node(patient);
			return true;
		}
		return insert(root, patient);
	}

	private boolean insert(Node node, Patient patient) {
		if (patient.getPatientId() == node.patient.getPatientId()) {
			return false;
		}
		if (patient.getPatientId() < node.patient.getPatientId()) {
			if (node.left == null) {
				node.left = new Node(patient);
				return true;
			}
			return insert(node.left, patient);
		}
		if (node.right == null) {
			node.right = new Node(patient);
			return true;
		}
		return insert(node.right, patient);
	}

	public Patient search(int patientId) {
		Node current = root;
		while (current != null) {
			if (patientId == current.patient.getPatientId()) {
				return current.patient;
			}
			current = patientId < current.patient.getPatientId()
					? current.left : current.right;
		}
		return null;
	}

	public boolean delete(int patientId) {
		if (search(patientId) == null) {
			return false;
		}
		root = delete(root, patientId);
		return true;
	}

	private Node delete(Node node, int patientId) {
		if (node == null) {
			return null;
		}
		if (patientId < node.patient.getPatientId()) {
			node.left = delete(node.left, patientId);
			return node;
		}
		if (patientId > node.patient.getPatientId()) {
			node.right = delete(node.right, patientId);
			return node;
		}
		if (node.left == null) {
			return node.right;
		}
		if (node.right == null) {
			return node.left;
		}

		Node successor = node.right;
		while (successor.left != null) {
			successor = successor.left;
		}
		node.patient = successor.patient;
		node.right = delete(node.right, successor.patient.getPatientId());
		return node;
	}

	public void displayInOrder() {
		displayInOrder(root);
	}

	private void displayInOrder(Node node) {
		if (node == null) {
			return;
		}
		displayInOrder(node.left);
		System.out.println(node.patient);
		displayInOrder(node.right);
	}
}
