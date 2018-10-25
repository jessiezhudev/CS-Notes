## 第一张 基础编程模型
### Java程序的基础结构

要执行一个Java程序，首先需要用javac命令编译它，然后用java命令运行它。

Java语言最基本的原始数据类型：整型（int）、浮点型（double）、布尔型（boolean）、字符型（char)

## 第二章 排序
排序就是将一组对象按照某种逻辑顺序重新排列的过程。比如，信用卡中的交易账单按照日期排序。
### 初级排序算法
我们关注的对象是重新排列数组元素的算法，其中每个元素都有一个主键。排序算法的目标是将所有元素的主键按照某种方式排列（通常按照大小或是字母顺序）。
“排序算法类模板”中的Example类展示了我们的习惯约定：我们会将排序代码放在类的sort()方法中，该类还将包含辅助函数less()和exch()以及一个测试用例main()。
大多数情况下，我们的排序代码只会通过两个方法操作数据：less()方法对元素进行比较，exch()方法将元素交换位置。
排序算法类模板：
```
public class Example{
    public static void sort(Comparable[] a)
    {}
    private static boolean less(Comparable v, Comparable w)
    {return v.compareTo(w)<0;}
}
```
#### 运行时间
我们要评估算法的性能。首先，要计算各个排序算法在不同的随机输入下的基本操作的次数（包括比较和交换，或者是读写数组的次数）。然后我们用这些数据来估算算法的相对性能。

额外的内存使用：排序算法的额外开销和运行时间是同等重要的。排序算法可以分为两类：除了函数调用所须的栈和固定数目的实例变量之外无需额外内存的原地排序算法，以及需要额外内存空间储存另一份数组副本的其他排序算法。

在Java中，在创建自己的数据类型时，我们只要实现Comparable接口就能保证用例代码可以将其排序。要做到这一点，只需要实现一个compareTo()方法来定义目标对象的自然次序。

#### 选择排序
不断找到数组中最小的那个数，将它排在最前面。
```
public class Selection{
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i <N; i++) {
            int min = i;
            for (int j = i+1; J<N; j++) {
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
}
```

