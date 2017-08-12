# HibernateLearn
learn hibernate  
## ����jar ��   
1��Hibernate ��ذ�    ����    
2�����ݿ������� ����       
3��log4j��־��  ��ѡ     
   
## ��дhibernate.cfg.xml    
1���������ݿ�����    
2���������ݿ�����    
3�������û���    
4����������    
5�����÷���     
`��Mysql�汾Ϊ5.0���� �����÷���ΪMySQL5Dialect`   
`<-��װhibernate������Զ���������->`    
      
## ��дʵ����
���ر�Ҫ��        

## ����ENTITY.hbm.xml    

1������ӳ����

	��������
	<id name="id" type="int">
        <column name="ID" />
        <generator class="assigned" />
	</id>   

	 ����һ������
	<property name="username" type="java.lang.String">
		<column name="USERNAME" />
	</property>    
   
  `������������  <generator class="increment" />`    
     
2����hibernate.cfg.xml������ӳ����      
	
	<mapping resource="com/hibernate/entity/User.hbm.xml"/>    
	
`<-��װhibernate������Զ���������->`   
    
## ��д�����ɱ��
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
	MetadataImplementor metadataImplementor =(MetadataImplementor) new    	MetadataSources(serviceRegistry).buildMetadata();    
	SchemaExport export = new SchemaExport();    
	export.create(EnumSet.of(TargetType.DATABASE),metadataImplementor);      
	
`Hibernate5.2�汾 SchemaExport ���ɱ�ķ���Ϊ�������� `    

## ��д�� �Ա����CURD����

���������Ϊ��
	
	//��ȡhibernate.cfg.xml�ļ�
	Configuration cfg = new Configuration().configure();
	//����SessionFactory
	SessionFactory sf = cfg.buildSessionFactory();
	//ȡ��Session
	Session session = sf.openSession();
	//��������
	session.beginTransaction();
	//��������
	User user = new User("xm", "С��", "123");
	session.save(user);
	//�ύ����
	session.getTransaction().commit();
	//�ر�Session
	session.close();
    
## ʹ�õ���ģʽ��дMySessionFactory    
��ΪSessionFactory���������࣬��һ�����ݿ����ֻ��Ӧһ��SessionFactory�����Ҫ���õ���ģʽ��          

1����дMySessionFactory

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

2��ʹ��MySessionFactory     

	Session session = MySessionFactory.getSessionFactory().openSession();


## ʹ��ע��ӳ��ʵ����    
1��ȷ�����jar������         
2����дʵ����ʹ��ע��          
`@Entity  @Id  @Column��`     
3����hibernate.cfg.xml��ӳ��ʵ����
	
	<mapping class = "com.hibernate.entity.Manager"/>

4��SchemaExport���ɱ��

## ����

### ʹ��log4j��־

��дlog4j.properties

	<span style="font-size:12px;">### direct log messages to stdout ###  
	log4j.rootLogger=warn, stdout  
	log4j.appender.stdout=org.apache.log4j.ConsoleAppender  
	log4j.appender.stdout.Target=System.out  
	log4j.appender.stdout.layout=org.apache.log4j.PatternLayout  
	log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n  
	</span>

`log4j.properties����srcĿ¼��`
  




	



         