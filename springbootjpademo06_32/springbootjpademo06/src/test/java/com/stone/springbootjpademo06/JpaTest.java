package com.stone.springbootjpademo06;

import com.stone.springbootjpademo06.entity.BlueBook;
import com.stone.springbootjpademo06.entity.Book;
import com.stone.springbootjpademo06.entity.RedBook;
import com.stone.springbootjpademo06.repository.BookRepository;
import com.stone.springbootjpademo06.repository.RedBookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaTest {
    @Autowired
    private RedBookRepository redBookRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void redBookTest(){
        RedBook redBook = new RedBook();
        redBook.setTitle("redBook");
        redBook.setRedMark("redMark");
        RedBook save = redBookRepository.saveAndFlush(redBook);
        Optional<RedBook> redBook1 = redBookRepository.findById(save.getId());
        System.out.println(redBook1.get().getRedMark()+"\n"+redBook1.get().getTitle());
    }

    @Test
    public void bookTest(){
        BlueBook blueBook = new BlueBook();
        blueBook.setTitle("blueBook");
        blueBook.setBlueMark("blueMark");
        BlueBook save = bookRepository.saveAndFlush(blueBook);
        System.out.println(save.getId()+"\n"+save.getTitle()+"\n"+save.getBlueMark());

        //异常数据
        /*Book book = new Book();
        book.setTitle("bookbook");
        Book save = bookRepository.saveAndFlush(book);
        System.out.println(save.getId()+"\n"+save.getTitle());*/
    }
}
