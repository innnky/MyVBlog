package xyz.innky.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import xyz.innky.web.bean.Category;
import xyz.innky.web.bean.RespBean;
import xyz.innky.web.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{ids}")
    public RespBean deleteByID(@PathVariable("ids") String ids){
        if(categoryService.deleteById(ids)){
            return new RespBean("success", "删除成功！");
        }else {
            return new RespBean("error", "删除失败!");
        }
    }

    @PostMapping("/")
    public RespBean addNewCate(Category category){
        if (ObjectUtils.isEmpty(category.getCateName())){
            return new RespBean("error", "请输入名称！");
        }
        if(categoryService.addNewCate(category)){
            return new RespBean("success", "删除成功！");
        }else {
            return new RespBean("error", "删除失败!");
        }
    }

    @PutMapping("/")
    public RespBean updateCategory(Category category){
        if (categoryService.updateCategory(category) == 1){
            return new RespBean("success", "修改成功！");
        }else {
            return new RespBean("error", "修改失败！");
        }
    }


}
