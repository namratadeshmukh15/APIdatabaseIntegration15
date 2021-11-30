

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.Object;
//import io.restassured.common.mapper.TypeRef<T>;

import groovyjarjarasm.asm.TypeReference;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class JsonArrayToListConversion {



	public static List<PojoClass> getUserDetails() {


		List<Map<String,Object>> allUsers= RestAssured.get("https://run.mocky.io/v3/dce17f3c-2169-45e0-b3d4-62e47e1bb25a")
				.as(new TypeRef<List<Map<String,Object>>>() {});

		List<PojoClass> userList= new ArrayList<PojoClass>();

		for(Map<String, Object> alluser: allUsers) {

			PojoClass record = new PojoClass(((String) alluser.get("empname")),
					((String) alluser.get("empid")),
					((String) alluser.get("EmpMailID")));
			userList.add(record);
		}
		return userList;
	}
}

