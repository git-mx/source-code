Spring是基于事件驱动的框架
Spring的时间驱动本质上实际上是采用的观察者模式，即事件发布-事件监听
观察者模式的好处是什么呢？举个用户注册的例子
假设某个商城系统，的用户注册这件事情使用传统的同步机制来做那么它的方法应该是这样的
public class UserService {
    @Autowired
    EmailService emailService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    OtherService otherService;
    public void register(String name) {
        System.out.println("用户：" + name + " 已注册！");
        emailService.sendEmail(name); //发送邮件
        scoreService.initScore(name); //初始化积分
    }
}
这样做有什么不好的地方呢现在，假设伴随用户注册会拥有更多的服务，比如发送短信、发送优惠券啥的，我们需要就需要修改
上面的UserService来注入对应的服务的bean，并且修改register方法。而事实是用户注册服务它本身其实并不关心什么邮件发送、
初始化积分什么的这些业务逻辑，它只需要完成用户注册即可，其他的那些业务，我就发布一个事件出去，你们这些其他
的业务就来订阅这个事件，去完成你们自己的事情吧。这样做的好处是显而易见的，以后比如又增加了什么发送短信、发送优惠券的业务，
那我并不会修改用户注册业务的代码，在新增业务逻辑的时候让这个业务也来监听我发布的事件就好了。
在Spring的事件驱动的实现方式如下：
ApplicationContext通过ApplicationEvent类和ApplicationListener接口进行事件处理。 
如果将实现ApplicationListener接口的bean注入到上下文中，则每次使用ApplicationContext发布ApplicationEvent时，都会通知该bean。
也就是说
    - 只要是实现了ApplicationEventPublisherAware的并且定义了发送方法的类就具备发布事件的能力
    - 只要继承了ApplicationListener接口的并且定义了接受方法的类就具备监听事件的能力，参见 RegisterService
    - 只要集成了ApplicationEvent接口的类的对象就能被当做事件被当做事件传输实体，被ApplicationEventPublisherAware发送，
      被ApplicationListener接受

