import com.doll.Application;
import com.doll.service.OrderService;
import com.doll.util.Results;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testOrder() {
        Results r = orderService.callBack("ac361ee4b411462bad6280eae2f44fd7","1e609521c7264d4986c09c61bd2dd875",2);
        System.out.println();
    }
}
