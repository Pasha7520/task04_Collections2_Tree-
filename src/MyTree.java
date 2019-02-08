
public class MyTree<K extends Comparable<K>, V> {
    public Node root;

    private class Node {
        public K key;
        public V value;
        private Node right;
        private Node left;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public Node getByKey(K key) {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.key.compareTo(key) != 0)
        {
            if (current.key.compareTo(key) > 0) current = current.left;
            else current = current.right;
            if (current == null)
                return null;
        }
        return current;

    }

    public Object put(K key, V value) {
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        if (root == null) {
            root = newNode;
        } else
        {
            Node current = root;
            Node parent;
            while (true)
            {
                parent = current;

                if (current.key.compareTo(key) > 0)
                {
                    current = current.left;
                    if (current == null)
                    {

                        parent.left = newNode;
                        return newNode;
                    }
                } else
                {
                    current = current.right;
                    if (current == null)
                    {

                        parent.right = newNode;
                        return newNode;
                    }
                }
            }

        }
        return null;
    }

    public boolean delete(K key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.key.compareTo(key) != 0) {
            parent = current;
            if (current.key.compareTo(key) > 0)
            {
                isLeftChild = true;
                current = current.left;
            } else
            {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            }
            else if (isLeftChild) {
                parent.left = current.left;
            }
            else {
                parent.right = current.left;
            }
        }else if (current.left == null) {
            if (current == root) {
                root = current.right;
            }
            else if (isLeftChild) {
                parent.left = current.right;
            }
            else {
                parent.right = current.right;
            }
        }else
        {

            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            }else if (isLeftChild) {
                successor.left = parent.left.left;
                parent.left = successor;
            }else {
                successor.left = parent.right.left;
                parent.right = successor;
            }
            return true;
        }
        return false;
    }
    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if(successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.right);
        }
    }

}
