package ${servicePackage}.impl;

import ${modelPackage}.${EntityName};
import ${daoPackage}.${EntityName}Dao;
import ${servicePackage}.${EntityName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ${author} on ${date}.
 */

@Service("${entityName}Service")
public class ${EntityName}ServiceImpl implements ${EntityName}Service{

	@Autowired
	private ${EntityName}Dao ${entityName}Dao;

	@Override
	public int save(${EntityName} ${entityName}) {
		return  ${entityName}Dao.save(${entityName});
	}

	@Override
	public int delete(String id) {
		return ${entityName}Dao.delete(${entityName});
	}

	@Override
	public ResourcesSchool get(String id) {
		return ${entityName}Dao.get(id);
	}

	@Override
	public int update(ResourcesSchool record) {
		return ${entityName}Dao.update(record);
	}
}