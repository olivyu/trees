package trees;

import java.util.ArrayList;
import java.util.Arrays;

import rpn.OperandException;

public class Tree {
	
	public Tnode root;
	
	public Tree() { 
		root = null; 
	}
	
	public int[] traverse(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		traverse(root,list);
		int[] new_list = new int[list.size()];
		for (int i=0;i<list.size();i++){
			new_list[i] = list.get(i);
		}
		//System.out.println(Arrays.toString(new_list));
		return new_list;
	}
	
	public static void traverse(Tnode n, ArrayList<Integer> list){
		if (n==null){
			return;
		}
		traverse(n.getLeft(),list);
		list.add(n.getValue());
		traverse(n.getRight(),list);
	}
	
	public void display(){
		int[] list = traverse();
		for (int i : list){
			System.out.printf(i + " ");
		}
		System.out.println();
	}
	
	public int count(){
		return count(root);
	}
	
	public static int count(Tnode n){
		if (n==null){
			return 0;
		}
		return 1 + count(n.getLeft()) + count(n.getRight());
	}
	
	
	public void insert(int item){
		if (root==null){
			root = new Tnode(item,null,null);
		}
		else{
			root.add(new Tnode(item,null,null));
		}
	}
	
	public boolean check_existence(int item){
		int[] list = traverse();
		for (int i : list){
			if (i==item){
				return true;
			}
		}
		return false;
	}
	
	public int search(int item) throws ExistenceException{ //returns the depth number the item is found
		return search(item,root);
	}
	
	public static int search(int item, Tnode n) throws ExistenceException{
		if (n==null){
			throw new ExistenceException("Not an item in tree!");
		}
		else if (n.getValue()==item){
			return 0;
		}
		else if (item < n.getValue()){
			return 1+search(item,n.getLeft());
		}
		else {
			return 1+search(item,n.getRight());
		}
	}
	
	public int height(){ 
		return height(root); 
	}
	
	public static int height(Tnode n){
		if (n==null){
			return 0;
		}
		else{
			return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
		}
	}
	
	public void balance(){
		int[] list = traverse();	
		if (list.length==0){
			root = null;
		}
		else{
			root = balance(list);
		}
	}
	
	public static Tnode balance(int[] list){
		if (list.length==0){
			return null;
		}
		else if (list.length==1){
			return new Tnode(list[0],null,null);
		}
		else{
			int mid = list.length/2;
			int[] left_list = Arrays.copyOfRange(list,0,mid);
			int[] right_list = Arrays.copyOfRange(list,mid+1,list.length);
			return new Tnode(list[mid],balance(left_list),balance(right_list));
		}
	}
	
	public void delete(int item) throws ExistenceException{
		if (check_existence(item)){
			root = root.delete(item);
		}
		else {
			throw new ExistenceException("Not an item in tree!");
		}
	}
	

}