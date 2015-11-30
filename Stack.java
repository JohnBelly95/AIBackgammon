public class Stack{
	private Checker node;
	Checker firstNode;
	Checker lastNode;
	
	public Stack(){
		node=null;
		firstNode = null;
		lastNode = null;
	}
	public Stack(Checker node){
		this.node = node;
		firstNode = null;
		lastNode = null;
	}
	
	public void push(Checker node){
		if(firstNode == null){
			firstNode = node;
		}
		 node.nextCh = lastNode;
		 lastNode = node;
	}
	
	public Checker pop(){
		if(isEmpty()){
			//error;
		}else{
			Checker node = lastNode;
			lastNode = node.nextCh;
			node.nextCh = null;
			return node;
		}
		return null;
	}
	
	public boolean isEmpty(){
		if(firstNode==null) return true;
		else return false;
	}
	public int size(){
		int a=0;
		node = lastNode;
		while(node != null){
			a++;
			node = node.nextCh;
		}
		return a;
	}
	public boolean colorSearch(boolean clr){
		if(!this.isEmpty()){
			if(firstNode.isBlack() == clr || lastNode.isBlack() == clr){
				return true;
			}
		}
		return false;
	}
	
	
}
