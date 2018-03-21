package com.td.spm.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.td.masterdata.entity.common.MasterEntity;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import freemarker.template._TemplateAPI;


public class FreeMarkerUtil {  
	
	    public static Version version = new Version(_TemplateAPI.VERSION_INT_2_3_0);
	    public static Configuration config;  
	    public static Template template;  
	    public static DefaultObjectWrapperBuilder defaultObjectWrapperBuilder;
	    static {    
	        config = new Configuration(version);     
	        config.setDefaultEncoding("UTF-8");          
	        defaultObjectWrapperBuilder = new DefaultObjectWrapperBuilder(version);         
	        try {  
	            config.setClassForTemplateLoading(JavaGeneratorClient.class, "template");
	            config.setObjectWrapper(defaultObjectWrapperBuilder.build());  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    public static MasterEntity<?> masterEntity=null;
	    
	    public static Project p =new Project();
		public static ClazzSet cs =null;
	    
	    public static void createJavaFile(MasterEntity<?> m){
	    	init(m);    	
			createApiHandler("Handler");
			createProgramRepository("Repository");
			createProgramService("Service");
			createProgramServiceImpl("ServiceImpl");
			createProgramApiImpl("HandlerImpl");
			createRestController("Controller");
			
		}
	    public static void createMapperFile(MasterEntity<?> m){
	    	init(m);        	
	    	for(Property pp :cs.getPropertys()){
	    		System.err.println(pp.getTypeName());
	    		System.err.println(pp.getJavePackageType());
	    		System.err.println(pp.getTransient());
	    		System.err.println("----------------");
	    		
	    	}
			createMapper("Mapper");
			
		}

		private static void createMapper(String string) {
			// TODO Auto-generated method stub
			String src = null;
			src = p.getProgrameMapperBasePath()+"\\";
			src=src +cs.getClassName()+string+".xml";
			createFile(string,src);	
			
		}
		private static void createApiHandler(String string) {
			// TODO Auto-generated method stub
			String src = null;
			src = p.getApiHandlerBasePath()+"\\";
			src=src +cs.getClassName()+string+".java";
			createFile(string,src);		
		}

		private static void createRestController(String string) {
			// TODO Auto-generated method stub
			String src = null;
			src = p.getRestControllerBasePath()+"\\";
			src=src +cs.getClassName()+string+".java";
			createFile(string,src);	
		}

		private static void createProgramApiImpl(String string) {
			// TODO Auto-generated method stub
			String src = null;
			src = p.getProgramApiImplBasePath()+"\\";
			src=src +cs.getClassName()+string+".java";
			createFile(string,src);
			
			
		}

		private static void createProgramServiceImpl(String string) {
			// TODO Auto-generated method stub
			String src = null;
			src = p.getProgramServiceImplBasePath()+"\\";
			src=src +cs.getClassName()+string+".java";
			createFile(string,src);
			
		}

		private static void createProgramService(String string) {
			// TODO Auto-generated method stub
			String src = null;
			src = p.getProgramServiceBasePath()+"\\";
			src=src +cs.getClassName()+string+".java";
			createFile(string,src);
			
		}

		private static void createProgramRepository(String string) {
			// TODO Auto-generated method stub
			String src = null;
			src = p.getProgramRepositoryBasePath()+"\\";
			src=src +cs.getClassName()+string+".java";
			createFile(string,src);
			
		}

		private static void createFile(String string,String src) {
			// TODO Auto-generated method stub
			String str = src;
			File f = null;
			Map<String,Object> map = null;
			Writer writer =null;
			try {
				template = config.getTemplate(string+".ftl");
				f =new File(str);
				if(f.exists()){
					return;
				}	
				f.createNewFile();				
				writer = new FileWriter(f);
				map = new HashMap<String,Object>();
				try {
					map.put("ClazzSet", cs);
					map.put("Project", p);
					template.process(map, writer);
					writer.flush();
					System.err.println("生成完毕");
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			
				}finally{				
					writer.close();
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		private static void init(MasterEntity<?> m) {
			// TODO Auto-generated method stub
			masterEntity=m;
			try {
				cs=new ClazzSet(masterEntity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
   
        
}  