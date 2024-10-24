package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.MemberEntity;
import com.example.demo.exception.InvalidBirthdayException;
import com.example.demo.form.MemberForm;
import com.example.demo.service.BloodTypeService;
import com.example.demo.service.GenderService;
import com.example.demo.service.MemberService;

/**
* メンバー情報 Controller
*/
@Controller
public class MemberController {

	/**
	* メンバー情報 Service
	*/
	//使用クラスのインスタンス化
	@Autowired
	MemberService memberService;

	/**
	* 性別情報 Service
	*/
	@Autowired
	GenderService genderService;

	/**
	 * 血液型情報 Service
	 */
	@Autowired
	BloodTypeService bloodTypeService;

	/**
	* メンバー情報一覧画面を表示
	* @param  model Model
	* @return  メンバー情報一覧画面のHTML
	*/
	@GetMapping("/member/list")
	public String memberList(Model model) {
		List<MemberEntity> memberlist = memberService.searchAll();

		Map<Integer, String> genderMap = genderService.getGenders();
		Map<Integer, String> bloodTypeMap = bloodTypeService.getBloodTypes();

		// 現在日時を取得してフォーマット
		Date nowDate = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String formatNowDate = sdf1.format(nowDate);

		model.addAttribute("memberlist", memberlist);
		model.addAttribute("genderMap", genderMap); // 性別Mapをモデルに追加
		model.addAttribute("bloodTypeMap", bloodTypeMap); // 血液型Mapをモデルに追加
		model.addAttribute("currentTime", formatNowDate);//現在時刻をモデルに追加

		return "member/list";
	}

	/**
	 * メンバー新規登録画面を表示
	 * @param  model Model
	 * @return  メンバー情報一覧画面
	 */
	@GetMapping("/member/add")
	public String memberRegister(Model model) {

		String[][] arr = { { "【" },
				{ "新", "規", "登", "録", "入", "力", "フォ", "ー", "ム", "で", "す", "。" },
				{ "※", "は", "必", "須", "項", "目", "で", "す", "。" },
				{ "】" }
		};

		List<String> itemlist = new ArrayList<String>();
		StringBuffer messagae = new StringBuffer();

		for (String[] items : arr) {
			for (String item : items) {
				messagae.append(item);
			}
		}

		model.addAttribute("messagae", messagae);

		model.addAttribute("memberRequest", new MemberForm());
		model.addAttribute("genderMap", genderService.getGenders()); // 性別リストを追加
		model.addAttribute("bloodTypeMap", bloodTypeService.getBloodTypes()); // 血液型のデータを追加
		return "member/add";
	}

	/**
	 * メンバー新規登録
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  メンバー情報一覧画面
	 */
	@PostMapping("/member/create")
	public String memberCreate(@Validated MemberForm memberRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}

			model.addAttribute("memberRequest", new MemberForm());
			model.addAttribute("validationError", errorList);
			model.addAttribute("genderMap", genderService.getGenders()); // 性別リストを再度追加
			model.addAttribute("bloodTypeMap", bloodTypeService.getBloodTypes()); // 血液型リストを再度追加
			return "member/add";
		}

		// 生年月日が不正な場合は例外をスロー
		LocalDate birthday = memberRequest.getBirthday(); // MemberFormからLocalDateを取得
		Integer age = memberRequest.getAge();

		if (!isBirthdayValid(birthday, age)) {
			throw new InvalidBirthdayException("入力された年齢と生年月日が一致しません。");
		}

		// メンバー情報の登録
		memberService.create(memberRequest);
		return "redirect:/member/list";
	}

	/**
	 * メンバー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return メンバー情報詳細画面
	 */
	@GetMapping("/member/{id}")
	public String memberDetail(@PathVariable Integer id, Model model) {
		MemberEntity member = memberService.findById(id);

		Map<Integer, String> genderMap = genderService.getGenders();
		Map<Integer, String> bloodTypeMap = bloodTypeService.getBloodTypes();

		model.addAttribute("memberData", member);
		model.addAttribute("genderMap", genderMap); // 性別Mapをモデルに追加
		model.addAttribute("bloodTypeMap", bloodTypeMap); // 血液型Mapをモデルに追加
		return "member/view";

	}

	/**
	 * メンバー編集画面を表示
	 * @param id 表示するメンバーID
	 * @param model Model
	 * @return メンバー編集画面
	 */
	@GetMapping("/member/{id}/edit")
	public String memberEdit(@PathVariable Integer id, Model model) {
		/**
		* 編集対象のメンバー情報を取得
		*/
		MemberEntity member = memberService.findById(id);
		// 編集画面用のDTOに格納
		MemberForm memberUpdateRequest = new MemberForm();
		memberUpdateRequest.setId(member.getId());
		memberUpdateRequest.setName(member.getName());
		memberUpdateRequest.setAge(member.getAge());
		memberUpdateRequest.setBirthday(member.getBirthday()); // 生年月日を設定
		memberUpdateRequest.setGender_id(member.getGenderId());
		memberUpdateRequest.setBlood_type_id(member.getBlood_type_id());
		model.addAttribute("memberUpdateRequest", memberUpdateRequest);
		model.addAttribute("genderMap", genderService.getGenders()); // 性別リストを追加
		model.addAttribute("bloodTypeMap", bloodTypeService.getBloodTypes()); // 血液型のデータを追加
		return "member/edit";
	}

	/**
	  * メンバー更新
	  * @param  userRequest リクエストデータ
	  * @param  model Model
	  * @return  メンバー情報詳細画面
	  */
	@PostMapping("/member/update")
	public String memberUpdate(@Validated @ModelAttribute MemberForm memberUpdateRequest, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("memberUpdateRequest", new MemberForm());
			model.addAttribute("validationError", errorList);
			model.addAttribute("genderMap", genderService.getGenders()); // 性別リストを再度追加
			model.addAttribute("bloodTypeMap", bloodTypeService.getBloodTypes()); // 血液型リストを再度追加
			return "member/edit";
		}

		// メンバー情報の更新
		memberService.update(memberUpdateRequest);
		return String.format("redirect:/member/%d", memberUpdateRequest.getId());
	}

	/**
	  * メンバー情報削除
	  * @param id 表示するメンバーID
	  * @param model Model
	  * @return メンバー情報詳細画面
	  */
	@GetMapping("/member/{id}/delete")
	public String memberDelete(@PathVariable Integer id, Model model) {
		// ユーザー情報の削除
		memberService.delete(id);
		return "redirect:/member/list";
	}

	/**
	* 生年月日と年齢の整合性をチェック
	* @param birthday 生年月日
	* @param age 年齢
	* @return true: 正常, false: 異常
	*/
	public boolean isBirthdayValid(LocalDate birthday, Integer age) {
		if (birthday == null || age == null) {
			return false; // 引数がnullの場合は不正
		}

		// 現在の日付を取得
		LocalDate today = LocalDate.now();

		// 年齢を計算
		int calculatedAge = Period.between(birthday, today).getYears();

		// 計算した年齢と入力された年齢が一致するかチェック
		return calculatedAge == age;
	}

}