package Iterator;

import java.util.Iterator;

public class TreeTraversal {
    public static void main(String[] args) {
        
    }
}

class Node<T> {
    public T value;
    public Node<T> left, right, parent;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }   
}

class InOrderIterator<T> implements Iterator<T> {

    private Node<T> current, root;
    private boolean yeildedStart;

    public InOrderIterator(Node<T> root) {
        this.root = current = root;

        while (current.left != null) {
            current = current.left;
        }
    }

    private boolean hasRightmostParent(Node<T> node) {
        if (node.parent == null) return false;
        else {
            return (node == node.parent.left) || hasRightmostParent(node.parent);
        }
    }

    @Override
    public boolean hasNext() {
        return current.left != null || current.right != null || hasRightmostParent(current);
    }

    @Override
    public T next() {
        return null;
    }

    
}