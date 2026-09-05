public class Main {
	public static void main(String[] args) {
		HospitalSystem hospital = new HospitalSystem();
		Patient patient = new Patient(1005, "Amal Perera", 25,
				"0771234567", "Chest pain");

		System.out.println("1. Register patient");
		if (hospital.registerPatient(patient)) {
			System.out.println("Patient registered successfully.");
		}

		System.out.println("\n2. Search patient using ID 1005");
		Patient foundPatient = hospital.searchPatient(1005);
		System.out.println(foundPatient == null ? "Patient not found." : foundPatient);

		System.out.println("\n3. Join emergency queue");
		hospital.joinEmergencyQueue(1005);
		hospital.displayWaitingPatients();

		System.out.println("\n4. View previous visits");
		patient.getVisitHistory().display();

		System.out.println("\n5. Add a new visit after treatment");
		patient.getVisitHistory().addVisit(new Visit("V001", "2026-09-05",
				"Dr. Fernando", "Chest pain", "ECG and medication"));
		patient.getVisitHistory().display();

		System.out.println("\n6. Complete treatment and push record onto stack");
		hospital.treatNextPatient();
		hospital.completeTreatment(1005, "Dr. Fernando",
				"ECG and medication", "2026-09-05");

		System.out.println("\n7. Display treatment history (top first)");
		hospital.displayTreatmentHistory();

		System.out.println("\n8. Pop the most recently completed treatment");
		hospital.removeLatestTreatment();

		System.out.println("\n9. Display treatment history after pop");
		hospital.displayTreatmentHistory();
	}
}
