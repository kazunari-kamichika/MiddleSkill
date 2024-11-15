package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * カスタムアノテーション @DATE
 * 日時フィールドに適用するための目印。
 */
@Target(ElementType.FIELD) // フィールドに付与可能
@Retention(RetentionPolicy.RUNTIME) // 実行時まで保持
public @interface DATE {
    // フォーマットの属性（必要に応じてカスタマイズ）
    String format() default "yyyy-MM-dd";
}
