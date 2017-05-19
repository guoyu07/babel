import com.babel.web.book.dto.AppointExecution;
import com.babel.web.book.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by allen on 2017/5/19.
 */
public class BookServiceImplTest extends BaseTest {

  @Autowired
  private BookService bookService;

  @Test
  public void testAppoint() throws Exception{
    long bookId = 1001;
    long studentId = 12345678910L;
    AppointExecution execution = bookService.appoint(bookId,studentId);
    System.out.println(execution);
  }


}
