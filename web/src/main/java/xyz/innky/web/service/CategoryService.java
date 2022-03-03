package xyz.innky.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.web.bean.Category;
import xyz.innky.web.mapper.CategoryMapper;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }
}
