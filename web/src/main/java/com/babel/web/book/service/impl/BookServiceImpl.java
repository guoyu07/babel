package com.babel.web.book.service.impl;

import com.babel.web.book.dao.AppointmentDao;
import com.babel.web.book.dao.BookDao;
import com.babel.web.book.vo.AppointExecution;
import com.babel.web.book.po.Appointment;
import com.babel.web.book.po.Book;
import com.babel.web.book.enums.AppointStateEnum;
import com.babel.web.book.exception.AppointException;
import com.babel.web.book.exception.NoNumberException;
import com.babel.web.book.exception.RepeatAppointException;
import com.babel.web.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by allen on 2017/5/19.
 */
@Service
public class BookServiceImpl implements BookService {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  //注入service依赖
  @Autowired
  private BookDao bookDao;

  @Autowired
  private AppointmentDao appointmentDao;


  public Book getById(long bookId) {
    return bookDao.queryById(bookId);
  }

  public List<Book> getList() {
    return bookDao.queryAll(0,1000);
  }

  @Transactional
  public AppointExecution appoint(long bookId, long studentId) {
    try {
      //减库存
      int update = bookDao.reduceNumber(bookId);
      if(update <= 0){//库存不足
        throw new NoNumberException("no number");
      }else{
        //执行预约操作
        int insert = appointmentDao.insertAppointment(bookId,studentId);
        if(insert <= 0){
          throw new RepeatAppointException("repeat appoint");
        } else { //预约成功
          Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);
          return new AppointExecution(bookId, AppointStateEnum.SUCCESS,appointment);
        }
      }
      //要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException，导致控制层无法具体识别是哪个异常
    }catch (NoNumberException e1){
      throw e1;
    } catch (RepeatAppointException e2){
      throw e2;
    } catch (Exception e){
      logger.error(e.getMessage(), e);
      throw new AppointException("appoint inner error:" + e.getMessage());
    }
  }
}
