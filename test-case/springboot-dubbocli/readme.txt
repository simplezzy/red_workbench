springboot+dubbo的空指针问题

    主要原因：spring 扫描的时候根本无法识别@Reference 同一方面，dubbo的扫描也无法识别Spring @Controller
    所以两个扫描的顺序要排列好，如果先扫了controller，这时候把控制器都实例化好了，再扫dubbo的服务，就会出现空指针。

    dubbo-provider.xml:提供者先扫描spring框架，完成spring部分的扫描，然后将为dubbo框架提供服务;
    消费者部分相反，先扫描dubbo服务，后扫描spring部分

