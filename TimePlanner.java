
public class TimePlanner {
	// the program can be used only with 2n (2, 4, 6 etc.) people 
	//people can have many available times  (ex. from 14 to 16 and 18 to 20).
	
	private static int users[][]; //a person's available times, 
	private static int[][] theTimes; //the available times found after comparing    {[0,1,0,0], [0,0,0,0]}
	private static int numPeople;
	private static int[] finalTimes=new int[25];
	private static int max=0;
	private static int maxClock=-1;
	private static String finalTimesOutput;
	private static int maxRepeat=0;
	
	public TimePlanner(int [][]newUsers, int newNumPeople) {
		users= newUsers;
		numPeople=newNumPeople;	
		theTimes= new int[numPeople][25];
		
	}

	public void arrangeArray (TimePlanner newInputUsers) {
		int time=0;
		for(int i=0; i<numPeople;i++) {
			int j=0;
			while(users[i][j]!=-1 && time!=25) {
				//the input will be like 5, 10 start from 5, and repeat to add one  10-5 times
				if(users[i][j]==time) {
					int repeat =users[i][j+1]-users[i][j];
					for(int k=time; k<repeat+time;k++)
					theTimes[i][k]++;
					j+=2;
				}
				time++;
			}
			time=0;
		}		
	}
	
	public void findTimes() {		
		for(int i=0; i<numPeople; i++) {
			for(int j=0; j<24;j++) {
				finalTimes[j]+=theTimes[i][j];
			}	
		}		
		for(int i=0; i<24;i++) {
			if(finalTimes[i]>max) {
				max=finalTimes[i];
				maxClock=i;
			}	
		}		
		for(int i=0; i<23;i++) {
			if(finalTimes[i]==max) {
				while(finalTimes[i+1]==max) {
					maxRepeat++;
					i++;
				}				
			}			
		}
	}
	
	public String outputTheTimes(){
		String finalTimesOutput="["; 
		for(int i=0; i<23; i++) {
			finalTimesOutput+=finalTimes[i]+",";			
		}
		finalTimesOutput+=finalTimes[23]+"]";
		return finalTimesOutput;
	}
	
	public  String toString() {
		String output="";
		output+="Your time table is like this."+"\n"+"The best time for meet-ups is:\n"+maxClock+"-"+(maxClock+maxRepeat+1)+" as "+max+" out of "+numPeople+" people are available at that time";
		
		return output;
	}
}
