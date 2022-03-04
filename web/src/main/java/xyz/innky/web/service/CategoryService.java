package xyz.innky.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.web.bean.Category;
import xyz.innky.web.mapper.ArticleMapper;
import xyz.innky.web.mapper.CategoryMapper;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ArticleMapper articleMapper;

    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    public boolean deleteById(String ids) {
        String[] split = ids.split(",");
        int count = articleMapper.getArticleCountByCid(split);
        if(count != 0)
            return false;
        int result = categoryMapper.deleteCategoryByIds(split);
        return result == split.length;
    }

    public boolean addNewCate(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        int count = categoryMapper.addNewCate(category);
        return count == 1;
    }

    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }
}
