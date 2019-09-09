package ${servicePackage};

import ${modelPackage}.${EntityName};
/**
 * Created by ${author} on ${date}.
 */
public interface ${EntityName}Service {

	int delete(String id);

    int save(${EntityName} record);

	${EntityName} get(String id);

    int update(${EntityName} record);
}