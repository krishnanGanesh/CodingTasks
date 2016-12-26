using System;
using System.Threading;
using System.IO;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace threadingSemaphore
{
    class Mainclass
    {
        static Thread[] threads = new Thread[3];
        static Semaphore sem = new Semaphore(3,3);
        static void Reader_M()
        {
            System.Collections.Generic.Dictionary<string, int> Result = new System.Collections.Generic.Dictionary<string, int>();
            Console.WriteLine("{0} is waiting in line...", Thread.CurrentThread.Name);
            sem.WaitOne();
            using (StreamReader sr = new StreamReader("E:\\Moby Dick.txt"))
            {
                string line;
                while ((line = sr.ReadLine()) != null)
                {
                    string[] words = line.Split(' ');
                    foreach (string uncleanedword in words)
                    {
                        var word = Regex.Replace(uncleanedword, "[^a-zA-Z]+", "");
                        if (!Result.ContainsKey(word))
                        {
                            Result.Add(word, 1);
                        }
                        else
                        {
                            int value = Result[word];
                            Result.Remove(word);
                            Result.Add(word, value + 1);
                        }
                    }

                }
            }
            sem.Release();
            foreach (KeyValuePair<string,int> pair in Result)
            {
                Console.WriteLine("{0}  {1}", pair.Key, pair.Value);
            }
        }
        static void Reader_D()
        {
            System.Collections.Generic.Dictionary<string, int> Result = new System.Collections.Generic.Dictionary<string, int>();
            Console.WriteLine("{0} is waiting in line...", Thread.CurrentThread.Name);
            sem.WaitOne();
            using (StreamReader sr = new StreamReader("E:\\Don Quixote.txt"))
            {
                string line;
                while ((line = sr.ReadLine()) != null)
                {
                    string[] words = line.Split(' ');
                    foreach (string word in words)
                    {
                        if (!Result.ContainsKey(word))
                        {
                            Result.Add(word, 1);
                        }
                        else
                        {
                            int value = Result[word];
                            Result.Remove(word);
                            Result.Add(word, value + 1);
                        }
                    }
                       
                }
            }
            sem.Release();
        }
        static void Reader_C()
        {
            System.Collections.Generic.Dictionary<string, int> Result = new System.Collections.Generic.Dictionary<string, int>();
            Console.WriteLine("{0} is waiting in line...", Thread.CurrentThread.Name);
            sem.WaitOne();
            using (StreamReader sr = new StreamReader("E:\\Count of Monte Cristo.txt"))
            {
                string line;
                while ((line = sr.ReadLine()) != null)
                {
                    string[] words = line.Split(' ');
                    foreach (string word in words)
                    {
                        if (!Result.ContainsKey(word))
                        {
                            Result.Add(word, 1);
                        }
                        else
                        {
                            int value = Result[word];
                            Result.Remove(word);
                            Result.Add(word, value + 1);
                        }
                    }

                }
            }
            sem.Release();
        }
        static void Main(string[] args)
        {
            Console.BufferHeight = 30000;
            threads[0] = new Thread(Reader_M);
            threads[0].Name = "Thread0";
            threads[1] = new Thread(Reader_D);
            threads[1].Name = "Thread1";
            threads[2] = new Thread(Reader_C);
            threads[2].Name = "Thread2";
            threads[0].Start();
            threads[1].Start();
            threads[2].Start();
            Console.ReadKey();
        }
    }
}