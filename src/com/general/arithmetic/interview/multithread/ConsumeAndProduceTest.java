package com.general.arithmetic.interview.multithread;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/******
 *
 * 利用wait与notify来写生产者消费者模型
 *
 * *****/
public class ConsumeAndProduceTest {

    private int size=10;
    private PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
    public static void main(String[] args){
        ConsumeAndProduceTest test=new ConsumeAndProduceTest();
        Consume consume=test.new Consume();
        Produce produce=test.new Produce();
        produce.start();
        consume.start();


    }



    class Consume extends Thread{
        @Override
        public void run() {
            super.run();
            consume();

        }
        private void consume(){
            while (true){
                synchronized (queue){
                    while(queue.size()==0){
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();//唤醒操纵是必须加的
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");

                }
            }

        }
    }
    class Produce extends Thread{
        @Override
        public void run() {
            super.run();
            produce();
        }
        private void produce(){
            while (true){
                synchronized (queue){
                    while (queue.size()==size){
                        try {
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();//唤醒操作是必须加的
                    System.out.println("向队列中插入一个元素，队列剩余空间："+(size-queue.size()));
                }
            }

        }
    }
}

