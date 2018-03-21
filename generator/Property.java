package com.td.spm.generator;

public class Property {
	private String JavePackageType;
	private String TypeName;
	private String JavaType;
	private boolean Transient;//暂时用不到
	private String table_column;
	private String listOfType;
	
	
   
	public String getListOfType() {
		return listOfType;
	}

	public void setListOfType(String listOfType) {
		this.listOfType = listOfType;
	}

	public String getJavePackageType() {
		return JavePackageType;
	}

	public void setJavePackageType(String javePackageType) {
		JavePackageType = javePackageType;
	}

	public String getTypeName() {
		return TypeName;
	}

	public String getJavaType() {
		return JavaType;
	}



	public String getTable_column() {
		return table_column;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}

	public void setJavaType(String javaType) {
		JavaType = javaType;
	}

	

	public boolean getTransient() {
		return Transient;
	}

	public void setTransient(boolean transient1) {
		Transient = transient1;
	}

	public void setTable_column(String table_column) {
		this.table_column = table_column;
	}

}
