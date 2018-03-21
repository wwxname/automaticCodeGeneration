package com.td.spm.generator;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.td.masterdata.entity.common.MasterEntity;

public class ClazzSet {

	private Class<?> clazz = null;

	private String javaImport = null;

	private String className = null;//Student
	
	private String classLowerName = null;

	private String classTypeName = null;//com.td

	public String getClassTypeName() {
		return classTypeName;
	}
	private String tableName = null;

	private String code = null;

	private List<Property> propertys = new LinkedList<Property>();;
	private List<ClazzSet> clazzs = new LinkedList<ClazzSet>();
	

	public List<ClazzSet> getClazzs() {
		return clazzs;
	}

	ClazzSet(MasterEntity<?> o) throws Exception {

		if (o.getCode() != null) {
			try {
				Long l = (Long) o.getCode();
				l.toString();
				code = "Long";
			} catch (Exception e) {
				code = "String";
			}

		} else {
			throw new Exception("Code没有初始化");
		}
		this.clazz = o.getClass();
        init();
	}

	ClazzSet(Class<?> c) throws Exception {
		this.clazz = c;
        init();
	}

	public void init() {
		className = this.clazz.getSimpleName();
		classLowerName = className.toLowerCase().substring(0, 1)+className.substring(1, className.length());
		javaImport = "import" + " " + clazz.getName() + ";";
		classTypeName = clazz.getName();
		tableName = this.clazz.getAnnotation(Table.class).name();
		Property p = new Property();
		p.setJavaType(this.code);
		p.setTypeName("code");
		p.setTable_column("code");
		p.setTransient(false);
		this.propertys.add(p);
		
		initSupper(this.clazz);
		initSelf(this.clazz);
	}

	public void initSelf(Class<?> clazz) {
		Field[] fs = clazz.getDeclaredFields();
		for (Field f : fs) {
			
			Property p = new Property();
			p.setTransient(false);
			if (f.getAnnotation(Transient.class) != null) {
				p.setTransient(true);
				p.setJavaType(f.getType().getSimpleName());
				p.setTypeName(f.getName());
				p.setTable_column(FmUtil.TuoToZiduan(f.getName()));
				p.setJavePackageType(f.getGenericType().getTypeName());
				if(p.getJavePackageType().startsWith("com.td")){
					int flag = 0;
					for(ClazzSet clazzSet :clazzs){
						if(clazzSet.getClassTypeName().equals(p.getJavePackageType())){
							flag = 1;
						}
					}
					if(flag ==0 ){
						try {
							Class<?> c = ClazzSet.class.getClassLoader().loadClass(p.getJavePackageType());
							clazzs.add(new ClazzSet(c));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				if(p.getJavePackageType().startsWith("java.util.List")){
					
					String str1 = p.getJavePackageType();
					str1 = str1.substring(str1.indexOf('<')+1, str1.indexOf('>'));
					p.setListOfType(str1);
					int flag = 0;
					for(ClazzSet clazzSet :clazzs){
						if(clazzSet.getClassTypeName().equals(str1)){
							flag = 1;
						}
					}
					if(flag == 0){
						try {
							Class<?> c = ClazzSet.class.getClassLoader().loadClass(str1);
							clazzs.add(new ClazzSet(c));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
							
			}			
			if (f.getType().getSimpleName().equals(PropertyType.String)) {
				p.setJavaType(PropertyType.String);
				p.setTypeName(f.getName());
				p.setTable_column(FmUtil.TuoToZiduan(f.getName()));
				p.setJavePackageType(f.getGenericType().getTypeName());
			}
			if (f.getType().getSimpleName().equals(PropertyType.Integer)) {
				p.setJavaType(PropertyType.Integer);
				p.setTypeName(f.getName());
				p.setTable_column(FmUtil.TuoToZiduan(f.getName()));
				p.setJavePackageType(f.getGenericType().getTypeName());
			}
			if (f.getType().getSimpleName().equals(PropertyType.Long)) {
				p.setJavaType(PropertyType.Long);
				p.setTypeName(f.getName());
				p.setTable_column(FmUtil.TuoToZiduan(f.getName()));
				p.setJavePackageType(f.getGenericType().getTypeName());
			}
			if (f.getType().getSimpleName().equals(PropertyType.Float)) {
				p.setJavaType(PropertyType.Float);
				p.setTypeName(f.getName());
				p.setTable_column(FmUtil.TuoToZiduan(f.getName()));
				p.setJavePackageType(f.getGenericType().getTypeName());
			}
			if (f.getType().getSimpleName().equals(PropertyType.Date)) {
				p.setJavaType(PropertyType.Date);
				p.setTypeName(f.getName());
				p.setTable_column(FmUtil.TuoToZiduan(f.getName()));
				p.setJavePackageType(f.getGenericType().getTypeName());
			}
			if(p.getTypeName()!=null){
				this.propertys.add(p);
			}
			
		}
	}

	public void initSupper(Class<?> clazz) {
		Class<?> sClazz = clazz.getSuperclass();
		initSelf(sClazz);
	}

	public String getJavaImport() {
		return javaImport;
	}

	public String getClassName() {
		return className;
	}

	public String getTableName() {
		return tableName;
	}

	public String getCode() {
		return code;
	}

	public List<Property> getPropertys() {
		return propertys;
	}
	public String getClassLowerName() {
		return classLowerName;
	}

}
