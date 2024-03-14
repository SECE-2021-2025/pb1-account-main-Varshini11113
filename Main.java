import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String id,name;
        int choice;
        Integer balance;
        Account acc;
        int accid;
        System.out.println("Enter the number of accounts to create : ");
        n=Integer.parseInt(br.readLine());
        Account [] accarr = new Account[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the ID/ACCNO:");
            id = br.readLine();
            System.out.println("Enter the name:");
            name = br.readLine();
            System.out.println("Enter the balance");
            balance =  Integer.parseInt(br.readLine());
            acc=new Account(id,name,balance);
            accarr[i]=acc;
        }
        for(int i = 0; i<n; i++){
            System.out.println("Acc " + (i+1) + ":" + accarr[i].toString());
        }
        do{
            System.out.println("Enter your account : ");
            accid = Integer.parseInt(br.readLine());
            System.out.println("1) Credit");
            System.out.println("2) Debit");
            System.out.println("3) Transfer");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(br.readLine());
            if(choice<1 || choice>3){
                break;
            }
           
            switch(choice){
                
                case 1:
                    System.out.println("Enter the amount to be credited : ");
                    int amount = Integer.parseInt(br.readLine());
                    int cbal=accarr[accid-1].credit(amount);
                    System.out.println("Current balance after credit : "+cbal);
                    break;
                case 2:
                    System.out.println("Enter the amount to be debited : ");
                    int amt = Integer.parseInt(br.readLine());
                    int dbal=accarr[accid-1].debit(amt);
                    System.out.println("Current balance after debit : "+dbal);
                    break;
                case 3:
                    System.out.println("Enter the account to be transferred and the amount : ");
                    int taccid = Integer.parseInt(br.readLine());
                    int amtt = Integer.parseInt(br.readLine());
                    Integer bal=accarr[accid-1].transferTo(accarr[taccid-1],amtt);
                    if(bal != null){
                        System.out.println("Current balance : "+bal);
                    }
                    else{
                        System.out.println("Insufficient balance");
                    }
                    break;

            }
        }while(true);
        
    }
}