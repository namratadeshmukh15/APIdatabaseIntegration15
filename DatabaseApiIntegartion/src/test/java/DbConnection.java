

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbConnection {

	private static List<Map<String,Object>> executeQuery(String restdb_url,String query) throws SQLException {

		List<Map<String,Object>> resultList= new ArrayList<Map<String,Object>>();
		String username = DatabaseCreds.db_username;
		String password= DatabaseCreds.db_password;
		Connection con= DriverManager.getConnection(restdb_url,username,password);
		Statement stmt = con.createStatement();
		ResultSet resultSet= stmt.executeQuery(DatabaseCreds.query);
		ResultSetMetaData rsmd= resultSet.getMetaData();
		int columnCount= resultSet.getMetaData().getColumnCount();
		while (resultSet.next()) {
			Map<String,Object> resultMap= new HashMap<String,Object>();
			for(int i= 1;i<=columnCount;i++) {
				resultMap.put(rsmd.getColumnName(i),resultSet.getString(i));
			}
			resultList.add(resultMap);
		}
		return resultList;
	}
	public static List<PojoClass> getRecordDetails(String restdb_url,String query) throws SQLException{

		List<Map<String,Object>> resultList= executeQuery(DatabaseCreds.db_url,DatabaseCreds.query);
		List<PojoClass> txnList= new ArrayList<PojoClass>();

		for(Map<String, Object> resultMap: resultList) {
			PojoClass record = new PojoClass(((String) resultMap.get("empname")),
					((String) resultMap.get("empid")),
					((String) resultMap.get("EmpMailID")));
			txnList.add(record);
		}
		return txnList;
	}
}
