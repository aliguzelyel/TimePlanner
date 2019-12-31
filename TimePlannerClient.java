import java.util.Scanner;
public class TimePlannerClient {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("how many people?");
		int numPeople = input.nextInt();
		int[][] users= new int[numPeople][1000];

		for(int i=0; i<numPeople;i++) {
			int j=0;
			System.out.println("new User");
			System.out.println("Write your available times in the format: start1, enter, end1, enter, start2, enter, end2 ...");
			System.out.println("write -1 if you are done.");
			while(true) {
				users[i][j]=input.nextInt();
				if(users[i][j]== -1)	break; //the last item of the array will be -1. in the other methods, 
											//when sees, the method will use it as "END" like in how tRNA sees it in RNA synthesis
				j++;		 
			}		
		}
		
		TimePlanner inputUsers = new TimePlanner(users, numPeople);
		
		inputUsers.arrangeArray(inputUsers);
		inputUsers.findTimes();
		System.out.println(inputUsers.outputTheTimes());
		System.out.println(inputUsers);
	}
}
