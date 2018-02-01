package com.mybatis.service.appInfo;

import java.util.List;

import com.mybatis.bean.AppInfo;
import com.mybatis.bean.AppInfoExample;

public interface AppInfoService {

	/**
	 * 按对象删除
	 */
    public int deleteByExample(AppInfoExample example);

    /**
	 * 按ID删除
	 */
    public int deleteByPrimaryKey(long id);

    /**
	 * 插入对象
	 */
    public int insert(AppInfo record);

    /**
	 * 按条件查询对象集合
	 */
    public List<AppInfo> selectByExample(AppInfoExample example);

    /**
	 * 按ID查询一个对象
	 */
    public AppInfo selectByPrimaryKey(long id);

    /**
	 * 更新一个对象
	 */
    public int updateByPrimaryKeySelective(AppInfo record);

   

}
