import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private TqsStack<String> newStack;
    private TqsStack<String> stack3elems;

    @BeforeEach
    void setUp() {
        newStack = new TqsStack<>();

        stack3elems = new TqsStack<>();
        stack3elems.push("Londres");
        stack3elems.push("Berlim");
        stack3elems.push("Lisboa");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Stack empty on construction")
    void isEmpty() {
        assertTrue(newStack.isEmpty());
        assertFalse(stack3elems.isEmpty());
    }

    @Test
    @DisplayName("Stack has size 0 on construction")
    void size() {
        assertEquals(0,newStack.size());
        assertEquals(3,stack3elems.size());
    }

    @Test
    @DisplayName("Pop after Push")
    void pop_after_push(){
        stack3elems.push("Roma");
        newStack.push("Roma");
        assertEquals("Roma", stack3elems.pop());
        assertEquals("Roma",newStack.pop());
    }

    @Test
    @DisplayName("Peek after Push and same size")
    void peek_after_push(){
        newStack.push("Roma");
        Integer size_after_push = newStack.size();
        assertEquals("Roma",newStack.peek());
        assertEquals(size_after_push,newStack.size());
    }


    @Test
    @DisplayName("After #size pops the is empty and has size 0")
    void pop_n_size_0() {
            stack3elems.pop();
            stack3elems.pop();
            stack3elems.pop();
            assertEquals(0,stack3elems.size());
            assert(stack3elems.isEmpty());
    }

    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    void pop_empty_error() {
        assertThrows(NoSuchElementException.class,() ->{
            newStack.pop();
        });
    }

    @Test
    @DisplayName("Peeking from an empty stack does throw a NoSuchElementException")
    void peek_empty_error() {
        assertThrows(NoSuchElementException.class,() -> {newStack.peek();});
    }



    @Test
    @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    void full_stack_error() {
        newStack = new TqsStack<>(2);
        newStack.push("Porto");
        newStack.push("Liverpool");
        assertThrows(IllegalStateException.class,()-> {newStack.push("Coimbra");});
    }


}