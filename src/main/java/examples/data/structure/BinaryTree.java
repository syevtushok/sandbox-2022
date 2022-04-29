package examples.data.structure;

import java.util.LinkedList;
import java.util.Queue;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2
public class BinaryTree {

    private Node root;

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        log.debug(bt);
        log.debug(bt.contains(5));
        log.debug(bt.contains(10000));
        log.debug(bt);
        log.debug(bt.contains(6));
        bt.traverseInOrder();
        log.debug("\n");
        bt.traversePreOrder();
        log.debug("\n");
        bt.traversePostOrder();
        log.debug("\n");
        bt.traverseLevelOrder();
    }

    public void add(int value) {
        root = addInternal(root, value);
    }

    public boolean contains(int value) {
        return containsNode(root, value);
    }

    public Node delete(int value) {
        return deleteInternal(root, value);
    }

    /**
     * The in-order traversal consists of first visiting the left sub-tree,
     * then the root node,
     * and finally the right sub-tree
     */
    public void traverseInOrder() {
        traverseInOrderInternal(root);
    }

    /**
     * Pre-order traversal visits first the root node,
     * then the left sub-tree,
     * and finally the right sub-tree:
     */
    public void traversePreOrder() {
        traversePerOrderInternal(root);
    }


    /**
     * Post-order traversal visits the left sub-tree,
     * the right subt-ree,
     * and the root node at the end:
     */
    public void traversePostOrder() {
        traversePostOrderInternal(root);
    }

    /**
     * visits all the nodes of a level before going to the next level
     */
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            log.debug(remove.getValue());

            if (remove.getLeft() != null) {
                queue.add(remove.getLeft());
            }

            if (remove.getRight() != null) {
                queue.add(remove.getRight());
            }
        }
    }

    private void traversePostOrderInternal(Node node) {
        if (node != null) {
            traversePostOrderInternal(node.getLeft());
            traversePostOrderInternal(node.getRight());
            log.debug(node.getValue());
        }
    }

    private void traverseInOrderInternal(Node node) {
        if (node != null) {
            traverseInOrderInternal(node.getLeft());
            log.debug(node.getValue());
            traverseInOrderInternal(node.getRight());
        }
    }

    private void traversePerOrderInternal(Node node) {
        if (node != null) {
            log.debug(node.getValue());
            traversePerOrderInternal(node.getLeft());
            traversePerOrderInternal(node.getRight());
        }
    }

    private Node addInternal(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.setLeft(addInternal(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(addInternal(current.getRight(), value));
        } else {
            return current;
        }

        return current;
    }

    private boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (current.getValue() == value) {
            return true;
        }

        return current.getValue() > value ? containsNode(current.getLeft(), value) : containsNode(current.getRight(), value);
    }

    private Node deleteInternal(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (current.getValue() == value) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }

            int smallestNodeValue = findSmallestNode(current.getRight());
            current.setValue(smallestNodeValue);
            current.setRight(deleteInternal(current.getRight(), smallestNodeValue));
        }

        if (value < current.getValue()) {
            current.setLeft(deleteInternal(current.getLeft(), value));
            return current;
        }

        current.setRight(deleteInternal(current.getRight(), value));
        return current;
    }

    private int findSmallestNode(Node current) {
        if (current.getLeft() == null) {
            return current.getValue();
        }

        return findSmallestNode(current.getLeft());
    }
}
