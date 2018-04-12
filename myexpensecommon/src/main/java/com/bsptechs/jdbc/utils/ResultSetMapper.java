/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.jdbc.utils;

import com.bsptechs.jdbc.annotations.NColumn;
import com.bsptechs.jdbc.annotations.NColumnInstance;
import com.bsptechs.jdbc.annotations.NEntity;
import com.bsptechs.jdbc.annotations.TableMapping;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

public class ResultSetMapper {
 
    public static <T> List<T> mapRersultSetToObject(ResultSet rs, Class<T> outputClass) {
        if (rs == null) {
            return null;
        }
        List<T> outputList = new ArrayList<T>();
        try {
            // make sure resultset is not null
            while (rs.next()) {
                //System.out.println("step 0");
                // check if outputClass has 'Entity' annotation
                if (outputClass.isAnnotationPresent(NEntity.class)) {
                    //System.out.println("step 1");
                    T bean = (T) outputClass.newInstance();
                    // get the resultset metadata
                    Field[] fields = outputClass.getDeclaredFields();
                    //System.out.println("fields size=" + fields.length);
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];

                        NColumn nColumn = getAnnotation(field, NColumn.class);

                        if (nColumn != null) {
                            caseNColumn(nColumn, bean, field, rs);
                        } else {
                            NColumnInstance nColumnInstance = getAnnotation(field, NColumnInstance.class);
                            if (nColumnInstance != null) {
                                caseNColumnInstance(nColumnInstance, bean, field, rs);
                            }
                        }
                    }
                    outputList.add(bean);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return outputList;
    }

    public static <T> T getAnnotation(Field field, Class clazz) {
        Annotation[] anns = field.getAnnotationsByType(clazz);
        if (anns != null && anns.length > 0) {
            return (T) anns[0];
        }

        return null;
    }

    public static <T> void caseNColumn(NColumn nColumn, T bean, Field field, ResultSet rs) throws Exception {
        Object columnValue = rs.getObject(nColumn.name());
        BeanUtils.setProperty(bean, field.getName(), columnValue);
    }

    public static <T> void caseNColumnInstance(NColumnInstance nColumnInstance, T bean, Field currentField, ResultSet rs) throws Exception {
        TableMapping[] tbs = nColumnInstance.table();
        if (tbs == null || tbs.length == 0) {
            return;
        }
        Object currentObject = currentField.getType().newInstance();
        BeanUtils.setProperty(bean, currentField.getName(), currentObject);
        //System.out.println("current class name=" + currentObject.getClass().getName());
        //System.out.println("current field name=" + currentField.getName());
        for (int i = 0; i < tbs.length; i++) {
            //System.out.println("---------------------------");
            //System.out.println("annotation variables processing began");
            //System.out.println("---------------------------");

            TableMapping tb = tbs[i];
            if (StringUtils.isBlank(tb.varName())) {
                continue;
            }
            String[] variableNames = tb.varName().split("\\.");
            if (variableNames == null || variableNames.length == 0) {
                continue;
            }
            Object value = rs.getObject(tb.columnName());
            //System.out.println("db_value=" + value);
            if (variableNames.length == 1) {
                String varName = variableNames[0];
                //System.out.println("1.varname=" + varName);
                BeanUtils.setProperty(currentObject, varName, value);
                continue;
            }

            Object internalObject = null;
            for (int j = 0; j < variableNames.length; j++) {
                String varName = variableNames[j];
                //System.out.println((j + 1) + ".varname=" + varName);
                if (j == variableNames.length - 1) {
                    BeanUtils.setProperty(internalObject, varName, value);
                } else {
                    if (j == 0) {
                        internalObject = currentObject.getClass().getDeclaredField(varName).getType().newInstance();
                    } else {
                        internalObject = internalObject.getClass().getDeclaredField(varName).getType().newInstance();
                    }
                    BeanUtils.setProperty(currentObject, varName, internalObject);
                    currentObject = internalObject;
                    //System.out.println("class name=" + internalObject.getClass().getName());
                }
            }
        }

    }

}
