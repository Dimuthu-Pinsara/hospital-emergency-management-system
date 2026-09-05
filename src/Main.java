import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		HospitalSystem hospital = new HospitalSystem();
		boolean running = true;

		while (running) {
			displayMenu();
			int choice = readInt("Choose an option: ");
			switch (choice) {
				case 1 -> registerPatient(hospital);
				case 2 -> searchPatient(hospital);
				case 3 -> deletePatient(hospital);
				case 4 -> hospital.displayPatients();
				case 5 -> joinEmergencyQueue(hospital);
				case 6 -> hospital.treatNextPatient();
				case 7 -> hospital.displayWaitingPatients();
				case 8 -> completeTreatment(hospital);
				case 9 -> hospital.displayTreatmentHistory();
				case 10 -> hospital.removeLatestTreatment();
				case 11 -> addVisit(hospital);
				case 12 -> searchVisit(hospital);
				case 13 -> removeVisit(hospital);
				case 14 -> displayVisits(hospital);
				case 0 -> running = false;
				default -> System.out.println("Invalid option. Please choose from the menu.");
			}
		}
		System.out.println("Hospital system closed.");
	}

	private static void displayMenu() {
		System.out.println("\n===== Hospital Emergency Management System =====");
		System.out.println("1. Register patient");
		System.out.println("2. Search patient");
		System.out.println("3. Delete patient");
		System.out.println("4. Display all patients");
		System.out.println("5. Add patient to emergency queue");
		System.out.println("6. Treat next patient");
		System.out.println("7. Display waiting queue");
		System.out.println("8. Complete treatment");
		System.out.println("9. View treatment history");
		System.out.println("10. Remove latest treatment");
		System.out.println("11. Add patient visit");
		System.out.println("12. Search patient visit");
		System.out.println("13. Remove patient visit");
		System.out.println("14. Display patient visits");
		System.out.println("0. Exit");
	}

	private static void registerPatient(HospitalSystem hospital) {
		Patient patient = new Patient(readInt("Patient ID: "), readText("Patient name: "),
				readInt("Age: "), readText("Contact number: "),
				readText("Medical condition: "));
		System.out.println(hospital.registerPatient(patient)
				? "Patient registered successfully."
				: "A patient with that ID already exists.");
	}

	private static void searchPatient(HospitalSystem hospital) {
		Patient patient = hospital.searchPatient(readInt("Patient ID: "));
		System.out.println(patient == null ? "Patient not found." : patient);
	}

	private static void deletePatient(HospitalSystem hospital) {
		System.out.println(hospital.deletePatient(readInt("Patient ID: "))
				? "Patient deleted successfully."
				: "Patient not found.");
	}

	private static void joinEmergencyQueue(HospitalSystem hospital) {
		hospital.joinEmergencyQueue(readInt("Patient ID: "));
	}

	private static void completeTreatment(HospitalSystem hospital) {
		hospital.completeTreatment(readInt("Patient ID: "), readText("Doctor name: "),
				readText("Treatment: "), readText("Treatment date: "));
	}

	private static void addVisit(HospitalSystem hospital) {
		int patientId = readInt("Patient ID: ");
		Visit visit = new Visit(readText("Visit ID: "), readText("Visit date: "),
				readText("Doctor name: "), readText("Diagnosis: "),
				readText("Treatment: "));
		if (hospital.addPatientVisit(patientId, visit)) {
			System.out.println("Visit added successfully.");
		}
	}

	private static void searchVisit(HospitalSystem hospital) {
		Visit visit = hospital.searchPatientVisit(readInt("Patient ID: "),
				readText("Visit ID: "));
		System.out.println(visit == null ? "Visit not found." : visit);
	}

	private static void removeVisit(HospitalSystem hospital) {
		int patientId = readInt("Patient ID: ");
		String visitId = readText("Visit ID: ");
		System.out.println(hospital.removePatientVisit(patientId, visitId)
				? "Visit removed successfully."
				: "Visit not found.");
	}

	private static void displayVisits(HospitalSystem hospital) {
		hospital.displayPatientVisits(readInt("Patient ID: "));
	}

	private static int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (NumberFormatException exception) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

	private static String readText(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}
}
