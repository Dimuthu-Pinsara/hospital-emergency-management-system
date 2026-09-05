public class TreatmentRecord {
	private final Patient patient;
	private final String doctorName;
	private final String treatment;
	private final String treatmentDate;

	public TreatmentRecord(Patient patient, String doctorName,
						   String treatment, String treatmentDate) {
		this.patient = patient;
		this.doctorName = doctorName;
		this.treatment = treatment;
		this.treatmentDate = treatmentDate;
	}

	public Patient getPatient() {
		return patient;
	}

	@Override
	public String toString() {
		return "Patient: " + patient.getPatientName()
				+ " (ID: " + patient.getPatientId() + ")"
				+ ", Doctor: " + doctorName
				+ ", Treatment: " + treatment
				+ ", Date: " + treatmentDate;
	}
}
