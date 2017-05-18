package mainpkg;

public class Symptom {

	String patient_id;
	String symptom_id;
	String symptomName;
	String startDate;
	String endDate;
	public Symptom(String patient_id, String symptom_id, String symptomName,
			String startDate, String endDate) {
		super();
		this.patient_id = patient_id;
		this.symptom_id = symptom_id;
		this.symptomName = symptomName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Symptom() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
