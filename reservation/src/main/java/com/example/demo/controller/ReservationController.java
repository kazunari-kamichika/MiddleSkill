package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showPlanSelection(Model model) {
		List<PlanEntity> plans = planService.getAllPlans(); // プランを取得
		model.addAttribute("plans", plans);
		return "plans"; // プラン選択画面に遷移
	}

	/**
	 * プラン選択後、日時選択画面へ遷移
	 * 
	 * @param planId 選択されたプランのID
	 * @param model モデル
	 * @return 日時選択画面のHTMLテンプレート名
	 */
	@PostMapping("/select-date")
	public String selectPlan(@RequestParam("planId") Long planId, Model model) {
		PlanEntity selectedPlan = planService.getPlanById(planId); // 選択されたプランを取得
		model.addAttribute("selectedPlan", selectedPlan); // プラン情報をmodelに追加
		return "datetime"; // 日時選択画面に遷移
	}

	/**
	 * 日時選択後、ユーザー情報選択画面へ遷移
	 * 
	 * @param planId 選択されたプランのID
	 * @param selectedDate 選択された日時
	 * @param model モデル
	 * @return ユーザー情報選択画面のHTMLテンプレート名
	 */
	@PostMapping("/select-user")
	public String selectUser(@RequestParam("selectedDate") String selectedDate,
			@RequestParam("planId") Long planId,
			Model model) {
		// 選択されたプランを取得
		PlanEntity selectedPlan = planService.getPlanById(planId);

		// モデルに選択されたプランと日時を追加
		model.addAttribute("selectedPlan", selectedPlan);
		model.addAttribute("selectedDate", selectedDate);

		return "userinfo"; // ユーザー情報選択画面に遷移
	}

}
