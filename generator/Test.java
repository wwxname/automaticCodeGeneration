package com.td.spm.generator;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.err.println(new Project().getProgramRepositoryBasePath());
		String className = "java.util.List<com.td.spm.entity.Student>";
		className.indexOf('<');
		
		System.err.println(className.substring(className.indexOf('<')+1, className.indexOf('>')));


	}

}
