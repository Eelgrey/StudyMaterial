import org.testng.Assert;
import org.testng.annotations.Test;
import components.ClassBody;
import io.restassured.path.json.JsonPath;

public class SumValidate {
	
	@Test
	public static void sumOfCourses() {
		JsonPath newPath= new JsonPath(ClassBody.getNestedJson());
		int count=newPath.getInt("courses.size()");
		int Pamt=0;
		for(int i=0;i<count;i++) {
			int amt=newPath.getInt("courses["+i+"].price");
			int copies=newPath.getInt("courses["+i+"].copies");
			Pamt=Pamt+(amt*copies);
		}	
		
		System.out.println("Purchase Amount :: "+Pamt);
		Assert.assertEquals(Pamt, newPath.getInt("dashboard.purchaseAmount"));
	}

}
