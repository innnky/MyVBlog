package xyz.innky.web.mapper;


import org.apache.ibatis.annotations.Mapper;
import xyz.innky.web.bean.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> getAllCategories();

    int deleteCategoryByIds(String[] ids);

    int addNewCate(Category category);

    int updateCategory(Category category);
}
