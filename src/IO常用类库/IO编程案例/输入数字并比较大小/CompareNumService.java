package IO常用类库.IO编程案例.输入数字并比较大小;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class CompareNumService implements ICompareNumService {
    @Override
    public int[] stat(int count) {
        int result[] = new int[2];  //定义返回的结果
        int data[] = new int[count];   //开辟一个数组
        for (int i = 0; i < data.length; i++) {
            data[i] = NumInputUtil.getInt("请输入第" + (i + 1) + "个数据: ");
        }
        result[0] = data[0];
        result[1] = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > result[0]) {
                result[0] = data[i];
            }
            if(data[i] < result[1]){
                result[1] = data[i];
            }
        }
        return result;
    }
}
