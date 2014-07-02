TaskExecuter
============

Creates Tasks in a Queue and process task using thread pool
1. Item interface represents the items to be processed.
2. ItemProcessor processes items. Its implements runnable class. It has run() method in which processing logic is          implemented.
   Each ItemProcessor runs in a separate thread and picks Items from JobQueue. Then calls methods for the Item objects.
3. Consumer interface represents consumer of task items. It creates ItemProcessors objects and passes them to ExecutorService
   which shall serve as worker threads.
4. Test is the main class. It creates Consumer type object. For each line in a file it creates an Item object and adds it to
   itemQueue.
   
   For running Put the Job.csv file in the local directory and give the path in Test.java.
   Then run Test.java directly.
