package com.general.arithmetic.practice;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.management.RuntimeErrorException;

/***
 * 
 * @author gongchao 题目：实现一种狗猫队列的结构，要求如下： .用户可以调用add方法将cat类或dog类的实例放入队列中
 *         .用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出。
 *         .用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
 *         .用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
 *         .用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例
 *         .用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例
 *         .用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
 */
/*书中说这种写法错误，说是cat和dog队列与总队列的更新问题,但是我认为这个其实就是多了一个队列的
 * 空间复杂度，而不是更新的相关问题，这种写法测试是通过的。*/
class DogAndCatQueue {
	private Queue<Pet> pets = new LinkedBlockingQueue<>();
	private Queue<Pet> dogs = new LinkedBlockingQueue<>();
	private Queue<Pet> cats = new LinkedBlockingQueue<>();

	public void add(Pet pet) {
		if (pet instanceof Dog) {
			dogs.add(pet);
		} else if (pet instanceof Cat) {
			cats.add(pet);
		}
		pets.add(pet);
	}

	public void pollAll() {
		while (!pets.isEmpty()) {
			System.out.println(pets.poll().getPetType());
		}
	}

	public void pollCat() {
		while (!cats.isEmpty()) {
			Cat cat = (Cat) cats.poll();
			pets.remove(cat);
			System.out.println(cat.getPetType());

		}

	}

	public void pollDog() {
		while (!dogs.isEmpty()) {
			Dog dog = (Dog) dogs.poll();
			pets.remove(dog);
			System.out.println(dog.getPetType());

		}

	}

	public boolean isEmpty() {
		return pets.isEmpty();
	}

	public boolean isDogEmpty() {
		return dogs.isEmpty();
	}

	public boolean isCatEmpty() {
		return cats.isEmpty();
	}

	public static void main(String[] args) {

		DogAndCatQueue dogAndCatQueue=new DogAndCatQueue();
		Dog dog=new Dog("dog0");
		dogAndCatQueue.add(dog);
		dogAndCatQueue.add(new Dog("dog1"));
		dogAndCatQueue.add(new Cat("cat1"));
		dogAndCatQueue.add(dog);
		dogAndCatQueue.add(new Dog("dog2"));
		dogAndCatQueue.add(new Cat("cat2"));
		dogAndCatQueue.add(new Dog("dog3"));
		dogAndCatQueue.add(new Cat("cat3"));
		dogAndCatQueue.add(new Dog("dog4"));
		dogAndCatQueue.add(new Cat("cat4"));
		dogAndCatQueue.add(new Dog("dog5"));
		dogAndCatQueue.add(new Cat("cat5"));
		dogAndCatQueue.add(new Dog("dog6"));
		dogAndCatQueue.add(new Cat("cat6"));
		
//		dogAndCatQueue.pollAll();
		dogAndCatQueue.pollDog();
		dogAndCatQueue.pollDog();
//		dogAndCatQueue.pollAll();
		System.out.println(dogAndCatQueue.isCatEmpty());
	}
}
 class DogCatQueue{
	private Queue<PetEnterQueue > dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;
	public DogCatQueue(){
		this.dogQ=new LinkedList<>();
		this.catQ=new LinkedList<>();
		this.count=0;
	}
	public void add(Pet pet){
		if(pet instanceof Dog){
			this.dogQ.add(new PetEnterQueue(pet, this.count++));
		}else if(pet instanceof Cat){
			this.catQ.add(new PetEnterQueue(pet, this.count++));
		}else{
			throw new RuntimeException("error, not dog or cat");
		}
	}
	public Pet pollAll(){
		if(!this.dogQ.isEmpty()&&!this.catQ.isEmpty()){
			if(this.dogQ.peek().getCount()<this.catQ.peek().getCount()){
				return this.dogQ.poll().getPet();
			}else{
				return this.catQ.poll().getPet();
			}
		}else if(!this.dogQ.isEmpty()){
			return this.dogQ.poll().getPet();
		}else if(!this.catQ.isEmpty()){
			return this.catQ.poll().getPet();
		}else{
			throw new RuntimeException("err,queue is empty");
		}
		
	}
	public  Dog pollDog(){
		if(!this.isDogQueueEmpty()){
			return (Dog) this.dogQ.poll().getPet();
		}else{
			throw new RuntimeException("Dog queue is empty!");
		}
	}
	public Cat pollCat(){
		if(!this.isCatQueueEmpty()){
			return (Cat) this.catQ.poll().getPet();
		}else {
			throw new RuntimeException("Cat queue is empty!");
		}
	}
	
	public boolean isEmpty(){
		return this.dogQ.isEmpty()&&this.catQ.isEmpty();
	}
	public boolean isDogQueueEmpty(){
		return this.dogQ.isEmpty();
	}
	public boolean isCatQueueEmpty(){
		return this.catQ.isEmpty();
	}
}
class PetEnterQueue{
	private Pet pet;
	private long count;
	public PetEnterQueue(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}
	public Pet getPet(){
		return this.pet;
	}
	public long getCount(){
		return this.count;
	}
	public String getEnterType(){
		return this.pet.getPetType();
	}
	
}


class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return this.type;
	}

}

class Dog extends Pet {

	public Dog(String type) {
		super(type);
	}

}

class Cat extends Pet {

	public Cat(String type) {
		super(type);
	}

}