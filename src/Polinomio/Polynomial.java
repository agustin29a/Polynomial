package Polinomio;
import java.util.NoSuchElementException;

public class Polynomial extends Object {
	
	private Node root;
	private int count;

	
	public Polynomial() {
		this.add(0,0);
		
	}
	
	public Polynomial(int[] coef) {
		int len = coef.length;
		for (int i = 0; i < coef.length ; i++) {
			if (coef[i] != 0) {
				this.add(coef[i], i);
				count ++;
			}	
		}
	}
	
	public int countValue() {
		return count;
	}
	
	public void add(int x, int e) {
		Node n = new Node(x,e);
		n.next = root;
		root = n;
	
		}
	
	public Polynomial polynomialAdd (Polynomial Pol) {
		
		Node p = root;
		
		while(p != null) {
			p.value += Pol.getCoefficient(p.exponent);
			p = p.next;
		}
		
		return this;
	}
	
	public int getCoefficient(int index) {
		if(index<0 || index > count) {
			throw new NoSuchElementException();
		}
		
		Node p = root;
		while(p != null && p.exponent != index) {
			p = p.next;
		}
		return p.value;
	}
	
	public void setCoefficient(int x, int coef) {
		
		Node p = root;
		while(p.exponent != x) {
			p = p.next;
		}
		
		p.value = coef;
	}
	
	public float valueOf(float x) {
		float total = 0;
		Node p = root;
		while(p != null) {
			total += p.value * Math.pow(x,p.exponent);
			p = p.next;
		}
		
		return total;
	}
	
	
	public boolean equals(Object x) {
		if (this == x) {
		 return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node p = root;
		while(p != null) {
			sb.append("[");
			sb.append(p.value);
			sb.append("X^");
			sb.append(p.exponent);
			sb.append("]");
			sb.append(", ");
			p = p.next;
		}
		sb.append("]");
		return sb.toString();
	}

	
	private static class Node{
		
		int value;
		
		int exponent;
		
		Node next;
		
		public Node(int value, int exponent){
			
			this.value = value;
			this.exponent = exponent;
			
		}
		
	}
	
}
