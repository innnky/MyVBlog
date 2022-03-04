package xyz.innky.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataStatisticService {

    @Autowired
    ArticleService articleService;

    @Scheduled(cron = "1 0 0 * * ?")
    public void DataStatistic (){
//        System.out.println(1);
        articleService.doDataStatistic();
    }
}
