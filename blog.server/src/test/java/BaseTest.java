import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * @author zhulinzhong
 * @date 2022-03-08 16:31:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DirtiesContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Slf4j
public class BaseTest {

    @BeforeClass
    public static void setUpBeforeClass(){
        log.info("run setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        log.info("run tearDownAfterClass");
    }

    @Test
    public void baseTest(){
        log.info("base test");
    }

}
