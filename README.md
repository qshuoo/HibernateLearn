# HibernateLearn
learn hibernate  
## 导入jar 包   
1、Hibernate 相关包    必须    
2、数据库驱动包 必须       
3、log4j日志包  可选     
   
## 编写hibernate.cfg.xml    
1、设置数据库驱动    
2、设置数据库链接    
3、设置用户名    
4、设置密码    
5、设置方言     
`若Mysql版本为5.0以上 所配置方言为MySQL5Dialect`   
`<-安装hibernate插件可自动配置生成->`    
      
## 编写实体类
无特别要求        

## 配置ENTITY.hbm.xml    

1、配置映射类

	配置主键
	<id name="id" type="int">
        <column name="ID" />
        <generator class="assigned" />
	</id>   

	 配置一般属性
	<property name="username" type="java.lang.String">
		<column name="USERNAME" />
	</property>    
   
  `配置主键递增  <generator class="increment" />`    
     
2、在hibernate.cfg.xml中配置映射类      
	
	<mapping resource="com/hibernate/entity/User.hbm.xml"/>    
	
`<-安装hibernate插件可自动配置生成->`   
    
## 编写类生成表格
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
	MetadataImplementor metadataImplementor =(MetadataImplementor) new    	MetadataSources(serviceRegistry).buildMetadata();    
	SchemaExport export = new SchemaExport();    
	export.create(EnumSet.of(TargetType.DATABASE),metadataImplementor);      
	
`Hibernate5.2版本 SchemaExport 生成表的方法为上述过程 `    

## 编写类 对表进行CURD操作

以添加数据为例
	
	//读取hibernate.cfg.xml文件
	Configuration cfg = new Configuration().configure();
	//建立SessionFactory
	SessionFactory sf = cfg.buildSessionFactory();
	//取得Session
	Session session = sf.openSession();
	//开启事务
	session.beginTransaction();
	//操作数据
	User user = new User("xm", "小明", "123");
	session.save(user);
	//提交事务
	session.getTransaction().commit();
	//关闭Session
	session.close();
    
## 使用单例模式编写MySessionFactory    
因为SessionFactory是重量级类，故一个数据库最好只对应一个SessionFactory，这就要采用单例模式了          

1、编写MySessionFactory

	public class MySessionFactory {
		private static SessionFactory sessionFactory = null;
		
		private MySessionFactory() {
		}
		static {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}   
	}

2、使用MySessionFactory     

	Session session = MySessionFactory.getSessionFactory().openSession();


## 使用注解映射实体类    
1、确保相关jar包导入         
2、编写实体类使用注解          
`@Entity  @Id  @Column等`     
3、在hibernate.cfg.xml中映射实体类
	
	<mapping class = "com.hibernate.entity.Manager"/>

4、SchemaExport生成表格

## 其他

### 使用log4j日志

编写log4j.properties

	<span style="font-size:12px;">### direct log messages to stdout ###  
	log4j.rootLogger=warn, stdout  
	log4j.appender.stdout=org.apache.log4j.ConsoleAppender  
	log4j.appender.stdout.Target=System.out  
	log4j.appender.stdout.layout=org.apache.log4j.PatternLayout  
	log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n  
	</span>

`log4j.properties放在src目录下`
  




	



         