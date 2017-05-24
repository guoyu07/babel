import com.babel.platform.utils.GuidGenenator;
import com.babel.platform.utils.JsonUtil;
import com.babel.web.system.dao.MenuDao;
import com.babel.web.system.po.MenuPo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */
public class MenuDaoTest extends BaseTest {

  @Autowired
  private MenuDao menuDao;

  @Test
  public void testAddMenu(){
    MenuPo menuPo = new MenuPo();
    menuPo.setGuid(GuidGenenator.newGuid());
    menuPo.setActionGuid(GuidGenenator.newGuid());
    menuPo.setMenuIndex(1);
    menuPo.setIconClass("menu");
    menuPo.setMenuName("股票分析");

    menuDao.addMenu(menuPo);
  }

  @Test
  public void testQueryAllMenus(){
    List<MenuPo> allMenus = menuDao.queryAllMenus();
    System.out.println(JsonUtil.objToString(allMenus));
  }

}
