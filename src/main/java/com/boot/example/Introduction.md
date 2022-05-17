###  

### 参数处理原理

-  handlerMapping中找到处理请求的handler(Controller.method())
-  为当前Handler找一个适配器HandlerAdapter



#### 1、HandlerAdapter

![](D:\IDEA\项目\MGHF\demo\src\main\resources\static\QQ截图20220308103030.png)

0. 支持方法上标注@RequestMapping
1. 支持函数式编程

#### 2、执行目标方法

```java
// DispatcherServlet -- doDispatch
mv = ha.handle(processedRequest, response, mappedHandler.getHandler());                  
```

