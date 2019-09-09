package ${servicePackage};

import ${modelPackage}.${EntityName};
import org.springframework.stereotype.Repository;
import com.inspur.mng.core.db.Record;
import com.inspur.mng.core.ibatis.MapperBaseDao;
import com.inspur.mng.core.page.Page;

/**
 * Created by ${author} on ${date}.
 */
@Repository("${EntityName}Dao")
public class ${EntityName}Dao extends MapperBaseDao<${EntityName}> {

    /**
    * 数据分页查询
    */
    public Page<Record> paginate(int pageNumber, int pageSize, String select, String sqlExceptSelect, Object... paras)  throws Exception{
        return super.paginate(pageNumber, pageSize, select, sqlExceptSelect, paras);
    }
}