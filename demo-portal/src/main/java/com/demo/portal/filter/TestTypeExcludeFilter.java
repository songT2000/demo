package com.demo.portal.filter;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

public class TestTypeExcludeFilter extends TypeExcludeFilter {


    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        String name = metadataReader.getClass().getName();
        String className = metadataReader.getClassMetadata().getClassName();
        System.out.println(name);
        System.out.println(className);
//        if ("com.demo.web.domain.vo.UserVo".equals(metadataReader.getClassMetadata().getClassName())) {
//            return true;
//        }
        return false;
    }
}



