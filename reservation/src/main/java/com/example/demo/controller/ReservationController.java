package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ReservationDetailsDTO;
import com.example.demo.entity.PlanEntity;
import com.example.demo.entity.ReservationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.PlanService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;

@Controller
public class ReservationController {

	@Autowired
	private PlanService planService;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

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

	/**
	 * ユーザー情報を入力後、予約確認画面へ遷移
	 * 
	 * @param planId 選択されたプランのID
	 * @param selectedDate 選択された日時
	 * @param 
	 * @param model モデル
	 * @return 予約確認画面のHTMLテンプレート名
	 */
	@PostMapping("/confirm")
	public String confirmReservation(
			@RequestParam("userName") String userName,
			@RequestParam("userPhone") String userPhone,
			@RequestParam("userEmail") String userEmail,
			@RequestParam("selectedPlanId") Long selectedPlanId,
			@RequestParam("selectedPlanName") String selectedPlanName,
			@RequestParam("selectedPlanPrice") String selectedPlanPrice,
			@RequestParam("selectedDate") String selectedDate,
			Model model) {

		// 予約情報をモデルに追加
		model.addAttribute("userName", userName);
		model.addAttribute("userPhone", userPhone);
		model.addAttribute("userEmail", userEmail);
		model.addAttribute("selectedPlanId", selectedPlanId);
		model.addAttribute("selectedPlanName", selectedPlanName);
		model.addAttribute("selectedPlanPrice", selectedPlanPrice);
		model.addAttribute("selectedDate", selectedDate);

		// 確認画面へ遷移
		return "confirm";
	}

	/**
	 * 予約を確定し、DBに保存するメソッド
	 * 
	 * @param userName ユーザー名
	 * @param userPhone ユーザーの電話番号
	 * @param userEmail ユーザーのメールアドレス
	 * @param selectedPlanId 選択されたプランID
	 * @param selectedDate 選択された日時
	 * @return 完了画面へのリダイレクト
	 */
	@PostMapping("/finalize")
	public String finalizeReservation(
			@RequestParam("userName") String userName,
			@RequestParam("userPhone") String userPhone,
			@RequestParam("userEmail") String userEmail,
			@RequestParam("selectedPlanId") Long selectedPlanId,
			@RequestParam("selectedDate") String selectedDate) {

		// ユーザー情報を保存
		UserEntity user = new UserEntity();
		user.setName(userName);
		user.setPhone(userPhone);
		user.setEmail(userEmail);
		UserEntity savedUser = userService.saveUser(user);

		// プラン情報を取得
		PlanEntity plan = planService.getPlanById(selectedPlanId); // PlanServiceでプランを取得

		//	    // 予約日時を変換
		//	    ZonedDateTime reservationDate = ZonedDateTime.parse(selectedDate, DateTimeFormatter.ISO_ZONED_DATE_TIME);
		//	    LocalDateTime localDateTime = reservationDate.toLocalDateTime();
		
		// 予約日時を変換
		LocalDateTime localDateTime = LocalDateTime.parse(selectedDate + "T00:00:00"); // 時刻を指定

		// 予約情報を保存
		ReservationEntity reservation = new ReservationEntity();
		reservation.setUser(savedUser);
		reservation.setPlan(plan); // ここでプランを関連付け
		reservation.setReservationDate(localDateTime);
		reservationService.saveReservation(reservation);

		// 予約完了後にcomplete.htmlに遷移
		return "redirect:/complete"; // 完了ページへリダイレクト
	}

	@GetMapping("/complete")
	public String showCompletePage() {
		// 完了ページに遷移
		return "complete"; // complete.html を表示
	}

	@GetMapping("/reservation-list")
	public String getReservationList(Model model) {
		List<ReservationDetailsDTO> reservations = reservationService.getAllReservations();
		model.addAttribute("reservations", reservations);
		return "list"; // "list" は list.html を指している
	}

}
