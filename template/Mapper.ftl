<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${Project.programMapperNamespace}.${ClazzSet.className}Mapper">
	<sql id="baseColums">
		 ${r'${alias}'}.id id
		<#list ClazzSet.propertys as property>
		<#if property.transient=false>
		 ,${r'${alias}'}.${property.table_column} ${property.typeName}
		</#if>
		</#list>
	</sql>
	<sql id="_baseColums">
		 ${r'${alias}'}.id id
		<#list ClazzSet.propertys as property>
		<#if property.transient=false>
		 ,${r'${alias}'}.${property.table_column}
		</#if>
		</#list>
	</sql>
	<resultMap id="baseMap" type="${ClazzSet.classTypeName}">
		<id property="id" column="id"></id>
		<#list ClazzSet.propertys as property>
		<#if property.transient=false>	
		<result property="${property.typeName}" column="${property.table_column}" />
		</#if>
		</#list>
		
		<#list ClazzSet.propertys as property>
		<#if property.transient=true>	
		<#if (property.javePackageType?index_of("com.td")=0)>
		<association property="${property.typeName}" javaType="${property.javePackageType}"> 
		<id property="id" column="${property.typeName}_id"></id> 
 		<#list ClazzSet.clazzs as clazz>
		<#if (clazz.classTypeName=property.javePackageType)>	
		<#list clazz.propertys as property>
		<#if property.transient=false>	
		<result property="${property.typeName}" column="${clazz.classLowerName}_${property.typeName}" />
		</#if>
		</#list>	
		</#if>
		</#list>
		</association>
		</#if>
		</#if>
		</#list>
            
        <#list ClazzSet.propertys as property>
		<#if property.transient=true>	
		<#if (property.javePackageType?index_of("com.td")>2)>
		<collection property="${property.typeName}" ofType="${property.listOfType}"> 
		<id property="id" column="${property.typeName}_id"></id> 
 		<#list ClazzSet.clazzs as clazz>
		<#if (clazz.classTypeName=property.listOfType)>	
		<#list clazz.propertys as property>
		<#if property.transient=false>	
		<result property="${property.typeName}" column="${clazz.classLowerName}_${property.typeName}" />
		</#if>
		</#list>	
		</#if>
		</#list>
		</collection>
		</#if>
		</#if>
		</#list>
	</resultMap>
	
	<select id="list" resultType="map" parameterType="map">
		select
		<include refid="baseColums">
			<property name="alias" value="t1" />
		</include>
		from ${ClazzSet.tableName} t1
		<where>
		<#list ClazzSet.propertys as property>
		<#if property.transient=false>	
		    <#if property.javaType="Long">
		    <if test="${property.typeName} != null"> 	       
		    and t1.${property.table_column} = ${r'#{'}${property.typeName}${r'}'}
		    </if>
		    </#if>	    
		    <#if property.javaType="Integer">
		    <if test="${property.typeName} != null"> 	       
		    and t1.${property.table_column} = ${r'#{'}${property.typeName}${r'}'}
		    </if>
		    </#if>	    
		    <#if property.javaType="String">
		    <if test="${property.typeName} != null"> 	       
		    and t1.${property.table_column} like CONCAT${r"('%',#{"}${property.typeName}${r"},'%')"}
		    </if>
		    </#if>
		    <#if property.javaType="Date">
		    <if test="beginDate != null">
			and t1.${property.table_column} ${r'&gt; #{beginDate}'}
			</if>
			<if test="endDate != null">
			and t1.${property.table_column} ${r'&lt; #{endDate}'}
			</if>
		    </#if>		
		</#if>
		</#list>		
		</where>
		order by t1.id desc
		<if test="start != null">
			${r'limit #{start}, #{limit}'}
		</if>
	</select>
	<select id="countlist" resultType="java.lang.Long" parameterType="map">
		select count(t1.id)
		from ${ClazzSet.tableName} t1
		<where>
		<#list ClazzSet.propertys as property>
		<#if property.transient=false>	
		    <#if property.javaType="Long">
		    <if test="${property.typeName} != null"> 	       
		    and t1.${property.table_column} = ${r'#{'}${property.typeName}${r'}'}
		    </if>
		    </#if>	    
		    <#if property.javaType="Integer">
		    <if test="${property.typeName} != null"> 	       
		    and t1.${property.table_column} = ${r'#{'}${property.typeName}${r'}'}
		    </if>
		    </#if>	    
		    <#if property.javaType="String">
		    <if test="${property.typeName} != null"> 	       
		    and t1.${property.table_column} like CONCAT${r"('%',#{"}${property.typeName}${r"},'%')"}
		    </if>
		    </#if>
		    <#if property.javaType="Date">
		    <if test="beginDate != null">
			and t1.${property.table_column} ${r'&gt; #{beginDate}'}
			</if>
			<if test="endDate != null">
			and t1.${property.table_column} ${r'&lt; #{endDate}'}
			</if>
		    </#if>		
		</#if>
		</#list>		
		</where>
	</select>

</mapper>