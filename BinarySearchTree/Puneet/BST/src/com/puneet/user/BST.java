package com.puneet.user;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

	public Node head;
	  
	  public BST(){
	    head = new Node(null);
	  }
	  
	  public static void main(String args[]){
		  BST binarySearchTree = new BST();
		  binarySearchTree.addANode("Kaku");
		  binarySearchTree.addANode("Puneet");
		  //binarySearchTree.addANode("Kamnran");
		  binarySearchTree.addANode("Kamran");
		  binarySearchTree.addANode("Rakesh");
		  //binarySearchTree.addANode("Qin");
		  binarySearchTree.addANode("Sagar");
		  System.out.println("Printing In-order...");
		  binarySearchTree.inOrder(binarySearchTree.head.right);
		  //binarySearchTree.postOrder(binarySearchTree.head);
		  //binarySearchTree.inOrder(binarySearchTree.head);
		  binarySearchTree.deleteANode("Rakesh");
		  System.out.println("Printing In-order...");
		  binarySearchTree.inOrder(binarySearchTree.head.right);
		  System.out.println("Printing level-order...");
		  binarySearchTree.levelOrderTraversal(binarySearchTree.head.right);
	  }
	  public Node createANode(String name){
	    
	    Node newNode = new Node(name);
	    if(newNode == null){
	      System.out.println("Node cannot be created. There's not enough memory available.");
	      return null;
	    }
	    return newNode;
	  }
	  
	  public void addANode(String name){
	    
	    Node newNode = createANode(name);
	    
	    if(head.right == null){
	      System.out.println("This is the first node created ");
	      head.right = newNode;
	      System.out.println("The node added is "+name);
	    }
	    
	    else if((head.right.left == null) && (head.right.right == null)){
	      if(name.compareTo(head.right.name) > 0){
	        head.right.right = newNode;
	      }
	      else if(name.compareTo(head.right.name) < 0){
	        head.right.left = newNode;
	      }
	      else{
	        System.out.println("This is a duplicate Node. Cannot add duplicate node.");
	        return;
	      }
	      System.out.println("The node added is "+name);
	      return;
	    }
	    
	    else{
	    	
	    	Node temp = findPosition(name, true);
	    	if(temp == null){
	    		System.out.println("Duplicate Node cannot be added.");
	    		return;
	    	}
	    	else{
	    	
	    		if(name.compareTo(temp.name) > 0){
	    			temp.right = newNode;
	    		}
	    		else{
	    			temp.left = newNode;
	    		}
	    	}
	    }
	    
	  }
	  
	  public Node findPosition(String name, boolean add){
	    
	    Node nodeToBeFound = head.right;
	    Node parentNode = head.right;
	    
	    while(nodeToBeFound != null){
	      if((name.compareTo(nodeToBeFound.name) > 0) ){
	        if(nodeToBeFound.right == null){
	        	return nodeToBeFound;
	        }
	    	parentNode = nodeToBeFound;
	        nodeToBeFound = nodeToBeFound.right;
	      }
	      else if((name.compareTo(nodeToBeFound.name) < 0)){
	    	if(nodeToBeFound.left == null){
		        	return nodeToBeFound;
		    }
	        parentNode = nodeToBeFound;
	        nodeToBeFound = nodeToBeFound.left;
	      }
	      else{
	        if(add == true){
	        	System.out.println("This is a duplicate node. Cannot add duplicate node.");
	        	return null;
	        }
	        else{
	          return parentNode;
	        }
	      }
	    }
	    return null;
	  }
	  
	  public void deleteANode(String name){
	    
		  Node parentNode = findPosition(name, false);
		  if(parentNode == null){
			  System.out.println("There's no such node");
		  }
		  else{
			  if(name.compareTo(parentNode.right.name) == 0){
				  if((parentNode.right.right == null) && (parentNode.right.left == null)){
					  parentNode.right = null;
					  System.out.println("Deleted node : "+name);
				  }
				  else if(parentNode.right.right == null){
					  parentNode.right = parentNode.right.left;
				  }
				  else if(parentNode.right.left == null){
					  parentNode.right = parentNode.right.right;
				  }
				  else{
					  if(parentNode.right.right.left != null){
						  //call min function
						  Node inOrderSuccessorParent = findSmallest(parentNode.right.right);
						  parentNode.right.name = inOrderSuccessorParent.left.name;
						  inOrderSuccessorParent.left = null;
					  }
					  else{
						  parentNode.right.name = parentNode.right.right.name;
						  parentNode.right.right = parentNode.right.right.right;
					  }
				  }
			  }
			  else if(name.compareTo(parentNode.left.name) == 0){
				  if((parentNode.left.right == null) && (parentNode.left.left == null)){
					  parentNode.left = null;
				  }
				  else if(parentNode.left.right == null){
					  parentNode.left = parentNode.left.left;
				  }
				  else if(parentNode.left.left == null){
					  parentNode.left = parentNode.left.right;
				  }
				  else{
					  if(parentNode.left.right.left != null){
						  //call min function
						  Node inOrderSuccessorParent = findSmallest(parentNode.left.right);
						  parentNode.left.name = inOrderSuccessorParent.left.name;
						  inOrderSuccessorParent.left = null;
					  }
					  else{
						  parentNode.left.name = parentNode.left.right.name;
						  parentNode.left.right = parentNode.left.right.right;
					  }
				  }
			  }
			  else{
				  System.out.println("Such a node does not exist.");
			  }
		  }
		  
	  }
	  
	  public Node findSmallest(Node node){
		  
		  if(node.left == null){
			  System.out.println("This was the Inorder successor of the node to be deleted.");
			  return null;
		  }
		  Node parent = node;
		  while(node.left != null){
			  parent = node ;
			  node = node.left;
		  }
		  return parent;
	  }
	  public void preOrder(Node temp){
	    if(temp == null){
	      return;
	    }
	    System.out.println(temp.name);
	    preOrder(temp.left);
	    preOrder(temp.right);
	  }
	  
	  public void inOrder(Node temp){
	    if(temp == null){
	      return;
	    }
	    inOrder(temp.left);
	    System.out.println(temp.name);
	    inOrder(temp.right);
	  }
	  
	  public void postOrder(Node temp){
	    if(temp == null){
	      return;
	    }
	    postOrder(temp.left);
	    postOrder(temp.right);
	    System.out.println(temp.name);
	  }
	  
	  public void levelOrderTraversal(Node root){
		  
		  Queue<Node> queue = new LinkedList<Node>();
		  
		  queue.add(root);
		  
		  while(!queue.isEmpty()){
			  Node dequeuedNode = queue.remove();
			  System.out.println(dequeuedNode.name);
			  
			  if(dequeuedNode.left != null){
				  queue.add(dequeuedNode.left);
			  }
			  
			  if(dequeuedNode.right != null){
				  queue.add(dequeuedNode.right);
			  }
		  }
	  }
	  
}
