public class Account{
    private String id;
    private String name;
    private Integer balance;

    Account(String id, String name){
        this.id=id;
        this.name=name;
    }
    Account(String id, String name,Integer balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }
    public String getID(){
        return this.id;
    }
    public void setID(String id){
        this.id=id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Integer getBalance(){
        return this.balance;
    }
    public void setBalance(Integer balance){
        this.balance=balance;
    }
    public Integer credit(Integer amount){
        return this.balance+=amount;
    }
    public Integer debit(Integer amount){
        if(amount > balance){
            System.out.println("Low Balance!");
            return this.balance;
        }
        else{
            this.balance-=amount;
            return this.balance;
        }   
    }
    public Integer transferTo(Account acc,Integer amount){
        if(amount>this.balance){
            return null;
        }
        else{
            this.balance-=amount;
            acc.balance+=amount;
            return this.balance;
        }
    }

    @Override
    public String toString(){
        return "Account [id = "+this.id+", name = "+this.name+", balance = "+this.balance+"]";
    }
}