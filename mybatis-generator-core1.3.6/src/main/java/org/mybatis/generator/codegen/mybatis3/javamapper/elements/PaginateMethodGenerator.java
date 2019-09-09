/**
 *    Copyright 2006-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class PaginateMethodGenerator extends AbstractJavaMapperMethodGenerator {

    private boolean isSimple;

    public PaginateMethodGenerator() {
        super();
    }

//    @Override
//    public void addInterfaceElements(Interface interfaze) {
//        Method method = new Method();
//
//        method.setReturnType(FullyQualifiedJavaType.getPaginate());
//        method.setVisibility(JavaVisibility.PUBLIC);
//        method.setName("paginate");
//
//        FullyQualifiedJavaType parameterType;
//        if (isSimple) {
//            parameterType = new FullyQualifiedJavaType(
//                    introspectedTable.getBaseRecordType());
//        } else {
//            parameterType = introspectedTable.getRules()
//                    .calculateAllFieldsClass();
//        }
//
//        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
//        importedTypes.add(parameterType);
//        method.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$
//
//        context.getCommentGenerator().addGeneralMethodComment(method,
//                introspectedTable);
//
//        addMapperAnnotations(method);
//
//        if (context.getPlugins().clientInsertMethodGenerated(method, interfaze,
//                introspectedTable)) {
//            addExtraImports(interfaze);
//            interfaze.addImportedTypes(importedTypes);
//            interfaze.addMethod(method);
//        }
//    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        importedTypes.add(FullyQualifiedJavaType.getNewPageInstance());

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType
                .getNewPageInstance();
        FullyQualifiedJavaType listType;
        listType = FullyQualifiedJavaType.getNewRecordInstance();
//        introspectedTable.getBaseRecordType(); 获取entity对象类型

        importedTypes.add(listType);
        returnType.addTypeArgument(listType);
        method.setReturnType(returnType);
        method.setName("paginate");
        FullyQualifiedJavaType intInstance = FullyQualifiedJavaType.getIntInstance();
        FullyQualifiedJavaType stringInstance = FullyQualifiedJavaType.getStringInstance();
        FullyQualifiedJavaType objectInstance = FullyQualifiedJavaType.getObjectInstance();

        method.addParameter(new Parameter(intInstance, "pageNumber")); //$NON-NLS-1$
        method.addParameter(new Parameter(intInstance, "pageSize")); //$NON-NLS-1$
        method.addParameter(new Parameter(stringInstance, "select")); //$NON-NLS-1$
        method.addParameter(new Parameter(stringInstance, "sqlExceptSelect")); //$NON-NLS-1$
        method.addParameter(new Parameter(objectInstance, "paras")); //$NON-NLS-1$
        method.addException(new FullyQualifiedJavaType("java.lang.Exception"));
        method.addBodyLine(" return super.paginate(pageNumber, pageSize, select, sqlExceptSelect, paras); ");
        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

        addMapperAnnotations(interfaze, method);

        if (context.getPlugins().clientSelectAllMethodGenerated(method,
                interfaze, introspectedTable)) {
            addExtraImports(interfaze);
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }
    public void addMapperAnnotations(Interface interfaze, Method method) {
    }

    public void addExtraImports(Interface interfaze) {
    }
}
