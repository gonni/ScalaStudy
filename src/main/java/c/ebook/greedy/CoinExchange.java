package c.ebook.greedy;

public class CoinExchange {

    public static void main(String[] args) {
        int[] coins = {1,5,10,50,100,500,1000,5000,10000,50000};

        int targetMoney = 4200;
        int count = 0;
        for(int i = coins.length -1;i >=0; i--) {
            if(coins[i] <= targetMoney) {
                count += targetMoney / coins[i];
                targetMoney %= coins[i];
            }

            if(targetMoney == 0) break;
        }

        System.out.println("Count of Coins => " + count);
    }
}
