package org.software_testing.junit_example;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.mockito.*;

public class CatScaleTest {
    @Test
    public void testReport() {
	CatScale scale = new CatScale();
	Cat cat = Mockito.mock(Cat.class);
	Mockito.when(cat.getWeight()).thenReturn(80);
    	assertEquals(scale.report(cat), "Overweight");
    	Mockito.verify(cat).getWeight();
    }
}
