package Iterator.practice;


import java.net.DatagramSocketImplFactory;
import java.net.Inet4Address;
import java.util.List;
import java.util.NoSuchElementException;

interface Iterator<T>{
    boolean hasNext();
    T next();
}

interface Aggregate<T>{
    Iterator<T> create_iterator();
}

 class Book {
    String name ;
    Integer numberOfPages;

    public Book(String name , Integer numberOfPages){
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    Integer getNumberOfPages (){
        return this.numberOfPages;
    }
}


class BookIterator implements Iterator<Book>{
    int currentIndex = 0;
    private List<Book> BookList;


    BookIterator(List<Book> BookList){
        this.BookList = BookList;
    }

    @Override
    public boolean hasNext() {
       return currentIndex < BookList.size();
    }


    @Override
    public Book next(){
        if(hasNext()){
           return BookList.get(currentIndex++);
        }
        throw new NoSuchElementException();
    }

}

class Library implements Aggregate<Book>{
    private List<Book> BookList;

    Library(List<Book> BookList){
        this.BookList = BookList;
    }

    @Override
    public Iterator<Book> create_iterator(){
        return new BookIterator(this.BookList);
    }
}


public class Main {


}
