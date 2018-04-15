package com.jcute.plugin.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.jcute.core.annotation.Configuration;

@Configuration
@EnableMyBatis
public class TestMyBatisPlugin{

	public static void main(String[] args){
		// JCuteApplication.run(TestMyBatisPlugin.class);
		PooledDataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","123456");
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("default",transactionFactory,dataSource);
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
		configuration.addMappers("com.jcute.plugin.mybatis");
		SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		TbUserMapper mapper = sqlSession.getMapper(TbUserMapper.class);
		System.out.println(mapper.selectUsers());
	}

}