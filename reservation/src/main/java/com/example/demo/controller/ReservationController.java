package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.PlanEntity;
import com.example.demo.service.PlanService;

@Controller
public class ReservationController {
	
	
	 @Autowired
	    private PlanService planService;
	
	 /**
     * トップ画面を表示するメソッド
     *
     * @param model モデル
     * @return トップ画面のHTMLテンプレート名
     */
    @GetMapping("/reservation/top")
    public String showTopPage(Model model) {
        // 必要なデータをmodelに追加する場合はここで追加
        return "top"; // top.html を表示
    }
    
    /**
     * プラン選択画面を表示するメソッド
     *
     * @param model モデル
     * @return プラン選択画面のHTMLテンプレート名
     */
    @GetMapping("/reservation/plans")
    public String showPlans(Model model) {
        // PlanEntityのMapを取得
        Map<Integer, PlanEntity> plans = planService.getAllPlans();
        // Modelに渡す
        model.addAttribute("plans", plans);
        return "plans"; // plans.htmlを返す
    }
    
    /**
     * 日時選択画面を表示するメソッド
     *
     * @param model モデル
     * @return 日時選択画面のHTMLテンプレート名
     */
    @GetMapping("/reservation/datetime")
    public String showDateTimePage(Model model) {
        return "datetime"; // datetime.htmlを返す
    }
    

}
