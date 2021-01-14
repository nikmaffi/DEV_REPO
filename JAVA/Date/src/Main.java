import inputcli.InputCLI;

public class Main {
	public static void main(String[] args) {
		try {
			InputCLI userInput = new InputCLI();
			DateTime dt1;
			DateTime dt2;
			
			if(userInput.getString("Addition or subtraction? [add/sub] ").equals("add")) {
				dt1 = new DateTime(userInput.getInteger("\nDay: "), userInput.getInteger("Month: "), userInput.getInteger("Year: "));
				
				System.out.println("\nNew date: " + dt1.add(userInput.getInteger("\nInsert the number of days to add: ")).toString());
			} else {
				dt1 = new DateTime(userInput.getInteger("\nDay: "), userInput.getInteger("Month: "), userInput.getInteger("Year: "));
				dt2 = new DateTime(userInput.getInteger("\nDay: "), userInput.getInteger("Month: "), userInput.getInteger("Year: "));
				
				System.out.println("\nDays between " + dt1.toString() + " and " + dt2.toString() + " : " + dt1.sub(dt2));
			}
		} catch(Exception ex) {
			System.out.println("\n" + ex.getMessage());
		}
	}
}