### 网络与线程
#### 1. Java程序建立网络通信

Java程序使用socket进行网络通信。

建立socket连接，必须知道ip和端口号（类比于门牌号和窗口）。

一个地址有65535个不同的端口号可以用，0~1023的TCP端口号是保留给已知的特定服务使用。

ex:
```
Socket chatSocket = new Socket("196.164.1.103", 5000);
```

#### 2. 线程

Java内置多线程的功能，允许同时执行的能力。

启动一个新的线程的步骤：
1. 建立Runnable对象（任务）
2. 建立thread对象（工人）
3. 启动thread
```
Runnable threadJob = new MyRunnable();
Thread myThread = new Thread(threadJob);
myThread.start()
```
实际上，只有真正的多处理系统能够同时执行好几件事。

线程要记录的一项事物是目前线程执行空间做到哪里。

Java虚拟机会在线程与原来的主线程切换知道两者都完成为止。

为了避免多个线程操作同一个对象的并发性问题，要使用synchronized关键词加上一道锁。