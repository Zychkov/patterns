package ru.zychkov.concurrency.producerconsumer.example1;

import java.util.LinkedList;


public class ProducerConsumerMain {

    public static void main(String[] args) throws InterruptedException {

        // Объект класса, который имеет обоих продуктов () и потреблять () методы
        final PC pc = new PC();

        // Создать ветку производителя
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Создать потребительский поток
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаем оба потока
        t1.start();
        t2.start();

        // t1 заканчивается до t2
        t1.join();
        t2.join();
    }

    // Этот класс имеет список, производитель (добавляет элементы в список) и consumer (удаляет элементы).
    public static class PC {

        // Создать список для общего доступа производителя и потребителя
        // Размер списка 2.

        LinkedList<Integer> list = new LinkedList<>();

        int capacity = 2;

        // Функция вызывается потоком производителя
        public void produce() throws InterruptedException {
            int value = 0;

            while (true) {
                synchronized (this) {
                    // поток производителя ждет пока список полон
                    while (list.size() == capacity)
                        wait();

                    System.out.println("Producer produced-" + value);

                    // для вставки работ в список
                    list.add(value++);

                    // уведомляет потребительский поток, что теперь он может начать потреблять
                    notify();

                    // облегчает работу программы понять
                    Thread.sleep(1000);
                }
            }
        }

        // Функция вызывается потребительским потоком
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // потребительский поток ожидает пока список пустой
                    while (list.size() == 0)
                        wait();

                    // чтобы получить первое задание в списке
                    int val = list.removeFirst();

                    System.out.println("Consumer consumed-" + val);

                    // Разбудить ветку продюсера
                    notify();

                    // и спать
                    Thread.sleep(1000);
                }
            }
        }
    }
}