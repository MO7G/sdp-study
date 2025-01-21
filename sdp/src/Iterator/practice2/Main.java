package Iterator.practice2;


import org.w3c.dom.html.HTMLTableColElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

interface Iterator<T>{
    boolean hasNext();
    T next();
}


interface Agreggate<T>{
    Iterator<T> create_iterator();
}



class Music{
    String title;
    String artist;
    int duration;

    Music(String title, String artist , int duration){
        this.artist = artist;
        this.duration = duration;
        this.title = title;
    }

    void play(){
        System.out.println("Playing the " + title + " Song");
    }

}

class MusicIterator implements Iterator<Music>{
    private List<Music> MusicList;
    int currentIndex = 0;
    MusicIterator(List<Music> musicList){
        this.MusicList = musicList;
    }


    @Override
    public boolean hasNext(){
        return currentIndex < MusicList.size();
    }

    @Override
    public Music next(){
        if(hasNext()){
            return MusicList.get(currentIndex++);

        }
        throw new NoSuchElementException();
    }
}


class Collection implements Agreggate<Music>{
    ArrayList<Music> ArrayList;
    Collection(ArrayList<Music> arraylist){
        this.ArrayList = arraylist;
    }


    @Override
    public Iterator<Music> create_iterator(){
        return new MusicIterator(this.ArrayList);
    }
}


public class Main {

    static public void main(String args[]){
        ArrayList<Music> myList = new ArrayList<>();
        myList.add(new Music("sunshine","mohamed",23));
        myList.add(new Music("blue light","ali",2));

        Collection myCollection = new Collection(myList);

       Iterator<Music> myIterator =  myCollection.create_iterator();
       while(myIterator.hasNext()){
           myIterator.next().play();
       }

    }
}
