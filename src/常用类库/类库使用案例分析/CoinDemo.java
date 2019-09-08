package 常用类库.类库使用案例分析;

import java.util.Random;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Coin { //模拟硬币扔的操作
    private int front;      //保存正面参数
    private int back;       //保存背面参数
    private Random random = new Random();

    /**
     * 扔硬币的处理
     *
     * @param num 扔硬币的执行次数
     */
    public void throwCoin(int num) {
        for (int i = 0; i < num; i++) {
            int temp = random.nextInt(2);
            if (temp == 0) {
                front++;
            } else {
                back++;
            }
        }
    }

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }
}

public class CoinDemo {
    public static void main(String[] args) {
        /*用0-1之间的随机数来模拟扔硬币的实验,统计扔1000次后出现正反两面的次数并输出*/
        Coin coin = new Coin();
        coin.throwCoin(1000);
        System.out.println("正面出现次数: " + coin.getFront());
        System.out.println("反面出现次数: " + coin.getBack());
    }
}
