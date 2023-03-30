package datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>(); // both the Queue pointer and LinkedList object are from java inbuilt
        // classes, not the ones we created. This is used for temporary storage of Nodes whose values will be copied
        // into the below ArrayList
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode); //queue first item added as root

        while (queue.size() > 0) {
            currentNode = queue.remove(); // .remove method reeturns the removed Node and currentNode points to it
            results.add(currentNode.value); // removed node value then added to ArrayList
            if (currentNode.left != null) { // Node branches of currentNode added to queue both left down tree
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) { //and right down tree
                queue.add(currentNode.right);
            }
            //now the while loop repeats, moving to the second item in the first branch row since the .right of the root
            // was added to the queue. then its removed and its branch items added. in a symmetrical tree, the que will get
            // bigger directly proportional to the number of items in that row and must copy and remove all items from preceding
            // row before traversing lower rungs and their lefts and rights. leafs will then be emptied until loop invalid
        }
        return results;
    }

}


