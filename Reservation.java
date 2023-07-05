package Reservation;
import java.util.*;

public class Reservation{
	static Scanner Sc = new Scanner(System.in);
	
public static void main(String[] args)  {
	int total=0;

	
	ArrayList<reserv> alltickets = new ArrayList<reserv>(50);
			
		String user, pass;
		System.out.println("Login"); 
		System.out.println("Enter Username(admin):"); //admin
		user = Sc.next();
		System.out.println("Enter Password(123):"); //123
		pass = Sc.next();
		
		if(user.equals("admin") && pass.equals("123")) {
			
			System.out.println("Login succesfull..........");	
			int run=1;
			while(run==1) {
				int x;
				System.out.print("Press 1)To Book Ticket  2)TO Check detail of Ticket 3)Passenger List  0) EXIT");
				x = Sc.nextInt();
				String n,s,d,trname,trnnum,jrnydate;
				if(x==1) {
					System.out.print("Enter pessenger name : ");
					n= Sc.next();
					System.out.print("Enter Source : ");
					s = Sc.next();
					System.out.print("Enter Destination : ");
					d = Sc.next();
					System.out.print("Enter Train name : ");
					trname = Sc.next();
					System.out.print("Enter Train Number : ");
					trnnum = Sc.next();
					System.out.print("Enter Journey Date : ");
					jrnydate = Sc.next();
					
					reserv r = new reserv(n,s,d,trname,trnnum,jrnydate);
					alltickets.add(total,r);
					total++;
					System.out.print("Congratulations Your ticket Booked Succecfully \n Your PRN :  "+r.PRN+"\n" );


				}
				else if(x==2) {
					if(alltickets.isEmpty()) {
						System.out.println("No Ticket Booked ");
					
				}
					else {
						int i;
						String prn;
						System.out.print("Enter your PRN number : ");
						prn = Sc.next();
						int find=0,tcktnum=0;
						for(i = 0;i<total;i++) {
							if(alltickets.get(i).PRN.equals(prn)) {
								find =1;
								tcktnum = i;
								
							}
						}
						if(find==1) {
						
							int ch=10,flag=1;
							while(flag==1) {
							System.out.print("Press 1)To Print Ticket  2)Cancel Ticlet   0) Log Out ");
							ch = Sc.nextInt();							
							switch(ch) {
							case 1:
								alltickets.get(tcktnum).Ticket();
								break;
								
							case 2:
								System.out.print("1) Cancel Ticket  0) back ");
								int c=0;
								c = Sc.nextInt();
	
								
								if(c==0) {
									break;
								}
								else {
									alltickets.remove(tcktnum);
									System.out.println("Ticket Canclled Succefully");
									--total;
									flag=0;

								break;
								}
								
								
							case 0:
							 	flag=0;
							 	
							}
						}
					}
						else {
							System.out.println("Invalid PRN ");
						}
				}
			}
				
				else if(x==3) {
					
					if(alltickets.isEmpty()) {
						System.out.println("No Ticket Booked");
					}
					else {
					for(int j = 0;j<total;j++) {
						System.out.println(alltickets.get(j).name);
					}	
				}
				}
				else if (x==0) {
					run=0;
				}			
}
		}	
		else {
			System.out.println("Wrong Credential");
		}
	}

}


class reserv{
	String name, source,destination,trainname,trainnumber,jorneydate,PRN;
	reserv(String n,String s,String d,String trname,String trnnum,String jrnydate){
		name = n;
		source = s;
		destination = d;
		trainname  = trname;
		trainnumber = trnnum;
		jorneydate = jrnydate;
		PRN = trnnum+jrnydate;
	}
void Ticket() {
		System.out.println("PRN          : "+PRN);
		System.out.println("Name         : "+name);
		System.out.println("Source       : "+source);
		System.out.println("Destination  : "+destination);
		System.out.println("Trian Name   : "+trainname);
		System.out.println("Train Number : "+trainnumber);
		System.out.println("Journey Date : "+jorneydate);
	}
}

