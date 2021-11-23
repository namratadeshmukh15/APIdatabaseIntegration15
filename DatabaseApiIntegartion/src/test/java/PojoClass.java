
import java.util.Objects;

public class PojoClass {  // class should be public


	private String empname;
	private String empid;
	private String EmpMailID;


	// 1. must have public default constructor
	//	public PojoClass() {
	//
	//	}	
	// 2nd rule generete default constructor using field

	public PojoClass(String empname, String empid, String EmpMailID) {
		//super();
		this.empname = empname;
		this.empid = empid;
		this.EmpMailID = EmpMailID;
	}

	// 3.having public getter and setter method
	public String getempname() {
		return empname;
	}

	public void setempname(String empname) {
		this.empname = empname;
	}

	public String getempid() {
		return empid;
	}

	public void setempid(String empid) {
		this.empid = empid;
	}

	public String getEmpMailID() {
		return EmpMailID;
	}

	public void setEmpMailID(String EmpMailID) {
		this.EmpMailID = EmpMailID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		PojoClass other = (PojoClass) obj;
		return Objects.equals(empname, other.empname) && Objects.equals(empid, other.empid) && Objects.equals(EmpMailID,other.EmpMailID);
	}

	@Override
	public String toString() {
		return " \n empname=" + empname + ", empid=" + empid + ", EmpMailID=" + EmpMailID + " ";
	}
}


