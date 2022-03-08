package blog.integration;

import com.zlz.website.blog.WebsiteBlogServerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest(classes = WebsiteBlogServerApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DirtiesContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Slf4j
public class BaseTest {

    @BeforeClass
    public static void setUpBeforeClass() {
        log.info("run setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        log.info("run tearDownAfterClass");
    }

    @Test
    public void baseTest() {
        log.info("base test");
    }

}

