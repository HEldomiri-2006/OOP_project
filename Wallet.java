public class Wallet {
    private double balance;
    public boolean paid = false;
    public Wallet(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void pay(double price)
    {
        if(balance<price){
            System.out.println("not enough balance"+balance);
        }
        else
        {
        this.balance-=price;
        paid = true;
        }
        System.out.println("hdhhdhdhd");
    }

}
