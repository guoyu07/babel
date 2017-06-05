import com.babel.platform.utils.GuidGenerator;
import com.babel.platform.utils.JsonUtil;
import com.babel.web.system.dao.MenuDao;
import com.babel.web.system.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:/spring/spring-web.xml",
    "classpath:/spring/spring-dao.xml",
    "classpath:/spring/spring-service.xml" })
public class MenuDaoTest extends BaseTest {

  @Autowired
  private MenuDao menuDao;

  @Test
  public void testAddMenu(){
    Menu menuPo = new Menu();
    menuPo.setGuid(GuidGenerator.newGuid());
    menuPo.setResourceGuid(GuidGenerator.newGuid());
    menuPo.setMenuIndex(1);
    menuPo.setIconClass("menu");
    menuPo.setMenuName("股票分析");

    menuDao.addMenu(menuPo);
  }

  @Test
  public void testQueryAllMenus(){
    List<Menu> allMenus = menuDao.queryAll();
    System.out.println(JsonUtil.objToString(allMenus));
  }

}
