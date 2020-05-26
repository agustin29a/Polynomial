package Polinomio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;


class PolynomialTest {
	
	private Polynomial polinomio;
	
	@BeforeEach
	public void setup() {
		int array[] = {5,3};
		polinomio = new Polynomial(array);
	}
	
	@Test
	public void testPolynomioCero() {
		Polynomial polinomioCero = new Polynomial();
		assertEquals("[[0X^0], ]",polinomioCero.toString());
		
	}
	
	@Test
	public void testPolynomialWithZero(){
		int array0[] = {5,0,4};
		Polynomial polinomio0 = new Polynomial(array0);
		assertEquals("[[4X^2], [5X^0], ]",polinomio0.toString());
		
	}
	
	@Test
	public void testPolynomialAdd() {
		int array2[] = {4,2}; 
		Polynomial polinomio2 = new Polynomial(array2);
		Polynomial suma = polinomio.polynomialAdd(polinomio2);
		assertEquals("[[5X^1], [9X^0], ]", suma.toString());
		
	}
	
	
	@Test
	public void testSetCoefficient() {
		polinomio.setCoefficient(1, 4);
		assertEquals("[[4X^1], [5X^0], ]", polinomio.toString());
	}	
	
	@Test
	public void testGetCoefficient() {
	
		assertEquals(3, polinomio.getCoefficient(1));
	}
	
	@Test
	public void testValueOf() {
		assertEquals(11, polinomio.valueOf(2));
	}
	
	@Test
	public void testEqualsTrue() {
		Object polinomio3 = polinomio;
		assertEquals(true, polinomio.equals(polinomio3));
	
		
	}
	
	@Test
	public void testEqualsFalse() {
		int array3[] = {5,4,3};
		Object polinomio3 = new Polynomial(array3);
		assertEquals(false, polinomio.equals(polinomio3));
	}
	
	
	@Test
	public void testToString() {
	
		assertEquals("[[3X^1], [5X^0], ]", polinomio.toString());
	}

}
