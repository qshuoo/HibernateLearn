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
<-��װhibernate������Զ���������->    
      
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
         