package ${Project.programApiImpl};

import java.util.List;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.td.framework.metadata.exceptions.ServiceException;
import com.td.framework.metadata.usage.page.DataPaging;
import com.td.framework.metadata.usage.page.PageForm;
import ${Project.apiHandlerClassPath}.${ClazzSet.className}Handler;
import ${Project.programService}.${ClazzSet.className}Service;
import com.td.util.Assert;
${ClazzSet.javaImport}

@Component
@Service
public class ${ClazzSet.className}HandlerImpl implements ${ClazzSet.className}Handler {

	@Autowired
	private ${ClazzSet.className}Service ${ClazzSet.classLowerName}Service;
	
	@Override
	public List<${ClazzSet.className}> getList() throws ServiceException {
		// TODO Auto-generated method stub
		${ClazzSet.className} ${ClazzSet.classLowerName} = new ${ClazzSet.className}();
		return ${ClazzSet.classLowerName}Service.selectEntitys(${ClazzSet.classLowerName});
	}

	@Override
	public ${ClazzSet.className} getOne(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		Assert.notNull(id);
		return ${ClazzSet.classLowerName}Service.selectByPrimaryKey(id);
	}

	@Override
	public void saveOne(${ClazzSet.className} ${ClazzSet.classLowerName}) throws ServiceException {
		// TODO Auto-generated method stub
		Assert.notNull(${ClazzSet.classLowerName});
		${ClazzSet.classLowerName}Service.save(${ClazzSet.classLowerName});
	}

	@Override
	public void deleteOne(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		Assert.notNull(id);
		${ClazzSet.classLowerName}Service.deleteByPrimaryKey(id);
	}

	@Override
	public void updateOne(${ClazzSet.className} ${ClazzSet.classLowerName}) throws ServiceException {
		// TODO Auto-generated method stub
		Assert.notNull(${ClazzSet.classLowerName});
		Assert.notNull(${ClazzSet.classLowerName}.getId());
		${ClazzSet.classLowerName}Service.update(${ClazzSet.classLowerName});
			
		

	}

	@Override
	public DataPaging<${ClazzSet.className}> getListWithPage(${ClazzSet.className} ${ClazzSet.classLowerName}, PageForm pageForm) throws ServiceException {
		// TODO Auto-generated method stub
		Assert.notNull(pageForm);
		pageForm.setSortRule("id:desc");
		return ${ClazzSet.classLowerName}Service.selectEntitys(${ClazzSet.classLowerName}, pageForm);	
	}

	@Override
	public void deleteList(List<Long> list) throws ServiceException{
		// TODO Auto-generated method stub
		Assert.notNull(list);
		${ClazzSet.classLowerName}Service.deleteByPrimaryKeys(list);
		
	}
	
}