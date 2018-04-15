package com.jcute.plugin.mybatis.scan;

import com.jcute.core.scan.PackageScannerFilter;
import com.jcute.core.scan.imp.DefaultPackageScanner;
import com.jcute.core.util.ClassUtil;

public class ClassPathMapperScanner extends DefaultPackageScanner{
	
	public ClassPathMapperScanner(){
		super(ClassUtil.getDefaultClassLoader());
		this.addPackageScannerFilter(new ClassPathMapperScannerFilter());
	}
	
	public static class ClassPathMapperScannerFilter implements PackageScannerFilter{
		@Override
		public boolean doFilter(Class<?> target){
			return target.isInterface();
		}
	}
	
}