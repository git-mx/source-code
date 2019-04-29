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
2.解析xml文件并根据解析得到的element节点得到对应的document对象
3.将document对象转化成bean在IOC容器的表现形式：BeanDefinition对象
4.将BeanDefinition注册到IOC容器中（内存中的map）

bean的注册与加载，写的乱七八糟，凑合看看吧
    1.转换对应的beanName
      从xml获取的name属性不一定就是beanName（只有id属性才一定是beanName），因此对于拥有name或者alias属性的<bean标签，
      需要对其进行beanName转换，转换大致分成下面两种
      A> 去除FactoryBean的修饰符，也就是如果name="&aa"，那么会首先去除调&得到name="aa"
      B> 取<alias标签最终的beanName，例如别名A指向id为B的bean，那么最终会返回B
    2.尝试从缓存中加载单例
      单例bean在Spring的同一个容器内只会被创建一次，后续再获取bean，就直接从单例缓存中获取了。而这里只是说的加载，首先尝试从缓存中加载，
      如果加载不成功则从singletonFactories中加载。因为在创建单例bean的时候会存在依赖注入的情况，而在创建依赖的时候为了避免循环依赖，
      在Spring中创建bean的原则是不等bean创建完成就会将创建bean的ObjectFactory提早曝光加入到缓存中，当其他bean在注册时需要依赖该bean
      时，就直接使用该bean的ObjectFactory.具体步骤如下：
      A> 首先尝试从singletonObjects中获取实例
      B> 如果获取不到再从earlySingletonObjects里面获取
      C> 如果还没获取到，再尝试从singletonFactories里面获取beanName对用的ObjectFactory，并且从singletonFactories里面remove掉这个
         ObjectFactory。
      用于存储bean的man有以下
      singletonObjects 用于保存beanName与创建bean实例之间的关系 beanName -> bean instance
      singletonFactories 用于保存beanName与创建bean工厂之间的关系 beanName -> ObjectFactory
      earlySingletonObjects 也是保存beanName和创建bean实例之间的关系，与singletonObjects的不同之处在于，当一个单例bean被放在这里面后，
                            那么当bean还在创建过程中，就可以通过getBean方法获取到了，其目的是用于检测循环引用。
      registeredSingletons 用来保存当前已经注册了的bean
    3.实例化bean，（其实就是bean的实例中获取对象）
      我们在得到bean的实例后要做的第一步就是调用方法来检测一下正确性，其实就是检测当前bean是否是FactoryBean类型的bean，
      如果是，那么需要该bean对应的FactoryBean实例中的getObject方法的返回值作为返回值。
      无论是从缓存中获取的还是通过不同的scope策略加载的bean都只是最原始的bean状态，并不一定是我们最终想要的bean。
      例如，加入现在需要对工厂bean进行处理，那么这里得到的bean只是工厂bean的初始状态，但是我们真正想要的是工厂bean中定义的factory-method方法中
      返回的bean。初始化完bean后，需要进行后置处理：在Spring获取bean的规则中有这样一条：尽可能保证所有的bean初始化后都会调用注册的
      BeanPostProcesser的postProcessAfterInitialization方法进行后置处理，在实际开发过程中大可以针对此特性设计自己的业务逻辑。
    4.获取单例 如果在缓存中找不到对应的单例bean，则重头开始bean的加载。步骤如下：
      A> 检查缓存是否存在
      B> 若没有加载，则记录beanName的正在加载状态。
      C> 加载单例前记录加载状态。
      D> 通过调用参数传入的ObjectFactory的个体0均ect方法实例化bean。
      E> 加载单例后的处理方法调用。
      F> 将结果记录至缓存并删除加载bean过程中所记录的各种辅助状态。
      G> 返回处理结果。
    5.准备创建bean
      A> 根据设置的class属性或者根据classl'如ne来解析Class。
      B> 对override属性进行标记及验证。@Override注解实际上就是利用lookup-method和replace-method来实现的
      C> 应用初始化前的后处理器，解析指定bean是否存在初始化前的短路操作。
      D> 创建beano
    6.原型模式的依赖检查（其实就是循环依赖检查）
      只有在单例情况下才会尝试解决循环依赖，如果存在A中有B的属性，B中有A的属性，那么当依赖注入的时候，就会产生当A还没创建完成的时候因为对于B的创建
      再次返回创建A，再次创建A的是时候因为A中有属性B，又会去创建B，这样就不断的重复创建。
    7.创建bean
      A> 如果是单例则需要首先清除缓存。
      B> 实例化bean，将Bean.Definition转换为BeanWrapper。
         如果存在工厂方法则使用工厂方法进行初始化。
         一个类有多个构造函数，每个构造函数都有不同的参数，所以需要根据参数锁定构造函数并进行初始化。
         如果既不存在工厂方法也不存在带有参数的构造函数，则使用默认的构造函数进行bean的实例化。
      C> MergedBeanDefinitionPostProcessor的应用。
         bean合并后的处理，Autowired注解正是通过此方法实现诸如类型的预解析。
      D> 依赖处理。
      E> 属性填充。 将所有属性填充至bean的实例中。
      F> 循环依赖检查。
      G> 注册DisposableBean。
      H> 完成创建井返回。
    6.将存储XML配置文件的GernericBeanDefinition转换为RootBeanDefinition
      意思就是缓存中bean的原型ObjectFactory中存储的对象是GernericBeanDefinition
      因为从XML配置文件读取到的bean信息是存储在GernericBeanDefinition中的，但是所有的bean后续处理都是针对于RootBeanDefinition的，所以这里
      必须要进行转换，转换的同时，如果父类的bean不为空的话，则会一并合并父类的属性
    7.寻找依赖
      因为bean 的初始化过程中很可能会用到某些属性，而某些属性很可能是动态配置的，并
      且配置成依赖于其他的bean，那么这个时候就有必要先加载载依赖的bean，所以，在Spring 的
      加载顺寻中，在初始化某一个bean的时候首先会初始化这个bean所对应的依赖。
    8.针对不同的scope进行bean的创建
      在Spring中存在着不同的scope，其巾默认的是singleton，但是还有些其他
      的配置诸如prototype、 request之类的。 在这个步骤中，Spring会根据不同的配置进行不同的初
      始化策略。
    9.类型转换
      程序到这里返回bean后已经基本结束了，通常对该方法的调用参数requiredType是为空的，
      但是可能会存在这样的情况，返回的bean其实是个String，但是requiredType却传人Integer
      类型，那么这时候本步骤就会起作用了，它的功能是将返回的bean转换为requiredType所指定
      的类型。 当然，String转换为Integer是最简单的一种转换，在Spring中提供了各种各样的转换
      器，用户也可以自己扩展转换器来满足需求。
      经过上面的步骤后bean的加载就结束了，这个时候就可以返回我们所需要的忱an 了
ApplicationContext与BeanFactory
  ApplicationConext其实是BeanFactory的扩展，ApplicationConext包含了BeanFactory的所有功能，
  另外还提供了其他的扩展功能：
  A> 准备上下文环境，即初始化前的准备工作，例如对系统属性或者环境变量进行准备和验证。
     通过例子
  B> 初始化BeanFactory，并进行XML文件读取
  C> 对BeanFactory进行各种功能填充
     Qualifier与@Autowired，就是ApplicationContext在BeanFactory基础上填充的功能
     具体填充的功能如下
     1.增加对SpEL语言的支持
     
  D> 子类覆盖方法做额外的处理
  E> 激活各种BeanFactory处理器。
  F> 注册拦截bean创建的bean处理器，这里只是注册，真正的调用是在getBean时候。
  G> 为上下文初始化Message源，即对不同语言的消息体进行国际化处理。
  H> 初始化应用消息广播器，并放入“applicationEventMulticaster” bean中。
  I> 留给子类来初始化其他的bean。
  J> 在所有注册的bean中查找listenerbean， 注册到消息广播器中。
  K> 初始化剩下的单实例（非惰性的）。
  L> 完成刷新过程，通知生命周期处理器lifecycleProcessor刷新过程，同时发出Context­RefreshEvent通知别人。