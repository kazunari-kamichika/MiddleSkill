package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Loggerのインスタンスを作成
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    // InvalidBirthdayException に対するリダイレクト処理
    @ExceptionHandler(InvalidBirthdayException.class)
    public String handleInvalidBirthdayException(InvalidBirthdayException ex, RedirectAttributes redirectAttributes) {
        // ログをエラーレベルで出力
        logger.error("生年月日不一致エラー: {}", ex.getMessage());

        // エラーメッセージをリダイレクト時に渡す
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/member/add";  // リダイレクト先を適切に設定
    }

//    // 他の例外処理
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleGenericException(Exception ex, Model model) {
//        // 予期しないエラーのログを出力
//        logger.error("予期しないエラーが発生しました: {}", ex.getMessage(), ex);
//
//        // エラーメッセージをModelに追加して、ビューに渡す
//        model.addAttribute("errorMessage", "予期しないエラーが発生しました。");
//        return "error"; // error.htmlを返す
//    }

//    // InvalidBirthdayException に対するリダイレクト処理
//    @ExceptionHandler(InvalidBirthdayException.class)
//    public String handleInvalidBirthdayException(InvalidBirthdayException ex, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
//        return "redirect:/member/add";  // リダイレクト先を適切に設定
//    }
//
//    // 他の例外処理
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleGenericException(Exception ex, Model model) {
//        model.addAttribute("errorMessage", "予期しないエラーが発生しました。");
//        return "error"; // error.htmlを返す
//    }
}

