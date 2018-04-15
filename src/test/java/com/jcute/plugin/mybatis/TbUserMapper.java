package com.jcute.plugin.mybatis;

import java.util.List;
import java.util.Map;

public interface TbUserMapper{
	
	public List<Map<String,Object>> selectUsers();
	
}