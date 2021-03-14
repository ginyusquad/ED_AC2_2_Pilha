package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

import source.ArrayStack;
import source.EmptyStackException;
import source.FullStackException;
import source.Stack;

import org.junit.Test;

public class ArrayStackTest {
    
	static final Stack<String> a = new ArrayStack<String>(3);
    	
    @Test
    public void test() {
        a.push("Ana");
        assertEquals("[Ana]", a.toString(), "Deve imprimir [Ana]");
        a.push("Bruna");
        assertEquals("[Ana, Bruna]", a.toString(), "Deve imprimir [Ana, Bruna]");
        a.push("Carla");
        assertEquals("[Ana, Bruna, Carla]", a.toString(), "Deve imprimir [Ana, Bruna, Carla]");

        Assertions.assertThrows(FullStackException.class, () -> { a.push("Bruna"); });

        assertEquals("Carla", a.pop(), "Deve ter desempilhado Carla");
        assertEquals("[Ana, Bruna]", a.toString(), "Deve imprimir [Ana, Bruna]");
        
        assertEquals("Bruna", a.pop(), "Deve ter desempilhado Bruna");
        
        assertEquals("[Ana]", a.toString(), "Deve imprimir [Ana]");
        
        assertEquals("Ana", a.pop(), "Deve ter desempilhado Ana");
        
        assertEquals("[]", a.toString(), "Deve imprimir []");

        assertTrue(a.isEmpty());

        Assertions.assertThrows(EmptyStackException.class, () -> { a.pop(); });
    }
}

