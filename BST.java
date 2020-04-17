public class BST<T>
{
    static Node root;

    public BST()
    {
        root = null;
    }

    public boolean find(Comparable item)
    {
        return find(root, item);
    }

    public boolean find(Node data, Comparable item)
    {
        if (data == null)
        {
            return false;
        }
        if (data.data == item)
        {
            return true;
        }
        if (item.compareTo(data.data) <0)
        {
            return find(data.left, item);
        }
        else
        {
            return find(data.right, item);
        }
    }

    public void insert(Comparable item)
    {
        root = insertNode(root, item);
    }

    public Node insertNode(Node t, Comparable item)
    {
        if (t == null)
        {
            Node newTree = new Node(item);
            return newTree;
        }
        else if ((t.data).compareTo(item) < 0)
        {
            t.right = insertNode(t.right, item);
            return t;
        }
        else
        {
            t.left = insertNode(t.left, item);
            return t;
        }
    }

    public void print()
    {
        print(root);
    }

    public void print(Node data)
    {
        if (data != null)
        {
            print(data.left);
            System.out.println(data.data);
            print(data.right);
        }
    }

    public void delete(Comparable item)
    {
        root = delete(root, item);
    }

    public Node delete(Node t, Comparable item)
    {
        if (t == null)
        {
            return null;
        }
        if ((t.data).compareTo(item) == 0)
        {
            if (t.left == null) {
                return t.right;
            }
            if (t.right == null) {
                return t.left;
            }
            if (t.right.left == null) {
                t.data = t.right.data;
                t.right = t.right.right;
                return t;
            }
            else
            {
                t.data = MinRight(t.right);
            }
        }
        else if ((t.data).compareTo(item) > 0)
        {
            t.left = delete(t.left, item);
            return t;
        }
        else
        {
            t.right = delete(t.right, item);
        }
        return t;
    }

    public Comparable MinRight (Node t)
    {
        if (t.left.left == null)
        {
            Comparable smallest = t.left.data;
            t.left = t.left.right;
            return smallest;
        }
        else
        {
            return MinRight(t.left);
        }
    }
}