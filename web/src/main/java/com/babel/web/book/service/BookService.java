package com.babel.web.book.service;

import com.babel.web.book.vo.AppointExecution;
import com.babel.web.book.po.Book;

import java.util.List;

/**
 * Created by allen on 2017/5/19.
 */
public interface BookService {

  /**
   * 查询一本图书
   * @param bookId
   * @return
   */
  Book getById(long bookId);

  /**
   * 查询所有图书
   * @return
   */
  List<Book> getList();

  /**
   * 预约图书
   * @param bookId
   * @param studentId
   * @return
   */
  AppointExecution appoint(long bookId, long studentId);

}
