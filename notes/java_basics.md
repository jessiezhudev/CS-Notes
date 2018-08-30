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

### 集合与泛型
字符串排序功能可以用TreeSet或Collection.sort()方法

然而对于泛型，不能直接用Collection.sort()。类必须实现Comparable

泛型意味着更好的类型安全性。
让编译器能够帮忙防止你把Dog加到一群Cat中

泛型实现comparable接口的例子:
```
class Song implements Comparable<Song> {
    String title;
    public int compareTo(Song s) {
        return title.compareTo(s.getTitle())
    }
}
```
调用时:
```
Collection.sort(songList);
```

### 如何发布Java程序
#### 将源代码与类文件分离
标准化的组织化纲要：源代码（.java）放在source目录下，编译时让输出（.class）产生在classes目录。

做法：编译时加上-d（directory）选项。
```
cd Myproject/source
javac -d ../classes myApp.java
javac -d ../classes *.java //编译所有的java
```
#### 把程序包进JAR
JAR是Java ARchive，不是整理文件的工具jar。它能让你把一组类文件包装起来。

创建可执行的JAR代表用户不需把文件抽出来就能运行。秘诀在于创建出manifest文件，它会带有JAR的信息，告诉
Java虚拟机哪个类含有main()这个方法。

Steps:
1. 确定所有类文件都在classes目录下
2. 创建manifest.txt描述哪个文件带有main()方法
   
   内容：
   ```
   Main-class:MyApp
   ```
3. 执行jar工具
   
   ```
   jar -cmvf manifest.txt app1.jar *.class
   ```

#### 虚拟机执行JAR程序
```
cd MyProject/classes
java -jar app1.jar
```

#### 把类包进包中
- 为了防止类的命名冲突

建议的命名规则 - 反向使用domain的包名称 （ex: 公司项目的com.gmm.stat.web.admin)
```
package com.headfirstjava;
```
并将源文件放在headfirstjava目录下，此目录必须在com目录下。
