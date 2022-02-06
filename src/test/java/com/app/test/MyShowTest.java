package com.app.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.app.domain.Book;
public class MyShowTest {
   //Book(String id, String name, Integer price)
      Book book = new Book("JUIO987", "Java Designed pattern", 289);

    @Test
    @DisplayName("This is Junit testing fro Gradle")
    void testCase()
    {
        //Test will pass
        Assertions.assertNotEquals(3, book.getPrice());
        Assertions.assertEquals(289, book.getPrice());
        //Test will fail
        Assertions.assertNotEquals(book, new Book("ujy78","hsiw22", 2), "initial test failed");

        //Test will fail
        // Supplier&lt;String&gt; messageSupplier  = ()-> "calculator.add(2, 2) test failed";
        Assertions.assertNotEquals("C++ Test System", book.getName(), "The book name faile");

        //assertThrows(ArithmeticException.class, () -> calculator.divid(2, 0), "Divid by 0");
        //assertThrows(ArithmeticException.class, calculator.divid(1, 0)), "Divid by 0";
    }

}
