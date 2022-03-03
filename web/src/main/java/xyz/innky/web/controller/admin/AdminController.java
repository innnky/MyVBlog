package xyz.innky.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.innky.web.bean.Article;
import xyz.innky.web.service.ArticleService;
import xyz.innky.web.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/article/all")
    public Map<String, Object> getArticleByStateByAdmin(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "count", defaultValue = "6") Integer count,
                                                        String keywords) {
        int totalCount = articleService.getArticleCountByState(1, Util.getCurrentUser().getId(), keywords);
        List<Article> articles = articleService.getArticleByState(-2, page, count,keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("articles", articles);
        return map;
    }
}
