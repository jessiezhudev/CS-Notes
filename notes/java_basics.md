### primitive主数据类型和引用
Java注重类型，你必须声明所有的类型。Java不会让你做出把长颈鹿类型的变量装进兔子类型变量中这种诡异又危险的举动。

记忆方法：Be Careful! Bears Shouldn't Injest Large Furry Dogs

分别对应：boolean char bytes short int long float double

primitive主数据类型就像咖啡馆的杯子，它们有不同的大小。而每种大小都有个名称。

引用变量是引用到对象的变量。事实上没有对象变量这种东西存在。对象只存在于可回收垃圾的堆上。引用相当于定义了一个遥控器，它控制什么类型的对象是指定的。

对象的声明、创建于赋值有三个步骤，如：
```
Dog myDog = new Dog()
```
1. 声明一个类型为Dog的变量myDog
2. 创建Dog对象，要求虚拟机分配堆空间给该对象。
3. 连接对象和引用
   
对象不再被引用时，能够作垃圾收集器（GC）。

#### 数组犹如杯架
1. 声明一个int数组变量。数组变量是数组对象的遥控器
   ```
   int[] nums;
   ```
2. 创建大小为7的数组，并将它赋值给之前声明为int[]的变量nums
   ```
   nums = new int[7];
   ```
3. 赋值int数组的每一个元素一个int
   ```
   nums[0] = 6;
   ...
   ```
### 对象的行为
类所描述的是对象知道什么与执行什么。

类是对象的蓝图。在编写类时，你是在描述Java虚拟机应该如何制作该类型的对象。

你可以传值给方法。方法会应用形参，调用的一方会传入实参。

重点是：如果某个方法需要参数，你就一定得传东西给它。那个东西得是适当类型的值。

方法可以有返回值。但不能声明多个返回值。

Java是通过值传递的，也就是说通过拷贝传递

```
int x = 7;
void go(int z) {};
foo.go(x);
```
如上，x的字节组合会被拷贝并装进z中。方法无法改变调用方所传入的参数

#### 封装
通过圆点运算符来存取数据，并不安全，需要隐藏数据，使用公有和私有这两个存取修饰符。

封装的基本原则：将你的实例变量设为私有的，并提供公有的getter和setter来控制存取动作。

你无须初始实例变量，因为它们会有默认值，数字的primitve(包括char)的预设为0，boolean的预设为false。而对象的引用则为null。

实例变量是声明在类中而不是方法中。局部变量是声明在方法中的。局部变量在使用前必须初始化。

#### 变量的比较
==只用来比对两个变量的字节组合，实质所表示的意义则不重要。要知道两个对象是否真的相等，就得使用equals这个方法。

### 编写程序
开发类通常的经验：
1. 找出类应该做的事情
2. 列出实例变量和方法
3. 编写方法的伪代码
4. 编写方法的测试用程序
5. 实现类
6. 测试方法
7. 除错或重新设计

```
int randomNum = (int) (Math.random()*5);
```
其中（int）是一种“类型转换”。Math.random会返回double类型，它返回的是介于0~1之间的数字。
此章节的练习program在java_basics_practices中。

### Java函数库
#### ArrayList与数组的比较
```
//ArrayList
ArrayList <String> myList = new ArrayList<String>();
Strin a = new String("whoohoo");
myList.add(a);
String b = new String("Frog");
myList.add(b);
int theSize = myList.size();
Object o = myList.get(1);
myList.remove(1);
boolean isIn = myList.contains(b);
//一般数组
String [] myList = new String[2];
Strin a = new String("whoohoo");
myList[0]=a;
String b = new String("Frog");
myList[1]=b;
int theSize = myList.length;
String o = myList[1];
myList[1] = null;
boolean isIn = false;
for(String item in myList) {
    if(b.equals(item)) {
        isIn =  true;
        break;
    }
}
```
使用数组时，你会以特殊的数组语法来操作。这样的语法只能用在数组上。虽然
数组也是对象，但是它有自己的规则，你无法调用它的方法，最多只能存取它的length实例变量。

一般数组在创建时就必须确定大小。
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

创建远程服务steps:

1. 创建Remote接口
   定义了客户端会调用的方法。
   - 继承java.rmi.Remote
   - 声明所有方法都会抛出RemoteException
   - 确定所有参数和返回值都是primitive主数据类型或Serializable
    ```
    import jave.rmi.*;
    public interface MyRemote extends Remote{
        public String sayHello() throws RemoteException;
    }
    ```
2. 实现远程接口
   - 实现Remote这个接口
   - 继承UnicastRemoteObject(为了让对象拥有与远程有关的功能)
   - 编写声明RemoteException的无参数构造函数
   - 向RMI registry注册服务
    ```
    import java.rmi.*;
    import java.rmi.server.*;
    public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
        public String sayHello() {
            return "Server says, 'hey'";
        }
        public MyRemoteImpl() throws RemoteException{}
        public static void main(String[] args) {
            try{
                MyRemote service = new MyRemoteImpl();
                Naming.rebind("Remote Hello, service);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    ```
3. 产生stub和skeleton
    - 对实现出的类执行rmic
    ```
    rmic MyRemoteImpl
    ```
4. 执行rmiregistry
   从可以存取到该类的目录来启动
   ```
   rmiregistry
   ```
5. 启动服务
   ```
   java MyRemoteImpl
   ```

Q: 客户端如何取得stub对象? A：靠RMI registry。

```
MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello);
String s = service.sayHello();
```

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


