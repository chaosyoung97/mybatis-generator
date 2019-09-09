package com.mybatis.generator;

import freemarker.core.ParseException;
import freemarker.template.*;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by JIANGPING on 2019/4/13.
 */
public class ServiceControllerPlugin extends PluginAdapter {
    public boolean validate(List<String> warnings) {
        return true;
    }

    private Properties getConfig() {
        try {
            InputStream in = this.getClass().getResourceAsStream("/init.properties");
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {


        String javaRepositoryPackage = this.getContext().getJavaClientGeneratorConfiguration().getTargetPackage();
        String javaMapperType = introspectedTable.getMyBatis3JavaMapperType();
        String topPackage = javaRepositoryPackage.substring(0, javaRepositoryPackage.lastIndexOf('.'));
        String javaClassName = javaMapperType.substring(javaMapperType.lastIndexOf('.') + 1, javaMapperType.length()).replace("Dao", "");
        String targetProject = this.getContext().getJavaClientGeneratorConfiguration().getTargetProject();
        Properties properties = getConfig();
        String daoPackage = properties.getProperty("dao");
        String servicePackage = properties.getProperty("service");
        String modelPackage = properties.getProperty("model");
        String controllerPackage = properties.getProperty("controller");
        String autho = properties.getProperty("autho");

        Map<String, String> root = new HashMap<String, String>();
        root.put("modelPackage", modelPackage);
        root.put("daoPackage", daoPackage);
        root.put("servicePackage", servicePackage);
        root.put("controllerPackage", controllerPackage);
        root.put("author", autho);
        root.put("date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        root.put("topPackage", topPackage);
        root.put("EntityName", javaClassName);
        root.put("entityName", new StringBuilder().append(Character.toLowerCase(javaClassName.charAt(0)))
                .append(javaClassName.substring(1)).toString());


        servicePackage = servicePackage.replaceAll("\\.", "/");
        controllerPackage = controllerPackage.replaceAll("\\.", "/");
        genService(targetProject, servicePackage, javaClassName, root);
//        genServiceImpl(targetProject, servicePackage, javaClassName, root);
        genController(targetProject, controllerPackage, javaClassName, root);

        return null;
    }


    @SuppressWarnings("deprecation")
    private void genService(String targetProject, String topPackage, String javaClassName, Map<String, String> root) {

        String dirPath = targetProject + "/" + topPackage+ "/";
        String filePath = targetProject + "/" + topPackage + "/" + javaClassName
                + "Service.java";
        File dir = new File(dirPath);
        File file = new File(filePath);
        if (file.exists()) {
            System.err.println(file + " already exists, it was skipped.");
            return;
        } else {
            try {
                dir.mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setObjectWrapper(new DefaultObjectWrapper());


        try {
            Template temp = cfg.getTemplate("Service.ftl");
            Writer out = new OutputStreamWriter(new FileOutputStream(file));
            temp.process(root, out);
            out.flush();
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }


    @SuppressWarnings("deprecation")
    private void genServiceImpl(String targetProject, String topPackage, String javaClassName, Map<String, String> root) {

        String dirPath = targetProject + "/" + topPackage + "/impl";
        String filePath = targetProject + "/" + topPackage + "/impl/" + javaClassName
                + "ServiceImpl.java";
        File dir = new File(dirPath);
        File file = new File(filePath);
        if (file.exists()) {
            System.err.println(file + " already exists, it was skipped.");
            return;
        } else {
            try {
                dir.mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setObjectWrapper(new DefaultObjectWrapper());


        try {
            Template temp = cfg.getTemplate("EntityServiceImpl.ftl");
            Writer out = new OutputStreamWriter(new FileOutputStream(file));
            temp.process(root, out);
            out.flush();
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }


    @SuppressWarnings("deprecation")
    private void genController(String targetProject, String controllerPackage, String javaClassName,
                               Map<String, String> root) {
        String dirPath = targetProject + "/" + controllerPackage + "/";
        String filePath = targetProject + "/" + controllerPackage + "/" + javaClassName
                + "Controller.java";
        File dir = new File(dirPath);
        File file = new File(filePath);
        if (file.exists()) {
            System.err.println(file + " already exists, it was skipped.");
            return;
        } else {
            try {
                dir.mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setObjectWrapper(new DefaultObjectWrapper());


        try {
            Template temp = cfg.getTemplate("EntityController.ftl");
            Writer out = new OutputStreamWriter(new FileOutputStream(file));
            temp.process(root, out);
            out.flush();
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}
