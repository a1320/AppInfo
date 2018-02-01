package com;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.bean.AppInfo;
import com.mybatis.bean.AppInfoExample;
import com.mybatis.bean.AppInfoExample.Criteria;
import com.mybatis.dao.AppInfoMapper;
import com.mybatis.service.appInfo.AppInfoService;


public class MybatisTest {
	
	/**
	 * 测试MyBatis逆向工程生成文件
	 */
	/*@Test
	public void testMbg() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("src/main/resources/test/mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}*/
	
	
	/**
	 * 查询所有信息(自定义方法)
	 */
	@Test
	public void testSelectInfo() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("test/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		System.out.println(openSession);
		try {
			
			AppInfoMapper mapper = openSession.getMapper(com.mybatis.dao.AppInfoMapper.class);			
			
			List<AppInfo> list = mapper.selectByExample(null);
			
			//System.out.println(list);
			
			for (AppInfo appInfo : list) {
				System.out.println("softwarename="+appInfo.getSoftwarename());
			}
		} finally {
			openSession.close();
		}
	}

	
	
	
	/**
	 * 测试springMvc
	 */
	@Test
	public void ServiceTest() {
		AppInfoExample example = new AppInfoExample();		
		Criteria criteria = example.createCriteria();
		criteria.andSoftwarenameLike("%锁%");
		
		List<AppInfo> list = new ArrayList<>();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// providerService是业务类供应商接口
		AppInfoService Service = (AppInfoService) ctx.getBean("AppInfoService");

		list = Service.selectByExample(null);
		
		for (AppInfo info : list) {
			System.out.println("------------"+info.getSoftwarename());
			
		}

		
	}


}
