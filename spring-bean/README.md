该项目是演示XML配置文件中bean的各种属性
bean的属性有下面
    -scope 指定bean的作用域
    -singleton 指定bean是单例的
    -abstract 当设置为true时，将该bean仅仅作为模板使用，应用程序上下文不会去预先
              初始化它
    -lazy-init 当设置为true时，延迟加载，该bean不会在上下文启动时提前被实例化，
               而是在应用程序第一次去容器getBean时被实例化，只对singleton的bean
               起作用
    -autowired 自动装配，所谓自动装配就是Spring IOC容器可以自动装配互相协作的bean
               之间的关联关系。
    -dependency-check 依赖检查
    -depends-on 告诉IOC容器在实例化该bean之前，先实例化depends-on指定的bean
    -autowire-candidate 设为false，容器在查找自动装配对象时，将不考虑该bean，
                        即它不会被考虑作为其他bean自动装配的候选者，但是该bean本身可以使用自动装配来注入其他bean
    -primary 该bean优先被注入
    -init-method 初始化bean时调用的方法
    -destroy-method 容器销毁之前所调用的方法
    -factory-method 当调用factory-method所指向的方法时，才开始实例化bean
    -factory-bean 调用静态工厂方法的方式创建bean
bean的子元素
    -meta 元数据，当需要使用里面的信息时可以通过key获取
    -lookup-method 就是让<lookup-method>标签中name属性指定的方法，返回<lookup-method>标签中bean属性指定的实体类型
                   bean属性指定的类一定是非单例模式的
    -replaced-method 可以在运行时调用新的方法替换现有的方法，还能动态的更新原有方法的逻辑
    -constructor-arg 对bean自动寻找对应的构造函数，并在初始化的时候将设置的参数传入进去
    -property 类的属性字段赋值
    -qualifier 通过Qualifier指定注入bean的名称
Spring的IOC容器其实就是一个内存中的map，map的key就是beanName，也就是<bean标签指定的id属性
IOC容器中bean的载入过程如下：
1.读取xml文件并获取对xml文件的验证模式
2.根据解析得到的element节点得到对应的document对象
3.将document对象转化成bean在IOC容器的表现形式：BeanDefinition对象
4.将BeanDefinition注册到IOC容器中（内存中的map）