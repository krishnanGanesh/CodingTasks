using System;
namespace BFS_BST
{
    class Mainclass
    {
        public static void Main(String[] args)
        {
            Node root = new Node();
            root.data = 40;
            root.node[0] = null;
            root.node[1] = null;
            bst tr = new bst();
            tr.add(30, root);
            tr.add(50, root);
            tr.add(60, root);
            tr.add(70, root);
            tr.add(65, root);
            tr.add(55, root);
            tr.add(80, root);
            tr.add(90, root);
            Console.WriteLine(tr.heightOfTree(root));
            Console.WriteLine("-----------------");
            tr.print_inorder(root);
            Console.WriteLine("-----------------");
            tr.print_preorder(root);
            Console.WriteLine("-----------------");
            tr.print_postorder(root);
            Console.WriteLine("%%%%%%%%%%%%%%%%");
            tr.delete(40, root);
            tr.print_inorder(root);
            Console.WriteLine("%%%%%%%%%%%%%%%%");
            tr.delete(30, root);
            tr.print_inorder(root);
            Console.WriteLine("%%%%%%%%%%%%%%%%");
            tr.delete(65, root);
            tr.print_inorder(root);
            Console.WriteLine("%%%%%%%%%%%%%%%%");
            tr.delete(70, root);
            tr.print_inorder(root);
            Console.WriteLine("%%%%%%%%%%%%%%%%");
            tr.print_bfs(root);
            Console.WriteLine("%%%%%%%%%%%%%%%%");
            Console.ReadKey();

        }
    }
    class Node
    {
        public int data;
        public Node[] node = new Node[2];

    }
    class bst
    {
        public void add(int d, Node root)
        {

            if (root.data > d)
            {

                if (root.node[0] != null)
                {
                    add(d, root.node[0]);
                }
                else
                {
                    Node temp = new Node();
                    temp.data = d;
                    root.node[0] = temp;
                }
            }
            if (root.data < d)
            {

                if (root.node[1] != null)
                {
                    add(d, root.node[1]);
                }
                else
                {
                    Node temp = new Node();
                    temp.data = d;
                    root.node[1] = temp;
                }
            }
            if (root.data == d)
            {
                Console.WriteLine("Duplicate data Entered");
                return;
            }

        }

        public void print_inorder(Node root)
        {
            if (root == null)
            {
                return;
            }
            print_inorder(root.node[0]);
            Console.WriteLine(root.data);
            print_inorder(root.node[1]);
        }

        public void print_preorder(Node root)
        {
            if (root == null)
            {
                return;
            }
            Console.WriteLine(root.data);
            print_preorder(root.node[0]);
            print_preorder(root.node[1]);
        }

        public void print_postorder(Node root)
        {
            if (root == null)
            {
                return;
            }
            print_postorder(root.node[0]);
            print_postorder(root.node[1]);
            Console.WriteLine(root.data);
        }

        public void print_bfs(Node root)
        {
            Queue<Node> queue = new Queue<Node>(10);
            queue.enQueue(root);
            run_bfs(root, queue);

        }

        private void run_bfs(Node root, Queue<Node> q)
        {
            if (q.isempty()) return;
            if (root != null)
            {
                if (root.node[0] != null)
                {
                    q.enQueue(root.node[0]);
                }
                if (root.node[1] != null)
                {
                    q.enQueue(root.node[1]);
                }
                Console.WriteLine(q.deQueue().data);
                run_bfs(root.node[0], q);
                run_bfs(root.node[1], q);
            }
        }

        public Node delete(int data, Node root)
        {
            if (root == null) return root;
            if (root.data > data)
            {

                root.node[0] = delete(data, root.node[0]);
            }
            else if (root.data < data)
            {

                root.node[1] = delete(data, root.node[1]);
            }
            else
            {

                if (root.node[1] == null)
                {
                    return root.node[0];
                }
                else if (root.node[0] == null)
                {
                    return root.node[1];
                }
                else
                {
                    root.data = minValue(root.node[1]);
                    root.node[1] = delete(root.data, root.node[1]);
                }
            }
            return root;
        }

        int minValue(Node root)
        {
            int minv = root.data;
            while (root.node[0] != null)
            {
                minv = root.node[0].data;
                root = root.node[0];
            }
            return minv;
        }

        public int heightOfTree(Node root)
        {
            if (root == null)
            {
                return -1;
            }
            else
            {
                return max(heightOfTree(root.node[0]), heightOfTree(root.node[1])) + 1;
            }
        }

        int max(int a, int b)
        {
            if (a >= b)
            {
                return a;
            }
            else { return b; }
        }
    }
}













