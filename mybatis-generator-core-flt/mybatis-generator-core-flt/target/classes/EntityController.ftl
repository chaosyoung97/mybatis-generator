package ${controllerPackage};

import ${modelPackage}.${EntityName};
import ${servicePackage}.${EntityName}Service;
import com.inspur.mng.core.action.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${author} on ${date}.
 */

@Controller
@RequestMapping("/${entityName}")
public class ${EntityName}Controller extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(${EntityName}Controller.class);
	@Autowired
	private ${EntityName}Service ${entityName}Service;

	@Override
	public String index(HttpServletResponse httpServletResponse, ModelMap modelMap) {
		return null;
	}

	@Override
	public void save(HttpServletResponse httpServletResponse) {

	}

	@Override
	public void del(HttpServletResponse httpServletResponse) {

	}

	@Override
	public void update(HttpServletResponse httpServletResponse) {

	}

	@Override
	public String add(HttpServletResponse httpServletResponse) {
		return null;
	}

	@Override
	public String show(HttpServletResponse httpServletResponse) {
		return null;
	}

	@Override
	public void query(Integer integer, Integer integer1, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap) {

	}

}