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

#### 远程部署的RMI
Java的远程程序调用(Remote Method Invocation, RMI)技术

如何调用不同机器上的对象的方法？(比如小不点A想要调用大人物B的方法，利用B强大的计算能力)

远程过程调用的设计：

创建出4种东西：服务器、客户端、服务器辅助设施和客户端辅助设施

辅助设施处理所有客户端和服务器的底层网络输入/输出细节，让客户端和程序好像在处理本地调用一样。辅助设施就是个本地代理。


### 序列化和文件的输入/输出

对象有状态和行为两种属性。行为存在于类中，而状态存在于个别的对象中。所以如何存储对象的状态（比如存储和恢复游戏的功能）？

两种方式：
1. 对每一个对象，逐个地把每项变量的值写到特定格式的文件中。（适用于数据需要被其他程序引用的场景）
2. 用面向对象的方式 - 序列化，将被序列化的对象写到文件中，让你的程序去文件中读取序列化的对象并把它们展开。（适用于只有自己写的程序
   会用到这些数据）

序列化的文件是很难让一般人阅读的，但它比纯文本文件更容易让程序恢复这三种任务的状态，也比较安全。

#### 序列化的方法步骤：
1. 创建出FileOutputStream
   ```
   FileOutputStream fileStream = new FileOutputStream("MyGame.ser");
   ```

2. 创建ObjectOutputStream
   ```
   //它能让你写入对象
   ObjectOutputStream os = new ObjectOutputStream(fileStream);
   ```

3. 写入对象
    ```
    //将变量所引用的对象序列化并写入这个文件
    os.writeObject(characterOne);
    os.writeObject(characterTwo);
    os.writeObject(characterThree);
    ```
4. 关闭ObjectOutputStream
   ```
   os.close()
   ```

   FileOutputStream把字节写入文件，ObjectOutputStream把对象转换成可以写入串流的数据。
   当我们调用ObjectOutputStream的writeObject时，对象会被打成串流送到FileOutputStream来写入
   文件。


如果要让类能够被序列化，就实现Serializable。该类可以实现序列化，则此类型的对象也可以实现序列化。
（对象实现序列化必须要实现Serializable接口！）
```
import java.io.*;
public class Box implements Serializable{

}
```

如果某实例变量不能或不应该被序列化，就把它标记为transient（瞬时）的。
```
transient String currentID;
```

解序列化（Deserialization）：还原对象

1. 创建FileInputStream
   ```
   FileInputStream fileStream = new FileInputStream("MyGame.ser");
   ```
2. 创建ObjectInputStream
   ```
   ObjectInputStream os = new ObjectInputStream(fileStream);
   ```
3. 读取对象
   Object one = os.readObject();
   Object two = os.readObject();
   Object three = os.readObject();
    //每次调用readObject()都会从stream中读出下一个对象，读取顺序与写入顺序相同，次数超过会抛出异常。

4. 转换对象类型
    ```
    //返回值是Object类型，因此必须要转换类型
    GameCharacter elf = (GameCharacter) one;
    GameCharacter throll = (GameCharacer) two;
    GameCharacter magician = (GameCharacer) three;
    ```
5. 关闭ObjectInputStream
   ```
   os.close();
   ```

   解序列化时，新的对象会被配置在堆上，但构造函数不会执行。这样会把对象的状态抹去又变成全新的。

#### 将字符串写入文本文件

写入文本数据（字符串）与写入对象类似。
```
FileWriter write = new FileWriter("Foo.txt");
writer.write("hello foo!");
writer.close();
```


