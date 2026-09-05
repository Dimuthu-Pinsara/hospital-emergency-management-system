public class HospitalSystem {
	private final PatientBST patientRecords = new PatientBST();
	private final EmergencyQueue emergencyQueue = new EmergencyQueue();

	public boolean registerPatient(Patient patient) {
		return patientRecords.insert(patient);
	}

	public Patient searchPatient(int patientId) {
		return patientRecords.search(patientId);
	}

	public void displayPatients() {
		patientRecords.displayInOrder();
	}

	public void joinEmergencyQueue(int patientId) {
		Patient patient = searchPatient(patientId);
		if (patient == null) {
			System.out.println("Patient not found.");
			return;
		}
		emergencyQueue.enqueue(patient);
		System.out.println(patient.getPatientName() + " joined the emergency queue.");
	}

	public Patient treatNextPatient() {
		Patient patient = emergencyQueue.dequeue();
		if (patient == null) {
			System.out.println("The emergency queue is empty.");
			return null;
		}
		System.out.println(patient.getPatientName() + " is sent for treatment.");
		return patient;
	}

	public void displayWaitingPatients() {
		emergencyQueue.display();
	}
}
