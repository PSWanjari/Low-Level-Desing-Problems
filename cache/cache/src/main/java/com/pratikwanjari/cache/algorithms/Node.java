package com.pratikwanjari.cache.algorithms;

public class Node<Key>{
	private Key element;
	private Node<Key> next;
	private Node<Key> lasnode;
	
	public Node(Key element) {
		super();
		this.element = element;
	}
	public Key getElement() {
		return element;
	}
	public void setElement(Key element) {
		this.element = element;
	}
	public Node<Key> getnext() {
		return next;
	}
	public void setnext(Node<Key> next) {
		this.next = next;
	}
	public Node<Key> getprev() {
		return lasnode;
	}
	public void setprev(Node<Key> lasnode) {
		this.lasnode = lasnode;
	}
	
}
