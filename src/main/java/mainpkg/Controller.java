package mainpkg;


import javax.swing.table.TableModel;

import org.apache.commons.io.IOUtils;

public class Controller {

	DbConn dbObj;

	Controller() {
		dbObj = new DbConn();
	}

	public TableModel getPatientData(Patient pdata) {
		TableModel btm = null;
		try {

			btm = dbObj.getPatientData(pdata);
			System.out.println("hi" + btm.getRowCount());
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return btm;
	}
	
	public TableModel editPatientData(int pedata) {
		TableModel p = null;
		try {

			p = dbObj.editPatientData(pedata);
			System.out.println("hi" + p.getRowCount());
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return p;
	}
	
	public TableModel editSymptomData(int pedata) {
		TableModel p = null;
		try {

			p = dbObj.editSymptomData(pedata);
			System.out.println("hi" + p.getRowCount());
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return p;
	}
	
	public TableModel editConditionData(int pedata) {
		TableModel p = null;
		try {

			p = dbObj.editConditionData(pedata);
			System.out.println("hi" + p.getRowCount());
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return p;
	}
	
	public TableModel editTreatmentData(int pedata) {
		TableModel p = null;
		try {

			p = dbObj.editTreatmentData(pedata);
			System.out.println("hi" + p.getRowCount());
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return p;
	}

	public int newPatientData(Patient p) {
		int id = 0;
		try {
			id = dbObj.newPatient(p);
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return id;
	}
	
	public int newSymptomData(Symptom s) {
		int id = 0;
		try {
			id = dbObj.newSymptom(s);
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return id;
	}
	
	public int newConditionData(Condition cd) {
		int id = 0;
		try {
			id = dbObj.newCondition(cd);
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return id;
	}
	
	public int newTreatmentData(Treatment t) {
		int id = 0;
		try {
			id = dbObj.newTreatment(t);
			dbObj.close();
		} catch (Exception ex) {
			dbObj.close();
		}
		return id;
	}

	public void initialize(String inputFileName) {

		try {

			dbObj.callProc(inputFileName);
			dbObj.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TableModel getCandFPatients() {
		TableModel p = null;
		try {

			p = dbObj.getCFPatients();
			dbObj.close();
		} catch (Exception e) {

		}
		return p;
	}

	public TableModel getPrevDiabetesPatients() {
		TableModel p = null;
		try {

			p = dbObj.getPrevDiabetes();

			dbObj.close();

		} catch (Exception e) {

		}
		return p;
	}

	public TableModel getMaxSenderToId(int id) {
		TableModel p = null;
		try {

			p = dbObj.getMaxSenderForId(id);

			dbObj.close();

		} catch (Exception e) {

		}
		return p;
	}

	public TableModel nonSendendingPTPatients() {
		TableModel p = null;
		try {

			p = dbObj.nonSenderPT();
			dbObj.close();

		} catch (Exception e) {

		}
		return p;
	}

	public TableModel FemaleSendersToDiabetic() {
		TableModel p = null;
		try {
			p = dbObj.FemaleSenders();
			dbObj.close();

		} catch (Exception e) {

		}
		return p;
	}

	public TableModel getSecondOldestPatients() {
		TableModel p = null;
		try {

			p = dbObj.getSecondOldestPerson();
			dbObj.close();

		} catch (Exception e) {

		}
		return p;
	}


}