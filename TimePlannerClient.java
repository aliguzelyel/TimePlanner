import java.util.Scanner;
public class TimePlannerClient {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		//try to make input in a array, with each item for each person 
		//and each person will have an array of time
		//have to define the range of the dimension
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
		
	//	System.out.println(inputUsers);
		
		inputUsers.findTimes(inputUsers);
		System.out.println(inputUsers.toString(inputUsers.getTheTimes()));
		//do methods on it to calculate the best time for meeting
	}
}
