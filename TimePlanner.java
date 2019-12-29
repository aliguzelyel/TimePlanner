
public class TimePlanner {

	private static int users[][]; //a person's available times, 
	private static int[] theTimes; //the available times found after comparing
	private static int numPeople;
	
	public TimePlanner(int [][]newUsers, int newNumPeople) {
		users= newUsers;
		numPeople=newNumPeople;	
		theTimes= new int[numPeople];
	}

	
	public void findTimes(TimePlanner newInputUsers) {
	// the method is used only with 2n (2, 4, 6 etc.) people 
	//for now, people can only have 1 available time  (ex. from 1400 to 1600).	
	//method compares 2 people and gives the available time for them, then continues to the
	//next 2 people and compares them.
		
	//comparing the 2 found available times is not yet implemented, but planned.		
		if(numPeople>1) {
			for(int i=0; i<numPeople;i+=2) {
				int j=0;
				while(true) {
					if(users[i][j]==-1) break;
					if(users[i+1][j]<users[i][j+1]&&users[i][j+1]>users[i+1][j]) {
						if(users[i][j]>users[i+1][j]) theTimes[i]=users[i][j];					
						else theTimes[i]=users[i+1][j];
			//change theTimes[i] to sth else when people start inputting more than 1 available times.
						if(users[i][j+1]<users[i+1][j+1]) theTimes[i+1]=users[i][j+1];
						else  theTimes[i+1]=users[i+1][j+1];
						
					}	
					j+=2;
				}
			}
		}
		
	}
	
	public int[] getTheTimes(){
		return theTimes;
	}
	
	
	public  String toString(int[] theTimes) {
		String output="";
	/*	for(int i=0;i<users.length;i++) {
			int j=0;
			while(users[i][j]!=-1) {
			output+=users[i][j]+",";
			j++;
			}
			output+="\n";
		}
	*/	
//change toString method for theTimes when implementing people with multiple available times.		
		for(int i=0; i<theTimes.length;i++) {
			output+= theTimes[i]+",";			
		}
		return output;		
	}
		
	
}
