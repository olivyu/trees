package trees;

import java.util.Arrays;

public class Tnode {
	private int value;
	private Tnode left;
	private Tnode right;
	
	public Tnode(int value, Tnode left, Tnode right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public int getValue(){
		return value;
	}
	
	public Tnode getLeft(){
		return left;
	}
	
	public Tnode getRight(){
		return right;
	}
	
	public void setLeft(Tnode n){
		left = n;
	}
	
	public void setRight(Tnode n){
		right = n;
	}
	
	public void add(Tnode n){
		if (n.getValue() < value){
			if (left==null){
				left = n;
			}
			else{
				left.add(n);
			}
		}
		else{
			if (right==null){
				right = n;
			}
			else{
				right.add(n);
			}			
		}
	}

	public Tnode delete(int item){
		if (value==item){
			if ((left==null) && (right==null)){
				return null;
			}
			else if ((left==null) && (right!=null)){
				return right;
			}
			else if ((left!=null) && (right==null)){
				return left;
			}
			else {
				return new Tnode(right.getMinimum(),left,right.clipMinimum());
			}
		}
		else if (item < value){
			return new Tnode(value,left.delete(item),right);
		}
		else{
			return new Tnode(value,left,right.delete(item));
		}
	}
	
	public int getMinimum(){
		if (left==null){
			return value;
		}
		else{
			return left.getMinimum();
		}
	}
	
	public Tnode clipMinimum(){
		if (left==null){
			if (right != null){
				return right;
			}
			else{
				return null;
			}
		}
		else{
			return new Tnode(value,left.clipMinimum(),right);
		}
	}

	
}
