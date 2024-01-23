import utilities.FullStackException;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    @org.junit.jupiter.api.Test
    public void totalTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            MyStack myteststa = new MyStack(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            MyStack myteststa = new MyStack(-1);
        });
        MyStack myteststa1 = new MyStack(2);
        assertEquals(MyStack.class, myteststa1.getClass());
        MyStack myteststa2 = new MyStack();
        assertEquals(MyStack.class, myteststa2.getClass());
        MyStack myteststa3 = new MyStack();
        assertEquals(MyStack.class, myteststa3.getClass());
        MyStack myteststa4 = new MyStack();
        assertEquals(MyStack.class, myteststa4.getClass());
        assertTrue(myteststa1.isEmpty());
        assertTrue(myteststa2.isEmpty());
        assertTrue(myteststa3.isEmpty());
        assertEquals(2,myteststa1.capacity());
        assertEquals(10,myteststa2.capacity());
        assertEquals(10,myteststa3.capacity());
        assertThrows(EmptyStackException.class, ()->{
            myteststa1.pop();
        });
        assertThrows(IllegalArgumentException.class, ()->{
            myteststa1.push(null);
        });
        myteststa1.push("a");
        assertEquals("a",myteststa1.peek());
        assertEquals(1,myteststa1.size());
        myteststa1.push("b");
        assertEquals("b",myteststa1.peek());
        assertEquals(2,myteststa1.size());
        assertThrows(FullStackException.class, ()->{
            myteststa1.push("c");
        });
        assertThrows(FullStackException.class, ()->{
            myteststa1.push("d");
        });
        assertThrows(FullStackException.class, ()->{
            myteststa1.push("e");
        });
        assertEquals("b",myteststa1.pop());
        assertEquals("a",myteststa1.pop());
        assertThrows(EmptyStackException.class, ()->{
            myteststa1.peek();
        });
        assertEquals(0,myteststa1.size());
        myteststa1.clear();
        String[] lst1 = {"a"};
        String[] lst2 = {"a",null};
        String[] lst3 = {"a", "b", "c"};
        String[] lst4 = {"b", "a"};
        String[] lst5 = {null};
        assertThrows(FullStackException.class, ()->{
            myteststa1.multiPush(lst3);
        });
        assertArrayEquals(lst4,myteststa1.multiPop(3));
        assertThrows(IllegalArgumentException.class, ()->{
            myteststa1.multiPush(lst2);
        });
        assertArrayEquals(lst1,myteststa1.multiPop(3));
        assertThrows(IllegalArgumentException.class, ()->{
            myteststa1.multiPop(0);
        });
        assertThrows(IllegalArgumentException.class, ()->{
            myteststa1.multiPush(lst5);
        });
        myteststa1.push("a");
        myteststa1.clear();
        assertTrue(myteststa1.isEmpty());
        myteststa2.multiPush(lst3);
        myteststa2.clear();
        assertTrue(myteststa2.isEmpty());
        myteststa2.multiPush(lst3);
        myteststa2.pop();
        myteststa2.clear();
        assertTrue(myteststa2.isEmpty());
    }
}