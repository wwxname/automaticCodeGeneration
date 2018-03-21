package com.td.spm.generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Project {
	public static Properties p = new Properties();
	public static String src = "/src/main/java/";
	static {
		InputStream in = Project.class.getClassLoader().getResourceAsStream("ProConfig.property");
		try {
			p.load(in);
			p.getProperty("apiHandlerClassPath");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String apiProBasePath = System.getProperty("user.dir");
	public String parentBasePath = new File(apiProBasePath).getParent();

	// api
	public String apiCodeBasePath = new File(apiProBasePath + "/src/main/java").getPath();

	public String apiHandlerBasePath = new File(
			apiProBasePath + "/src/main/java/" + FmUtil.ClassPathToDirPath(p.getProperty("apiHandlerClassPath")))
					.getPath();

	// program
	public String programRepositoryBasePath = new File(parentBasePath + "/" + p.getProperty("programName") + src
			+ FmUtil.ClassPathToDirPath(p.getProperty("programRepository"))).getPath();

	public String programServiceBasePath = new File(parentBasePath + "/" + p.getProperty("programName") + src
			+ FmUtil.ClassPathToDirPath(p.getProperty("programService"))).getPath();

	public String programServiceImplBasePath = new File(parentBasePath + "/" + p.getProperty("programName") + src
			+ FmUtil.ClassPathToDirPath(p.getProperty("programServiceImpl"))).getPath();

	public String programApiImplBasePath = new File(parentBasePath + "/" + p.getProperty("programName") + src
			+ FmUtil.ClassPathToDirPath(p.getProperty("programApiImpl"))).getPath();
	
	public String programeMapperBasePath =  new File(parentBasePath + "/" + p.getProperty("programName") + "/src/main/resources/"
			+ FmUtil.ClassPathToDirPath(p.getProperty("programMapper"))).getPath();

	public String getProgrameMapperBasePath() {
		return programeMapperBasePath;
	}

	// rest
	public String restControllerBasePath = new File(parentBasePath + "/" + p.getProperty("restName") + src
			+ FmUtil.ClassPathToDirPath(p.getProperty("restController"))).getPath();
	

	// classpath
	public String apiHandlerClassPath = p.getProperty("apiHandlerClassPath");
	public String programApiImpl = p.getProperty("programApiImpl");
	public String programRepository = p.getProperty("programRepository");
	public String programService = p.getProperty("programService");
	public String programServiceImpl = p.getProperty("programServiceImpl");
	public String restController = p.getProperty("restController");
	public String programMapperNamespace = p.getProperty("programMapperNamespace");

	
	public String getProgramMapperNamespace() {
		return programMapperNamespace;
	}

	public String getApiHandlerClassPath() {
		return apiHandlerClassPath;
	}

	public String getProgramApiImpl() {
		return programApiImpl;
	}

	public String getProgramRepository() {
		return programRepository;
	}

	public String getProgramService() {
		return programService;
	}

	public String getProgramServiceImpl() {
		return programServiceImpl;
	}

	public String getRestController() {
		return restController;
	}

	public String getProgramServiceBasePath() {
		return programServiceBasePath;
	}

	public String getProgramServiceImplBasePath() {
		return programServiceImplBasePath;
	}

	public String getProgramApiImplBasePath() {
		return programApiImplBasePath;
	}

	public String getRestControllerBasePath() {
		return restControllerBasePath;
	}

	public String getApiProBasePath() {
		return apiProBasePath;
	}

	public String getParentBasePath() {
		return parentBasePath;
	}

	public String getApiCodeBasePath() {
		return apiCodeBasePath;
	}

	public String getApiHandlerBasePath() {
		return apiHandlerBasePath;
	}

	public String getProgramRepositoryBasePath() {
		return programRepositoryBasePath;
	}

}
