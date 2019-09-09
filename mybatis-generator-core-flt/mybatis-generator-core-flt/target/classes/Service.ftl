package ${servicePackage};

import ${modelPackage}.${EntityName};
import ${daoPackage}.${EntityName}Dao;
import com.inspur.mng.core.db.Record;
import com.inspur.mng.core.page.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by ${author} on ${date}.
 */

@Service("${EntityName}Service")
@Transactional
public class ${EntityName}Service {

	@Autowired
	private ${EntityName}Dao ${entityName}Dao;

	/**
	* 分页数据
	* @param pageNumber
	* @param pageSize
	* @param select
	* @param sqlExceptSelect
	* @param paras
	* @return
	*/
	@Transactional(readOnly=true)
	public Page<Record> paginate(int pageNumber, int pageSize, String select, String sqlExceptSelect, Object... paras) throws Exception {
		return ${entityName}Dao.paginate(pageNumber, pageSize, select, sqlExceptSelect, paras);
	}

	/**
	* 根据主键删除
	*/
	public void delete${EntityName}ByPrimaryKey(String employeeid){
		this.${entityName}Dao.save("${daoPackage}.${EntityName}Dao.delete${EntityName}ByPrimaryKey",employeeid);
	}

	/**
	* 创建对象
	*/
	public void insert${EntityName}(${EntityName} bean){
		this.${entityName}Dao.save("${daoPackage}.${EntityName}Dao.insert${EntityName}",bean);
	}

	/**
	* 根据可选属性创建
	*/
	public void insert${EntityName}BySelective(${EntityName} bean){
		this.${entityName}Dao.save("${daoPackage}.${EntityName}Dao.insert${EntityName}BySelective",bean);
	}
	/**
	* 更新
	*/
	public void update${EntityName}ByPrimaryKeySelective(${EntityName} bean){
		this.${entityName}Dao.save("${daoPackage}.${EntityName}Dao.update${EntityName}ByPrimaryKeySelective",bean);
	}

	/**
	* 更新
	*/
	public void update${EntityName}ByPrimaryKey(${EntityName} bean){
		this.${entityName}Dao.save("${daoPackage}.${EntityName}Dao.update${EntityName}ByPrimaryKey",bean);
	}
}