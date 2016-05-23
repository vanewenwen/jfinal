package com.demo.config;

import com.demo.controller.StudentController;
import com.demo.model.Student;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * 核心Config配置文件
 * 
 * @author vane2016
 */
public class DemoConfig extends JFinalConfig {

	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	public void configRoute(Routes me) {
		me.add("/nihao", StudentController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		// 配置c3p0数据库连接池插件
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/demo", "root",
				"root");
		me.add(cp);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		// 映射Blog表到student模型
		arp.addMapping("student", "id", Student.class);
		// arp.addMapping("user", User.class);
		// arp.addMapping("article", "article_id", Article.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}
}