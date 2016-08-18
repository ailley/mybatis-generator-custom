package com.h.generate;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GenerateCode {

	public static void main(String[] args) throws Exception {
		new GenerateCode().generateMain();
	}

	/**
	 * 生成主数据代码
	 * @throws Exception
	 */
	public void generateMain() throws Exception {
		String f2 = GenerateCode.class.getResource("generate_config_charisma.xml").getPath();
		generate(f2);
	}

	public static void generate(String f) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(f);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for(String s : warnings) {
			System.err.println(s);
		}
	}

}
