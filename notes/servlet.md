    #### 关于servlet
    servlet是http web服务器上运行的java程序。

    创建并执行servlet的步骤：
    1. 找出网页服务器上可以存放servlet的地方
    2. 取得servlet.jar用于编译servlet并添加到classpath上
    3. 通过extend过HttpServlet来编写servlet的类
   ```
   public class MyServletA extends HttpServlet {...}
   ```
    4. 编写HTML来调用servlet
   ```
   <a href="servlets/"></a>
   ```
    5. 