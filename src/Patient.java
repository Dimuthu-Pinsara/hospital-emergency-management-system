public class Patient {
	private final int patientId;
	private final String patientName;
	private final int age;
	private final String contactNumber;
	private final String medicalCondition;
	private final VisitHistory visitHistory;

	public Patient(int patientId, String patientName, int age,
				   String contactNumber, String medicalCondition) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.medicalCondition = medicalCondition;
		this.visitHistory = new VisitHistory();
	}

	public int getPatientId() {
		return patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public VisitHistory getVisitHistory() {
		return visitHistory;
	}

	@Override
	public String toString() {
		return "Patient ID: " + patientId
				+ ", Patient Name: " + patientName
				+ ", Age: " + age
				+ ", Contact Number: " + contactNumber
				+ ", Medical Condition: " + medicalCondition;
	}
}
