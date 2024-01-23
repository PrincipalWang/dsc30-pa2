/*
    Name: Chen Wang
    PID:  A17090044
 */

import java.util.EmptyStackException;
import utilities.FullStackException;

/**
 * MyStack Implementation
 * @author Chen Wang
 * @since 1/22/2024
 */
public class MyStack {


    String[] mysta;
    int size;
            
    /**
     * constructor of mystack
     * 
     * @param capacity capacity of mystack
     * @throws IllegalArgumentException  if capacity is out of valid range
     * */
    public MyStack(int capacity) throws IllegalArgumentException{
        if(capacity<1){
            throw new IllegalArgumentException();
        }
        mysta = new String[capacity];
        size = 0;
    }

    /**
     * empty constructor of mystack
     * */
    public MyStack() {
        mysta = new String[10];
        size = 0;
    }

    /**
     * check if mystack is empty
     *
     * @return empty or not
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * clear the stack
     * */
    public void clear() {
        for(int i = 0 ; i < mysta.length ; i++){
            mysta[i] = null;
        }
        size=0;
    }

    /**
     * get size of mystack
     *
     * @return size of mystack
     * */
    public int size() {
        return size;
    }

    /**
     * get capacity of mystack
     *
     * @return capacity of mystack
     * */
    public int capacity() {
        return mysta.length;
    }

    /**
     * return the top element in mystack
     *
     * @return the top element in mystack
     * @throws EmptyStackException if the stack is empty
     * */
    public String peek() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return mysta[size-1];
    }

    /**
     * push an element to mystack
     *
     * @param element element to be pushed
     * @throws FullStackException if the stack reaches full capacity
     * @throws IllegalArgumentException if element is null
     * */
    public void push(String element) throws FullStackException, IllegalArgumentException{
        if(element==null){
            throw new IllegalArgumentException();
        }
        if(size == mysta.length){
            throw new FullStackException("Your stack is full.");
        }
        mysta[size] = element;
        size++;
    }

    /**
     * pop an element from mystack
     *
     * @return element popped
     * @throws EmptyStackException if the stack is empty
     * */
    public String pop() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        String res = mysta[size-1];
        mysta[size-1] = null;
        size--;
        return res;
    }

    /**
     * push multiple elements at the same time
     *
     * @param elements elements to be pushed
     * @throws FullStackException once stack reaches full capacity.
     * @throws IllegalArgumentException if elements is null
     * */
    public void multiPush(String[] elements) throws FullStackException, IllegalArgumentException{
        for(String ele : elements){
            this.push(ele);
        }
    }

    /**
     * pop multiple elements at the same time
     *
     * @return elements popped
     * @throws IllegalArgumentException if amount is not a positive number
     * */
    public String[] multiPop(int amount) throws IllegalArgumentException{
        if(amount<=0){
            throw new IllegalArgumentException();
        }
        String[] res;
        if(amount>size){
            res = new String[size];
        }
        else{
            res = new String[amount];
        }
        for(int i = 0 ; i < res.length ; i++){
            res[i] = this.pop();
        }
        return res;
    }


}