package vishal.amaze.qa.utility;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.codoid.products.exception.FilloException;

import vishal.amaze.qa.base.TestBase;

public class FilloReader extends TestBase {
	
	public void getFilodata() throws FilloException {
	
	//"C:\Amazontestdata.xlsx"
	
	Fillo fil = new Fillo();//Fillo is a class here and we created an object of the same.
	
	Connection connection = fil.getConnection("C:\\Users\\DELL\\workspace\\MahabharatAll\\src\\test\\java\\inputFiles\\Amazontestdata.xlsx");

	String strq= "Select * from AmzAddAddress";
	
	Recordset rs = connection.executeQuery(strq);
	
	while(rs.next())
	{
		System.out.println("Bhai sahab Filo se read ho raha hai");
		System.out.println(rs.getField("FullName"));
	}
   rs.close();
   connection.close();
}

}
