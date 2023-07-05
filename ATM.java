package ATM;
import java.util.*;

public class ATM {

	static Scanner Sc = new Scanner(System.in);
	
public static void main(String[] args)  {
	int tr = 0,total=0;

	ArrayList<account> userlist = new ArrayList<account>(50);
			
		String user, pass;
		System.out.println("Enter Username(admin):"); //admin
		user = Sc.next();
		System.out.println("Enter Password(123):"); //123
		pass = Sc.next();
		
		if(user.equals("admin") && pass.equals("123")) {
			
			System.out.println("Login succesfull..........");	
			int run=1;
			while(run==1) {
				int x;
				System.out.print("Press 1)Create new Account  2) Log In  0) EXIT");
				x = Sc.nextInt();
				String n,b,dob,p;
				if(x==1) {
					System.out.print("Enter name : ");
					n = Sc.next();
					System.out.print("Enter PIN : ");
					p = Sc.next();
					System.out.print("Enter Bank name : ");
					b = Sc.next();
					System.out.print("Enter DOB (DDMMYYYY) : ");
					dob = Sc.next();

					
					account u = new account(n,b,dob,p);
					userlist.add(total,u);
					total++;
				}
				else if(x==2) {
					if(userlist.isEmpty()) {
						System.out.println("No user Found ");
					
				}
					else {
						int i;
						String name,pin;
						System.out.print("Enter name : ");
						name = Sc.next();
						System.out.print("Enter pin : ");
						pin = Sc.next();
						int find=0,usernumber=0;
						for(i = 0;i<total;i++) {
							if(userlist.get(i).name.equals(name)  && userlist.get(i).pin.equals(pin)  ) {
								find =1;
								usernumber = i;
								
							}
						}
						if(find==1) {
						
							int ch=10,flag=1;
							while(flag==1) {
							System.out.print("Press 1)Transaction History  2) Deposite  3)Withdraw  4) Transfer 5) Account Detail   0) Log Out ");

							ch = Sc.nextInt();

							
							switch(ch) {
							case 1:
								
								userlist.get(usernumber).transhistory();
								break;
								
							case 2:
								System.out.print("Enter Amout to be Deposite OR  press 0 to Exit : ");
								int amt=0;
								amt = Sc.nextInt();
	
								
								if(amt==0) {
									break;
								}
								else {
									userlist.get(usernumber).creadit(amt);

								break;
								}
								
							case 3:
								System.out.print("Enter Amout to be Withdraw   OR  Press 0 to Exit : ");
								amt =0;

									amt = Sc.nextInt();
								if(amt==0) {
									break;
								}
								else {
								userlist.get(usernumber).debit(amt);

								break;
								}
								
								
							case 4:
								int receiver;
								System.out.println("Select Receiver : ");
								for(int j=0;j<total;j++) {
									System.out.print(j+1+" ");
									System.out.println(userlist.get(j).name);
								}
								receiver = Sc.nextInt();
								receiver = receiver - 1;
								
								System.out.println("Enter Amount to be Send : ");
								int amount ;
								amount = Sc.nextInt();
								
								userlist.get(usernumber).debit(amount);
								System.out.println(" from "+ userlist.get(usernumber).name );
								userlist.get(receiver).creadit(amount);		
								System.out.println(" To "+ userlist.get(receiver).name );
								break;
								
							case 5:
								userlist.get(usernumber).display();
								break;
								
							case 0:
							 	flag=0;
							 	
							}
						}
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


class account{
	ArrayList<String> t = new ArrayList<String>(25);
	int tr=0;
	String name,bank,DOB,pin;
	int bal;
	account(String n,String b,String dob,String p){
		name=n;
		bank=b;
		DOB=dob;
		pin = p;	
	}
void display() {
		System.out.println("Name          : "+name);
		System.out.println("Bank name     : "+bank);
		System.out.println("DOB(DDMMYYYY) : "+DOB);
		System.out.println("Avl Balance   : "+bal);
	}


void creadit(int amt){
		bal = bal + amt;
		System.out.println(amt+" Rs Creadited  ");
		t.add(tr,amt+" Rs Creadited / Balance: "+ bal );
		tr++;
		
	}
void debit(int amt){
		bal =bal - amt;
		System.out.println(amt+" Rs Debited ");
		t.add(tr,amt+" Rs Debited / Balance: "+ bal);
		tr++;
	}

void	balance(){
		System.out.println("Balance "+bal);
	}

void transhistory() {
	for(int j=0;j<tr;j++) {
		System.out.println(t.get(j));
	}
}
}
