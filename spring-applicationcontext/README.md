本项目用于演示ApplicationContext的扩充功能与高级用法
ApplicationContext其实是在BeanFactory基础上进行扩展的，它包含BeanFactory的所有功能与属性
ApplicationContext的功能有以下：
  A> 准备上下文环境，即初始化前的准备工作，例如对系统属性或者环境变量进行准备和验证。
     以例子customapplication为例说明自定义ApplicationContext的使用
  B> 初始化BeanFactory，并进行XML文件读取
  C> 对BeanFactory进行各种功能填充
     Qualifier与@Autowired，就是ApplicationContext在BeanFactory基础上填充的功能
     具体的扩展功能有以下：
     1.增加对SpEL语言的支持，见实例sqel
     2.增加属性注册编辑器，见实例propertyeditor1\propertyeditor2\propertyeditor3
     3.添加ApplicationContextAwareProcessor处理器，见实例processor1\processor2
     4.提供国际化支持 见实例locale
     5.对Spring事件的支持 实例见source-code里的spring-event
     6.初始化非延迟加载单例
       这里面包含Converter、
       冻结配置 冻结所有的bean定义，说明注册的bean定义将不被修改或进行任何进一步的处理
       初始化非延迟加载 
  D> 子类覆盖方法做外的处理
  E> 激活各种BeanFactory处理器。
  F> 注册拦截bean创建的bean处理器，这里只是注册，真正的调用是在getBean时候。
  G> 为上下文初始化Message源，即对不同语言的消息体进行国际化处理。
  H> 初始化应用消息广播器，并放入“applicationEventMulticaster” bean中。
  I> 留给子类来初始化其他的bean。
  J> 在所有注册的bean中查找listenerbean， 注册到消息广播器中。
  K> 初始化剩下的单实例（非惰性的）。
  L> 完成刷新过程，通知生命周期处理器lifecycleProcessor刷新过程，同时发出Context­RefreshEvent通知别人。