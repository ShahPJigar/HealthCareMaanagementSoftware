package mainpkg;

public class Condition {

	String patient_id;
	String condition_id;
	String conditionName;
	String startDate;
	String endDate;
	public Condition(String patient_id, String condition_id, String conditionName,
			String startDate, String endDate) {
		super();
		this.patient_id = patient_id;
		this.condition_id = condition_id;
		this.conditionName = conditionName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Condition() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
