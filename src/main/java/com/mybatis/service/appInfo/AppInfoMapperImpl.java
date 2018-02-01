package com.mybatis.service.appInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.bean.AppInfo;
import com.mybatis.bean.AppInfoExample;
import com.mybatis.dao.AppInfoMapper;


@Transactional
@Service("AppInfoService")
public class AppInfoMapperImpl  implements AppInfoService{

	/**
	 * 接口对象
	 */
	@Autowired
	private AppInfoMapper appInfoMapper;

	@Override
	public int insert(AppInfo record) {
		try {
			return appInfoMapper.insert(record);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<AppInfo> selectByExample(AppInfoExample example) {
		try {
			return appInfoMapper.selectByExample(example);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteByExample(AppInfoExample example) {
		try {
			return appInfoMapper.deleteByExample(example);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteByPrimaryKey(long id) {
		try {
			return appInfoMapper.deleteByPrimaryKey(id);			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public AppInfo selectByPrimaryKey(long id) {
		try {
			return appInfoMapper.selectByPrimaryKey(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(AppInfo record) {
		try {			
			return appInfoMapper.updateByPrimaryKeySelective(record);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
