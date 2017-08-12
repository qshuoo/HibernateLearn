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

         