package org.software_testing.junit_example;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExampleTest {
    @Test
    public void testQuackAlot() {
        //Stub metod
        Example example = new Example();
        Duck mockDuck = mock(Duck.class);
        when(mockDuck.quack()).thenReturn(1);
        int val = example.quackAlot(mockDuck, 100);
        assertEquals(val, 100);
    }

    @Test
    public void testQuackMock() {
        Example example = new Example();
        Duck mockDuck = mock(Duck.class);
        when(mockDuck.quack()).thenReturn(1);
        example.quackAlot(mockDuck, 5);
        Mockito.verify(mockDuck, times(5)).quack();
    }

    public class FakeDuck extends Duck {
        //karmaşık yörünge hesabı
        public void shoot() {
            alive = false;
        }
    }

    @Test
    public void testShootDuck() {
        //fake Duck sınıfı oluştur
        Duck fakeDuck = new FakeDuck();
        DuckHunt duckHunt = new DuckHunt();
        duckHunt.shootDuck(fakeDuck);
    }
}
