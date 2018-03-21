package ${Project.restController};

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.td.framework.form.JsonRequestBody;
import com.td.framework.metadata.bean.ResultForm;
import com.td.framework.metadata.usage.page.PageForm;
import ${Project.apiHandlerClassPath}.${ClazzSet.className}Handler;
${ClazzSet.javaImport}

@RestController
@RequestMapping("/rest/${ClazzSet.classLowerName}")
public class ${ClazzSet.className}Controller {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Reference
	private ${ClazzSet.className}Handler ${ClazzSet.classLowerName}Handler;
	
	@RequestMapping("/getList")
	public Object getList(@RequestBody(required=false) JsonRequestBody body) {
		ResultForm<?> result = null;
		String errorMsg = "查询失败";
		try {
			result = ResultForm.createSuccessResultForm(${ClazzSet.classLowerName}Handler.getList(), "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultForm.createErrorResultForm(null, errorMsg);
			logger.error(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/getOne")
	public Object getOne(@RequestBody(required=false) JsonRequestBody body) {
		ResultForm<?> result = null;
		String errorMsg = "查询失败";
		try {
			Long id = body.getLong("id");
			result = ResultForm.createSuccessResultForm(${ClazzSet.classLowerName}Handler.getOne(id), "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultForm.createErrorResultForm(null, errorMsg);
			logger.error(e.getMessage());
		}
		return result;
	}
	@RequestMapping("/saveOne")
	public Object saveOne(@RequestBody(required=false) JsonRequestBody body) {
		ResultForm<?> result = null;
		String errorMsg = "保存失败";
		try {
			${ClazzSet.className} ${ClazzSet.classLowerName} = body.tryGet("${ClazzSet.classLowerName}", ${ClazzSet.className}.class);
			${ClazzSet.classLowerName}Handler.saveOne(${ClazzSet.classLowerName});
			result = ResultForm.createSuccessResultForm(null, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultForm.createErrorResultForm(null, errorMsg);
			logger.error(e.getMessage());
		}
		return result;
	}
	@RequestMapping("/deleteOne")
	public Object deleteOne(@RequestBody(required=false) JsonRequestBody body) {
		ResultForm<?> result = null;
		String errorMsg = "删除失败";
		try {
			Long id = body.getLong("id");
			${ClazzSet.classLowerName}Handler.deleteOne(id);
			result = ResultForm.createSuccessResultForm(null, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultForm.createErrorResultForm(null, errorMsg);
			logger.error(e.getMessage());
		}
		return result;
	}
	@RequestMapping("/updateOne")
	public Object updateOne(@RequestBody(required=false) JsonRequestBody body) {
		ResultForm<?> result = null;
		String errorMsg = "更新失败";
		try {
			${ClazzSet.className} ${ClazzSet.classLowerName} = body.tryGet("${ClazzSet.classLowerName}", ${ClazzSet.className}.class);
			${ClazzSet.classLowerName}Handler.updateOne(${ClazzSet.classLowerName});
			result = ResultForm.createSuccessResultForm(null, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultForm.createErrorResultForm(null, errorMsg);
			logger.error(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/getListWithPage")
	public Object getListWithPage(@RequestBody(required=false) JsonRequestBody body) {
		ResultForm<?> result = null;
		String errorMsg = "查询失败";
		try {
			${ClazzSet.className} ${ClazzSet.classLowerName} = body.tryGet("${ClazzSet.classLowerName}", ${ClazzSet.className}.class);
			PageForm pageForm = body.getPageForm();
			result = ResultForm.createSuccessResultForm(${ClazzSet.classLowerName}Handler.getListWithPage(${ClazzSet.classLowerName},pageForm), "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultForm.createErrorResultForm(null, errorMsg);
			logger.error(e.getMessage());
		}
		return result;
	}
	@RequestMapping("/deleteList")
	public Object deleteList(@RequestBody(required=false) JsonRequestBody body) {
		ResultForm<?> result = null;
		String errorMsg = "删除失败";
		try {
			List<Long> list= body.getList("list", Long.class);	
			${ClazzSet.classLowerName}Handler.deleteList(list);
			result = ResultForm.createSuccessResultForm(null, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultForm.createErrorResultForm(null, errorMsg);
			logger.error(e.getMessage());
		}
		return result;
	}

}
