package 类集合框架.集合工具类;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Order{    //订单信息
    private String name;    //购买的商品的名称
    private double price;   //商品的单价
    private int amount;     //商品的数量

    public Order(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
public class MyMapReduceDemo {
    public static void main(String[] args) {
        //如果要想使用Stream进行分析处理,则一定要将全部分析的数据保存在集合之中
        List<Order> all = new ArrayList<>();
        all.add(new Order("小娃娃",9.9,10));
        all.add(new Order("电动变形金刚",999.9,2));
        all.add(new Order("笔记本电脑",8999.9,4));
        all.add(new Order("茶杯",2.9,200));
        all.add(new Order("电动茶具",112.9,100));
        //统计分析够爱商品之中带有电的产品,并且进行单价和数量的处理随后分析汇总
        DoubleSummaryStatistics statistics = all.stream().filter(order -> order.getName().contains("电"))
                .mapToDouble(value -> value.getPrice() * value.getAmount()).summaryStatistics();
        System.out.println("商品购买种类数量: " + statistics.getCount());
        System.out.println("商品购买总价: " + statistics.getSum());
        System.out.println("商品平均花费: " + statistics.getAverage());
        System.out.println("商品最高花费: " + statistics.getMax());
        System.out.println("商品最低花费: " + statistics.getMin());
    }
}
