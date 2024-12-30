package java.com.demo.portal;

import com.demo.portal.config.RedisConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = RedisConfig.class)
class DemoPortalApplicationTests {

    @Autowired
    public RedisTemplate redisTemplate;

    @Test
    public void test() {
        while (true){

        }
    }

}
