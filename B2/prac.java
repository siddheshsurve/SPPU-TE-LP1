
import java.util.Scanner;

class fcfs{
    int sum=0;
    float total_tt=0,total_waiting=0,avgTatFcfs=0,avgWtFcfs=0;
    public void exeFCFS(int n,int[] arrival,int[] bt,int[] compT,int[] turntt,int[] wait,int[] process){
    	
        for(int i=0;i<n;i++){
            sum=sum+bt[i];
            compT[i]=sum;
        }
        
        for(int i=0;i<n;i++)
        {
            turntt[i]=compT[i]-arrival[i];
            total_tt=total_tt+turntt[i];
            wait[i]=turntt[i]-bt[i];
            total_waiting+=wait[i];
        }
          
        System.out.println("\n\nProcess\t\tAT\tCPU_T");
        for(int i=0;i<n;i++)
        {
            System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+bt[i]);
        }
          
        System.out.println("\n\n");
        System.out.println("Total turn around time is : "+(total_tt/n));
        System.out.println("Total waiting time is : "+(total_waiting/n));
        avgTatFcfs = total_tt/n;
        avgWtFcfs = total_waiting/n;
    }
};

class sjf {
    int n,sum=0;
    float total_tt=0,total_waiting=0,avgTatSjf=0,avgWtSjf=0;
    public void exeSJF(int n,int[] arrival,int[] bt,int[] compT,int[] turntt,int[] wait,int[] process){
    	for(int i=0;i<n-1;i++)
        {
        	for(int j=i+1;j<n;j++)
           	{
               	if(bt[i]>bt[j])
               	{
                   	int temp=bt[i];
                   	bt[i]=bt[j];
                   	bt[j]=temp;
                                
                   	temp=arrival[i];
                   	arrival[i]=arrival[j];
                   	arrival[j]=temp;
                                
                   	temp=process[i];
                   	process[i]=process[j];
                   	process[j]=temp;
               	}
            }
          }

    	for(int i=0;i<n;i++)
        {
          sum=sum+bt[i];
          compT[i]=sum;
        }
          
		for(int i=0;i<n;i++)
		{
			turntt[i]=compT[i]-arrival[i];
			total_tt=total_tt+turntt[i];
			wait[i]=turntt[i]-bt[i];
			total_waiting+=wait[i];
		}
          
		System.out.println("\n\nProcess\t\tAT\tCPU_T");
		for(int i=0;i<n;i++)
		{
			System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+bt[i]);
		}
          
		System.out.println("\n\n");
		System.out.println("Total turn around time is : "+(total_tt/n));
		System.out.println("Total waiting time is : "+(total_waiting/n));
		avgTatSjf = total_tt/n;
		avgWtSjf = total_waiting/n;
    }
};

class Robin {
    int n,sum=0;
    float total_tt=0,total_waiting=0,avgTatSjf=0,avgWtSjf=0, avgTatRR=0, avgWtRR=0;
    public void exeRobin(int n,int[] arrival,int[] bt,int[] nbt, int seq[], int[] compT,int[] turntt,int[] wait,int[] process, int difference, int t_quantum, int temp_sum, int k){
        int tv=0;
        for(int i=0;i<n;i++){temp_sum=temp_sum+bt[i];}

        System.out.println("Process execution sequence : ");
          while(sum!=temp_sum){
		  for(int i=0;i<n;i++)
		  {
		  	if(nbt[i]<t_quantum)
		  		{
		  			difference=nbt[i];
		  			tv=nbt[i];
		  			nbt[i]=0;
		  		}
		  	else
		  		{
		  			difference = nbt[i]-t_quantum;
		  			tv=t_quantum;
		  			nbt[i]=difference;
		  		}
		  	if(tv > 0)
		  	{	
		        sum=sum+tv;
		        compT[k]=sum;
		        seq[k]=i;
		        System.out.print(seq[k]+1+" ");
		        
		        k++;
		        
		        }
		  }
          }

          System.out.println();
          for(int i=0;i<n;i++)
          {	
          	int carr=0,tt=0;
          	carr=arrival[i];
          	
          	for(int j=0;j<k;j++)
          	{
                	if(seq[j]==i)
                	{
                		tt=tt+(compT[j]-carr);
                		carr=compT[j];
                	}
                }
                
                turntt[i]=tt;
                System.out.println("Turn around time for "+(i+1)+" process : "+turntt[i]);
                total_tt=total_tt+turntt[i];
                
                wait[i]=turntt[i]-bt[i];
                
                System.out.println("Waiting time for "+(i+1)+" process : "+wait[i]);
                
                total_waiting+=wait[i];
          }
          
          System.out.println("\n\nProcess\t\tAT\tCPU_T");
          for(int i=0;i<n;i++)
          {
                System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+bt[i]);
          }
          
          System.out.println("\n\n");
          System.out.println("Total turn around time is : "+(total_tt/n));
          System.out.println("Total waiting time is : "+(total_waiting/n));
          avgTatRR = total_tt/n;
		  avgWtRR = total_waiting/n;          
    }
};

class Priority{
    int n,sum=0;
    float total_tt=0,total_waiting=0,avgTatPri=0,avgWtPri=0;
    public void exePriority(int n,int[] arrival,int[] bt, int[] pri,int[] compT,int[] turntt,int[] wait,int[] process){
        for(int i=0;i<n-1;i++)
          {
                for(int j=i+1;j<n;j++)
                {
                        if(pri[i]>pri[j])
                        {
                                int temp=bt[i];
                                bt[i]=bt[j];
                                bt[j]=temp;
                                
                                temp=process[i];
                                process[i]=process[j];
                                process[j]=temp;
                                
                                temp=pri[i];
                                pri[i]=pri[j];
                                pri[j]=temp;
                                
                                
                        }
                }
          }
          
          for(int i=0;i<n;i++)
          {
                sum=sum+bt[i];
                compT[i]=sum;
          }

          for(int i=0;i<n;i++)
          {
                turntt[i]=compT[i]-arrival[i];
                
                total_tt=total_tt+turntt[i];
                
                wait[i]=turntt[i]-bt[i];
                
                total_waiting+=wait[i];
          }
          
          System.out.println("\n\nProcess\t\tAT\tCPU_T");
          for(int i=0;i<n;i++)
          {
                System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+bt[i]);
          }
          
          System.out.println("\n\n");
          System.out.println("Total turn around time is : "+(total_tt/n));
          System.out.println("Total waiting time is : "+(total_waiting/n));
          avgTatPri = total_tt/n;
		  avgWtPri = total_waiting/n;
    }
};
public class prac{
    public static void main(String[] args) {
        int n;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the No. of processes : "); 
        n=s.nextInt();
        
        int arrival[]=new int[100];
        int bt[]=new int[100];
        int nbt[]=new int[100];
        int pri[]=new int[100];
        int compT[]=new int[100];
        int turntt[]=new int[100];
        int wait[]=new int[100];
        int process[]=new int[100];
        int t_quantum,difference=0,temp_sum=0,k=0;
        int seq[]=new int[100];
        
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter arrival time of "+(i+1)+" Process : ");
            arrival[i]=s.nextInt();
            System.out.println("Enter Burst time of "+(i+1)+" Process : ");
            nbt[i]=bt[i]=s.nextInt();
            System.out.println("Enter priority for "+(i+1)+" Process : ");
            pri[i]=s.nextInt();
            process[i]=i+1;
        }
        System.out.println("Enter time quantum : ");
        t_quantum = s.nextInt();
         
        // int tv=0;
        // for(int i=0;i<n;i++){temp_sum=temp_sum+bt[i];}

        fcfs fc = new fcfs();
        sjf sj = new sjf();
        Robin rr = new Robin();
        Priority pr = new Priority();
        
        System.out.println("FCFS Algorithm Result : ");
        fc.exeFCFS(n, arrival, bt, compT, turntt, wait, process);
        
        System.out.println("\n\nSJF Algorithm Result : ");
        sj.exeSJF(n, arrival, bt, compT, turntt, wait, process);
        
        System.out.println("\n\nRound Robin Result : ");
        rr.exeRobin(n, arrival, bt, nbt, seq, compT, turntt, wait, process, difference, t_quantum, temp_sum, k);

        System.out.println("\n\nPriority Algorithm Result : ");
        pr.exePriority(n, arrival, bt, pri, compT, turntt, wait, process);

       //Final Table
       System.out.println("\n\n\t\tAlgorithm Result");
       System.out.println("\n\tAlgoNo.\tAverage_TAT\tAverage_WT");
       float xy = fc.avgTatFcfs;
       float xz = fc.avgWtFcfs;
       float pq = sj.avgTatSjf;
       float qr = sj.avgWtSjf;
       float ab = rr.avgTatRR;
       float cd = rr.avgWtRR;
       float lm = pr.avgTatPri;
       float no = pr.avgWtPri;
       System.out.println("\n\t1.\t"+xy+"\t\t"+xz);
       System.out.println("\t2.\t"+pq+"\t\t"+qr);
       System.out.println("\t3.\t"+ab+"\t\t"+cd);
       System.out.println("\t4.\t"+lm+"\t\t"+no);

    }
}
 