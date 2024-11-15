package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data // Lombokでゲッター・セッターを自動生成
@Entity
@Table(name = "users") // データベースの users テーブルに対応
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ユーザーID（主キー）

    @Column(name = "name", nullable = false)
    private String name; // ユーザーの名前

    @Column(name = "phone", nullable = false)
    private String phone; // ユーザーの電話番号

    @Column(name = "email", nullable = false)
    private String email; // ユーザーのメールアドレス

}
