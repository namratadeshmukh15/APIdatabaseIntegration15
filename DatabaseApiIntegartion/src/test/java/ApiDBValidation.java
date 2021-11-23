

import java.sql.SQLException;

import java.util.List;

public class ApiDBValidation {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		List<PojoClass> ApiUserList= JsonArrayToListConversion.getUserDetails();
		System.out.println("\n User details from API" +ApiUserList);
		int listSize= ApiUserList.size();
		System.out.println("\n User details list size:" +listSize);


		List<PojoClass> recordsDBList = DbConnection.getRecordDetails(DatabaseCreds.db_url,DatabaseCreds.query);
		System.out.println("\n Record details from DB" +recordsDBList);
		int listSize1= recordsDBList.size();
		System.out.println("\n User details list size:" +listSize1);

		if(ApiUserList.size()==recordsDBList.size())
		{
			int i;
			for ( i=0;i<ApiUserList.size();i++)
			{
				if(ApiUserList.get(i).equals(recordsDBList.get(i))) {

					System.out.println(" \n API matches with Database on  " +i+ " row" );
				}
				else{

					System.out.println(" \n API doesn't matches with Database on  " +i+ " row" );

				}
			}

		}
	}
}

