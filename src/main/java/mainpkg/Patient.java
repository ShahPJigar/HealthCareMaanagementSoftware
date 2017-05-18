package mainpkg;

public class Patient {

	String patient_id;
	String firstName;
	String lastName;
	int age;
	String email;
	String Gender;
	public Patient(String patient_id, String firstName, String lastName, int age,
			String email, String gender) {
		super();
		this.patient_id = patient_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		Gender = gender;
	}
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
