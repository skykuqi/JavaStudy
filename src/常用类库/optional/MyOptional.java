package 常用类库.optional;

import java.util.Optional;

/**
 * @author : S K Y
 * @version :0.0.1
 */
interface IMessage{
    public String getContent();
}
class MessageImpl implements IMessage{
    @Override
    public String getContent() {
        return "test";
    }
}
class MessageUtil{
    public static Optional<IMessage> getMessage(){
        //次操作不允许对象为空,如果未空,则会在此处出现异常
        return Optional.ofNullable(null);  //有对象
    }
    public static void useMessage(IMessage msg){
        if(msg == null){
            System.out.println("对象为空");
        }else {
            System.out.println(msg.getContent());
        }
    }
}
public class MyOptional {
    public static void main(String[] args) {
        IMessage iMessage = MessageUtil.getMessage().orElse(new MessageImpl());
        MessageUtil.useMessage(iMessage);
    }
}
