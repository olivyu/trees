package trees;

import java.util.Scanner;

public class BinaryTree {
	static Scanner input = new Scanner(System.in);
	static Tree tree = new Tree();

	public static void main(String[] args){
		System.out.println("Welcome to Binary Tree!");
		while (true){
			System.out.println();
			System.out.println("What do you want to do?");
			System.out.println("1. Add item to tree");
			System.out.println("2. Delete item from tree");
			System.out.println("3. Find item on tree");
			System.out.println("4. Balance tree");
			System.out.println("5. List contents of tree");
			System.out.println("6. Display statistics of tree"); //root value, depth of tree, number of items
			System.out.println("7. Exit program");
			String line = input.nextLine();
			if (line.equals("7")){
				return;
			}
			else {
				menu(line);
			}
		}
	}
	
	public static void menu(String line){
		switch (line){
		case "1":
			System.out.println("What integer(s) do you want to add?");
			try{
				String numbers = input.nextLine();
				for (String number : numbers.split(" ")){
					int value = Integer.parseInt(number);
					tree.insert(value);
				}
				System.out.println("Integer(s) added!");
			}
			catch (Exception e){
				System.out.println("Exception thrown  :" + e);
			}
			
			break;
		case "2":
			System.out.println("What integer(s) do you want to delete?");
			try{
				String numbers = input.nextLine();
				for (String number : numbers.split(" ")){
					int value = Integer.parseInt(number);
					tree.delete(value);
				}
				System.out.println("Deleted!");
			}
			catch (Exception e){
				System.out.println("Exception thrown  :" + e);
			}
			break;
		case "3":
			System.out.println("Which integer do you want to search for?");
			try{
				int value = Integer.parseInt(input.nextLine());
				System.out.println("Integer " + value + " is on depth: " + tree.search(value));
			}
			catch (Exception e){
				System.out.println("Exception thrown  :" + e);
			}
			break;
		case "4":
			tree.balance();
			System.out.println("Tree Balanced!");
			break;
		case "5":
			System.out.println("Current Tree:");
			tree.display();
			break;
		case "6":
			int depth = tree.height()-1; // depth is height-1
			System.out.println("Root Value: " + tree.root.getValue());
			System.out.println("Tree Depth: " + depth);
			System.out.println("Number of Items in Tree: " + tree.count());
			break;
		default:
			System.out.println("Please pick a number!");
			break;
		}
	}
}
