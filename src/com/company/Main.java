package com.company;

public class Main {

    public static void main(String[] args) {
	    Iworker iworker = new Cook();
	    iworker.work();
	    iworker.eat();
	    iworker.work();
    }
}

// принцип мы не должны зависить от интерфейсов которые мы используем
// вот пример кода, котороый будет полным говно-кодом (так делать нельзя!)

// у нас 2 метода
/*
interface Iworker{
    void work();
    void eat();
}
 */

class Cook implements  Iworker{
    @Override
    public void work() {
        System.out.println("Cook work");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}

// А теперь у нас здесь есть не используемый метод
/*
class Waiter implements  Iworker{
    @Override
    public void work() {
        System.out.println("Waiter work");
    }

    @Override
    public void eat() {

    }
}
 */

// -------------------- исправляем
// переделаем интерфейсы

interface work{
    void work();
}

interface eat{
    void eat();
}

interface Iworker extends work, eat{}

// Теперь у нас здесь только используемый метод
class Waiter implements work{
    @Override
    public void work() {
        System.out.println("Waiter work");
    }
}