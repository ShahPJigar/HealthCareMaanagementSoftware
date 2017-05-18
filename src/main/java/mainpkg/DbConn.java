package mainpkg;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.io.IOUtils;

public class DbConn {

	private final String dbName = "sampledb";
	private final String dbUserName = "sampledb";
	private final String dbUserPasswd = "pass1234";
	private final String dbFile = "intialize.sql";

	private Connection dbConnection = null;

	public Connection getDbConnection() {
		return dbConnection;
	}

	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement callProcStmt = null;
	private ResultSet resultSet = null;

	/** Method closes a connection */
	public void close() {
		try {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex);
			return;
		}

		System.out.println("Connection is closed successfully.");
	}

	public boolean isConnected() {
		try {
			if (dbConnection != null && !dbConnection.isClosed()) {
				return true;
			}
		} catch (SQLException ex) {

		}
		return false;
	}

	/*
	 * Databse Connection creation for "sampledb" database. username-password :
	 * sampledb/pass1234
	 */
	Connection openConnection() throws Exception {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager
					.getConnection("jdbc:mysql://localhost/sampledb?useInformationSchema=true&"
							+ "allowMultiQueries=true&noAccessToProcedureBodies=true&"
							+ "user=sampledb&password=pass1234");
			System.out.println("\ngt Connection\n");
			return dbConnection;

		} catch (Exception e) {
			throw e;
		} finally {
			// close();
		}

	}

	/*
	 * Procedure to call Datbase Stored Procedure
	 */

	public void callProc(String filename) throws SQLException {

		try {
			dbConnection = openConnection();
			String sqls = "{ call sp_intialize() }";// "{ call get_candidate_skill(?) }";
			callProcStmt = dbConnection.prepareCall(sqls);
			System.out.println(sqls);
			callProcStmt.execute();
			callProcStmt.close();
			// InputStream c = getClass().getResourceAsStream("initialize.sql");
			String query;
			query = IOUtils.toString(new FileReader(filename));
			PreparedStatement stmt = dbConnection.prepareStatement(query);
			stmt.execute();
			stmt.close();
			dbConnection.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// con.close();

	}

	/**
	 * Java Procedure to fetch Patient Data based on the user selected fields.
	 * 
	 * @param p
	 * @return
	 * @throws SQLException
	 */

	public TableModel getPatientData(Patient p) throws SQLException {
		TableModel pdata = null;
		try {
			String sql = null;
			sql = "SELECT pid,fname,lname,age,email,gender from sampledb.Patients p where 1=1 ";
			if (p.patient_id != null && !(p.patient_id.equals(""))) {
				sql += " and p.pid = " + p.patient_id;// '"+ id +"'"
			}
			if (p.firstName != null && !(p.firstName.equals(""))) {
				sql += " and p.fName = '" + p.firstName + "'";
			}
			if (p.lastName != null && !(p.lastName.equals(""))) {
				sql += " and p.lname = '" + p.lastName + "'";
			}
			/*
			 * if (p.age != -1) { sql += " and p.age = " + p.age; }
			 */
			if (p.email != null && !(p.email.equals(""))) {
				sql += " and p.email = '" + p.email + "'";
			}
			if (p.Gender != null && !(p.Gender.equals(""))) {// '\u0000') {
				sql += " and p.gender = '" + p.Gender + "'";
			}
			System.out.println(sql);
			dbConnection = openConnection();
			statement = dbConnection.createStatement();
			resultSet = statement.executeQuery(sql);
			pdata = buildTableModel(resultSet);
			/*
			 * while (resultSet.next()) {
			 * System.out.println(resultSet.getString(2)); pdata =
			 * buildTableModel(resultSet); }
			 */
		} catch (Exception e) {
			e.getStackTrace();
		}

		return pdata;
	}

	/*
	 * Creating a TableModel for the swing window
	 */
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		Vector<String> columnNames = new Vector<String>();
		columnNames.addAll(Arrays.asList("PatientID", "FirstName", "LastName",
				"Age", "Email", "Gender"));
		// olumnNames.add(metaData.getColumnName(column));

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				Object s = rs.getObject(columnIndex);
				vector.add(s);

				System.out.println(s);
			}
			data.add(vector);
		}
		return new DefaultTableModel(data, columnNames);

	}

	/**
	 * To Insert a new Patient Record to database.
	 * 
	 * @param p
	 * @return
	 */
	public int newPatient(Patient p) {

		String query = "INSERT INTO  PATIENTS(fname,lname,gender, age,email) values(?,?,?,?,?)";
		int newid = 0;
		try {
			dbConnection = openConnection();
			preparedStatement = dbConnection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, p.firstName);
			preparedStatement.setString(2, p.lastName);
			preparedStatement.setString(3, String.valueOf(p.Gender));
			preparedStatement.setInt(4, p.age);
			preparedStatement.setString(5, p.email);

			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				newid = rs.getInt(1);
			}
			dbConnection.close();

		} catch (Exception e) {

		}
		return newid;
	}
	
	public int newSymptom(Symptom s) {

		String query = "INSERT INTO  PatientSymptomHistory(sid,sname, startdate, enddate) values(?,?,?,?)";
		int newid = 0;
		try {
			dbConnection = openConnection();
			preparedStatement = dbConnection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, s.symptomName);
			preparedStatement.setString(2, s.startDate);
			preparedStatement.setString(3, s.endDate);
			
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				newid = rs.getInt(1);
			}
			dbConnection.close();

		} catch (Exception e) {

		}
		return newid;
	}
	
	public int newCondition(Condition c) {

		String query = "INSERT INTO  PatientConditionHistory(cid,cname, startdate, enddate) values(?,?,?,?)";
		int newid = 0;
		try {
			dbConnection = openConnection();
			preparedStatement = dbConnection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, c.conditionName);
			preparedStatement.setString(2, c.startDate);
			preparedStatement.setString(3, c.endDate);
			
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				newid = rs.getInt(1);
			}
			dbConnection.close();

		} catch (Exception e) {

		}
		return newid;
	}
	
	public int newTreatment(Treatment t) {

		String query = "INSERT INTO  PatientTreatmentHistory(tid,tname, startdate, enddate) values(?,?,?,?)";
		int newid = 0;
		try {
			dbConnection = openConnection();
			preparedStatement = dbConnection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.treatmentName);
			preparedStatement.setString(2, t.startDate);
			preparedStatement.setString(3, t.endDate);
			
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				newid = rs.getInt(1);
			}
			dbConnection.close();

		} catch (Exception e) {

		}
		return newid;
	}
	

	public TableModel getCFPatients() {
		TableModel pa = null;
		try {
			dbConnection = openConnection();
			String query = "select P.pid,P.fname,P.lname,P.age,P.email,P.gender "
					+ "from Patients P,patientsymptomhistory PSH1, Symptoms S1 "
					+ "where P.pid=PSH1.pid and PSH1.sid=S1.sid "
					+ "and S1.sname=? and PSH1.enddate is null "
					+ "and  PSH1.pid in (select psh2.pid from patientsymptomhistory PSH2, Symptoms S2 "
					+ "where PSH2.sid=S2.sid and S2.sname=? "
					+ "and PSH2.enddate is null)";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, "Cough");
			preparedStatement.setString(2, "Fatigue");

			ResultSet rs = preparedStatement.executeQuery();

			pa = buildTableModel(rs);
			dbConnection.close();

		} catch (Exception e) {

		} finally {

		}
		return pa;

	}

	public TableModel getPrevDiabetes() {
		TableModel pa = null;
		try {
			dbConnection = openConnection();
			String query = "SELECT  P.pid, P.fname, P.lname, P.age, P.gender, P.email "
					+ "FROM Patients P, patientconditionhistory PCH "
					+ "WHERE P.pid = PCH.pid AND PCH.cid IN (SELECT cid "
					+ "FROM Conditions WHERE cname = ?) AND PCH.enddate IS NOT NULL "
					+ "AND P.pid NOT IN (SELECT pid FROM patientconditionhistory "
					+ "WHERE cid IN (SELECT cid FROM  Conditions WHERE cname = ?) AND enddate IS NULL)";

			preparedStatement = dbConnection.prepareStatement(query);

			preparedStatement.setString(1, "Diabetes");
			preparedStatement.setString(2, "Diabetes");
			ResultSet rs = preparedStatement.executeQuery();

			pa = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return pa;

	}

	public TableModel getSecondOldestPerson() {
		TableModel pa = null;
		try {
			dbConnection = openConnection();
			String query = "SELECT P.pid,P.fname,P.lname,P.age, P.email,P.gender "
					+ "FROM patients  P "
					+ "	WHERE 1 = ( SELECT count(age) "
					+ " FROM patients b WHERE b.age > P.age)";

			preparedStatement = dbConnection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			pa = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return pa;

	}

	public TableModel getMaxSenderForId(int id) {
		TableModel pa = null;
		try {
			dbConnection = openConnection();
			String query = "SELECT P.pid,P.fname,P.lname,P.age, P.email,P.gender "
					+ "FROM Patients P,Messages M "
					+ "WHERE P.pid= M.sender AND receiver=? "
					+ "GROUP BY sender "
					+ "HAVING COUNT(*) = (SELECT MAX(A.maxSend) FROM "
					+ "(SELECT sender,COUNT(*) AS maxSend "
					+ "FROM Messages "
					+ "WHERE receiver=? " + "GROUP BY sender) AS A)";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, id);
			ResultSet rs = preparedStatement.executeQuery();
		

			pa = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return pa;
	}

	public TableModel nonSenderPT() {

		TableModel pa = null;
		try {
			dbConnection = openConnection();
			String query = " select DISTINCT P.pid,P.fname,P.lname,P.age, P.email,P.gender "
					+ "from Patients p, patienttreatmenthistory pth "
					+ "where p.pid=pth.pid and tid in "
					+ "(select tid from treatments where tname=?) "
					+ "and p.pid not in (select sender from Messages) ";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, "Physical Therapy");
			ResultSet rs = preparedStatement.executeQuery();
			pa = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return pa;
	}

	public TableModel FemaleSenders() {
		TableModel pa = null;
		try {
			dbConnection = openConnection();
			String query = " SELECT  DISTINCT P.pid,P.fname,P.lname,P.age,P.email,P.gender "
					+ "FROM Patients P, Messages M "
					+ "WHERE P.pid = M.sender AND P.gender=? "
					+ "AND M.receiver IN (SELECT pid FROM patientconditionhistory "
					+ "WHERE cid IN (SELECT cid FROM conditions WHERE cname=?) "
					+ "AND enddate IS NULL)";
			preparedStatement = dbConnection.prepareStatement(query);

			preparedStatement.setString(1, "F");
			preparedStatement.setString(2, "Diabetes");
			ResultSet rs = preparedStatement.executeQuery();
			pa = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return pa;
	}

	public TableModel editPatientData(int pedata) {
		TableModel ep = null;
		try {
			dbConnection = openConnection();
			String query = "SELECT P.pid,P.fname,P.lname,P.age, P.email,P.gender "
					+ "FROM Patients P "
					+ "WHERE P.pid=? ";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, pedata);
			ResultSet rs = preparedStatement.executeQuery();
		

			ep = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return ep;
	}
	
	public TableModel editSymptomData(int pedata) {
		TableModel ep = null;
		try {
			dbConnection = openConnection();
			String query = "SELECT SH.pid, S.sname, SH.startdate, SH.enddate "
					+ "FROM PatientSymptomHistory SH, symptoms S "
					+ "WHERE SH.sid=S.sid and SH.pid=? ";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, pedata);
			ResultSet rs = preparedStatement.executeQuery();
		

			ep = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return ep;
	}
	
	public TableModel editConditionData(int pedata) {
		TableModel ep = null;
		try {
			dbConnection = openConnection();
			String query = "SELECT CH.pid, C.cname, CH.startdate, CH.enddate "
					+ "FROM PatientConditionHistory CH, Conditions C "
					+ "WHERE CH.cid=C.Cid and CH.pid=? ";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, pedata);
			ResultSet rs = preparedStatement.executeQuery();
		

			ep = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return ep;
	}
	
	public TableModel editTreatmentData(int pedata) {
		TableModel ep = null;
		try {
			dbConnection = openConnection();
			String query = "SELECT TH.pid, T.tname, TH.startdate, TH.enddate "
					+ "FROM patienttreatmenthistory TH, Treatments T "
					+ "WHERE TH.tid=T.tid and TH.pid=? ";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, pedata);
			ResultSet rs = preparedStatement.executeQuery();
		

			ep = buildTableModel(rs);
			dbConnection.close();
		} catch (Exception e) {

		} finally {

		}
		return ep;
	}


}
