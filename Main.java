package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        pablic wuw = new pablic();
        pablic pup = new pablic();
        pablic tut = new pablic();
        pablic rur = new pablic();

        User user1 = new User("Лелик");
        User user2 = new User("Болик");
        wuw.regObserver(user1);
        wuw.regObserver(user2);
        pup.regObserver(user1);
        pup.regObserver(user2);
        tut.regObserver(user1);
        tut.regObserver(user2);
        rur.regObserver(user2);

        wuw.setNews("кит покушав");
        System.out.println("\n");
        pup.setNews("кит проснувся");
        System.out.println("\n");
        tut.setNews("кит умывся");
        System.out.println("\n");
        rur.setNews("кит обидевся");
    }
}
interface Observable{ //интерфейс издателя
    void notifyObservers();
    void regObserver(Observer o);
}
interface Observer{ //интерфейс подписчика
    void update(String news);
}
class pablic implements Observable{
    List<Observer> list = new ArrayList<>();
    String news = "новость1";
    void setNews(String news){
        this.news = news;
        notifyObservers(); //уведомляет подписчиков
    }

    @Override
    public void notifyObservers() {
        for(Observer o: list){
            o.update(news); //обонвляет новость
        }
    }

    @Override
    public void regObserver(Observer o) {
        list.add(o); //подписываем пользователя
    }
}
class User implements Observer{
    String name;
    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String news) { //метод оповещения
        System.out.println(name + " оповещен о "+ news);
    }
}
