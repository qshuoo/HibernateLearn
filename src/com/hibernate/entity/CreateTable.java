package com.hibernate.entity;

import java.util.EnumSet;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

public class CreateTable {
	public static void main(String[] args) {
		//hibernate5.2创建表的方法
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		MetadataImplementor metadataImplementor =(MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata(); 
		SchemaExport export = new SchemaExport();
		export.create(EnumSet.of(TargetType.DATABASE),metadataImplementor);  
	}

}
