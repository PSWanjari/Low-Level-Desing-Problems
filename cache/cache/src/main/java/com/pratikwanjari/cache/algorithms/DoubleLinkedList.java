package com.pratikwanjari.cache.algorithms;

public class DoubleLinkedList<Key> {

	private Node<Key> first=null;
	private Node<Key> last = null;
	
	/*
	 *  add key at front
	 */
	public Node<Key> addKey(Key key)
	{
		Node<Key> node = new Node<Key>(key);
		node.setnext(null);
		node.setElement(key);
		if(first==null)
		{
			node.setprev(null);
			first=node;
			last=node;
			return node;
		}
		last.setnext(node);
		node.setprev(last);
		last=node;
		return node;
	}
	
	/*
	 * detach node and move to front
	 */
	public void detachNodeAndmovetolast(Node<Key> node) {
		
	 if(node.getElement().equals(last.getElement()))
	 {
		 
		return;
	 }
	 if(node.getElement().equals(first.getElement()))
	 {

		 if(node.getnext()!=null)
		 {
			 first=node.getnext();
			 first.setprev(null);
			 last.setnext(node);
			 node.setprev(last);
			 last=node;
			 last.setnext(null);
		 }
		 
		 return;
	 }
	 Node<Key> next = node.getnext();
	 Node<Key> pre = node .getprev();
	 next.setprev(pre);
	 pre.setnext(next);
	 
	 last.setnext(node);
	 node.setprev(last);
	 node.setnext(null);
	 last=node;
	 return ;
	}
	
	/*
	 * add key at last
	 */
	public Node<Key> getLast(Key key)
	{
		Node<Key> removed = last;
		if(last!=null)
		{
			last=last.getprev();
			last.setnext(null);
		}
		return removed;
	}
	
	public Node<Key> remove()
	{
		if(first==null)
		{
			System.out.println("no element to remove");
			return null;
		}
		Node<Key> removed = first;
		first=first.getnext();
		first.setprev(null);
		return removed;
		
		
	}
	public void printDLL()
	{
		Node<Key> curr =first;
		while(curr!=null)
		{
			System.out.print(curr.toString()+"->");
			curr=curr.getnext();
		}
	}
	
}
