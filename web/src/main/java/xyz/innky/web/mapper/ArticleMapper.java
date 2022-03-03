package xyz.innky.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.innky.web.bean.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid,@Param("keywords") String keywords);

    Article getArticleById(Long aid);

    void pvIncrement(Long aid);

    int updateArticle(Article article);

    int addNewArticle(Article article);

    int updateArticleState(@Param("aids") Long[] aids, @Param("state") int i);

    int deleteArticleById(@Param("aids") Long[] aids);
}
