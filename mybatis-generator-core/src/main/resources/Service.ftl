package ${servicePackage};

import ${modelPackage}.${EntityName};
import ${daoPackage}.${EntityName}Dao;
import com.github.pagehelper.PageHelper;
import com.sanyth.common.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.sanyth.smp.web.common.vo.PageInfoVo;

/**
 * Created by ${author} on ${date}.
 */

@Service("${entityName}Service")
public class ${EntityName}Service extends BaseService{

	@Autowired
	private ${EntityName}Dao ${entityName}Dao;

	public int save(${EntityName} ${entityName}) {
		return  ${entityName}Dao.save(${entityName});
	}

	public int delete(String id) {
		return ${entityName}Dao.delete(id);
	}

	public ${EntityName} get(String id) {
		return ${entityName}Dao.get(id);
	}

	public int update(${EntityName} record) {
		return ${entityName}Dao.update(record);
	}

	public PageInfoVo<${EntityName}> queryPageList(Map<String, Object> params) {
    	PageHelper.startPage(getPage(params), getPageSize(params));
    	// return new PageInfoVo(${entityName}Dao.queryPageList(params));
		return null;
    }
}