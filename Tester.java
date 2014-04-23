package trees;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) throws ExistenceException{
		Tree my_tree = new Tree();
		
		Random random = new Random();
		int[] storage = new int[20];
		for (int j = 0; j < storage.length; j++){
			int next = random.nextInt(100);
			storage[j] = next;
			my_tree.insert(next);
		}
		
		System.out.println(Arrays.toString(storage));
		my_tree.balance();
		my_tree.display();
		System.out.println(my_tree.count());

		for (int i : storage){
			System.out.println(i);
			System.out.println(my_tree.search(i));
			my_tree.delete(i);
			//System.out.println(my_tree.count());
			my_tree.display();
		}
		
		System.out.println(my_tree.count());
		
		//my_tree.display();
		
		//System.out.println(my_tree.height());
		
	}
}


//if ((left==null) && (right==null)){
//	return new Tnode(value,null,null);
//}
//else if ((left==null) && (right!=null)){
//	return new Tnode(value,null,right.delete(item));
//}
//else if ((left!=null) && (right==null)){
//	return new Tnode(value,left.delete(item),null);
//}
//else {
//	return new Tnode(value,left.delete(item),right.delete(item));
//}
