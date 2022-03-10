package blog.mock;

import com.zlz.basic.utils.SnowWorker;
import org.junit.Test;

import java.util.UUID;

/**
 * @author zhulinzhong
 * @date 2022-03-08 20:44:48
 */
public class MockTest {

    @Test
    public void test(){
        SnowWorker snowWorker = new SnowWorker();
        for (int i = 0; i < 100; i++) {
            System.out.println(snowWorker.nextId());
        }
    }

    @Test
    public void test2(){
        System.out.println(UUID.randomUUID());
    }
}
