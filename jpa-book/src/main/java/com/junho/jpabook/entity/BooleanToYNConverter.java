package com.junho.jpabook.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> { // Boolean -> String 타입으로 변환

    @Override
    public String convertToDatabaseColumn(final Boolean attribute) { // 엔티티의 Data를 DB 컬럼에 데이터로 변환
        if (attribute != null && attribute) {
            return "Y";
        }
        return "N";
    }

    @Override
    public Boolean convertToEntityAttribute(final String dbData) { // DB 조회 컬럼을 엔티티 데이터로 변환
        return dbData.equals("Y");
    }
}
