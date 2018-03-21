package ${Project.apiHandlerClassPath};
import java.util.List;
import com.td.framework.metadata.exceptions.ServiceException;
import com.td.framework.metadata.usage.page.DataPaging;
import com.td.framework.metadata.usage.page.PageForm;
${ClazzSet.javaImport}

public interface ${ClazzSet.className}Handler {
    void saveOne(${ClazzSet.className} ${ClazzSet.classLowerName}) throws ServiceException;
	
	void deleteOne(Long id) throws ServiceException;
	
	void updateOne(${ClazzSet.className} ${ClazzSet.classLowerName}) throws ServiceException;
	
	void deleteList(List<Long> list) throws ServiceException;
	
	${ClazzSet.className} getOne(Long id) throws ServiceException;
	
	List<${ClazzSet.className}> getList() throws ServiceException;
	
    DataPaging<${ClazzSet.className}> getListWithPage(${ClazzSet.className} ${ClazzSet.classLowerName}, PageForm pageForm) throws ServiceException;
	
}

