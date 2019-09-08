package 常用类库.uuid;

import java.util.UUID;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyUUID {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(UUID.randomUUID());
        }
    }
}
