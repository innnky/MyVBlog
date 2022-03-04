package xyz.innky.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagsMapper {
    void deleteTagsByAid(Long aid);

    void saveTags(String[] dynamicTags);

    List<Long> getTagsIdByTagName(String[] dynamicTags);

    int saveTags2ArticleTags(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);
}
