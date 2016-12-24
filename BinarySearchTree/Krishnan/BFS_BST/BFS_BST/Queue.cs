using System;


namespace BFS_BST
{
   

    public class Queue<T>
    {

        private int front;
        private int rear;
        int size;
        T[] queue;

        public Queue(int inSize)
        {
            size = inSize;
            queue = new T[size];
            front = -1;
            rear = -1;
        }

        public bool isempty()
        {
            return (front == -1 && rear == -1);
        }

        public void enQueue(T value)
        {
            if ((rear + 1) % size == front)
            {
                Console.WriteLine("Queue is full");

            }
            else if (isempty())
            {
                front++;
                rear++;
                queue[rear] = value;

            }
            else
            {
                rear = (rear + 1) % size;
                queue[rear] = value;

            }
        }

        public T deQueue()
        {
            T value = default(T);
            if (isempty())
            {
                Console.Write("Queue is empty, cant dequeue = ");
            }
            else if (front == rear)
            {
                value = queue[front];
                front = -1;
                rear = -1;

            }
            else
            {
                value = queue[front];
                front = (front + 1) % size;

            }
            return value;

        }
    }
}
