import com.msr.APP;
import com.msr.entity.User;
import com.msr.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
public class MyBatisTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //userMapper.selectList(null);
        //User user = new User();
        //user.setId(6);
        //user.setUsername("test123");
        //userMapper.insert(user);
        //userMapper.updateById(user);
        userMapper.deleteById(6);
    }
}
