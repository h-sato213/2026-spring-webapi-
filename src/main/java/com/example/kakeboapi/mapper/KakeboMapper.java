package com.example.kakeboapi.mapper;

import com.example.kakeboapi.dto.Kakebo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KakeboMapper {
    @Select("SELECT id, title, value, created_at FROM kakebo ORDER BY created_at DESC")
    List<Kakebo> selectAllKakebos();

    @Insert("INSERT INTO kakebo (title, value) VALUES (#{title}, #{value})")
    @Options(useGeneratedKeys = true, keyProperty = "id,createdAt", keyColumn = "id,created_at")
    int insert(Kakebo kakebo);

    @Select("SELECT id, title, value, created_at FROM kakebo WHERE id = #{id}")
    Kakebo findById(long id);

    @Delete("DELETE FROM kakebo WHERE id = #{id}")
    int delete(long id);

    @Update("UPDATE kakebo SET title = #{title}, value = #{value} WHERE id = #{id}")
    int update(Kakebo kakebo);


}
