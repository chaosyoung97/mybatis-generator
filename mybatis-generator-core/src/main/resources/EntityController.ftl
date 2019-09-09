package ${controllerPackage};

import com.sanyth.common.Sytlogs;
import com.sanyth.common.Result;
import ${modelPackage}.${EntityName};
import ${servicePackage}.${EntityName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ${author} on ${date}.
 */

@RestController
@RequestMapping("/${entityName}")
public class ${EntityName}Controller {
	private final Logger logger = LoggerFactory.getLogger(${EntityName}Controller.class);
	@Autowired
	private ${EntityName}Service ${entityName}Service;

	@Sytlogs(model = "", remark = "")
	@PostMapping("/create")
	public Result create(@RequestBody ${EntityName} ${entityName}) {
		Result result = new Result();
        try {
			${entityName}Service.save(${entityName});
		} catch (Exception e) {
            logger.error("保存时出现异常", e);
            return result.error();
        }
        return result;
	}

}