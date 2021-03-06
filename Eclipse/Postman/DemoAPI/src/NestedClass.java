import components.ClassBody;
import io.restassured.path.json.JsonPath;

public class NestedClass {

	public static void main(String[] args) {
		
		JsonPath newPath= new JsonPath(ClassBody.getNestedJson());
		// return no. of courses in API
		int count=newPath.getInt("courses.size()");
		System.out.println("No. of courses offered :: "+ count);
		
		//pint purchase amount
		String amt=newPath.getString("dashboard.purchaseAmount");
		System.out.println("Purchase Amount :: "+amt);
		
		//Print Title of the first course
			String title=newPath.getString("courses[0].title");
			System.out.println("Title of the first course :: " + title);
			
		//All course titles and their respective Prices	
		for(int i=0;i<count;i++) {
			System.out.println("Title :: "+ newPath.getString("courses["+i+"].title"));
			System.out.println("Price :: "+ newPath.getString("courses["+i+"].price"));
		}
		
		//no. of copies sold by RPA
		for(int i=0;i<count;i++) {
			if(newPath.getString("courses["+i+"].title").equalsIgnoreCase("RPA")) {
				System.out.println("No. of copies sold by RPA :: "+ newPath.getString("courses["+i+"].copies"));
			}
		}
		
		//verify sum
		
	}

}
