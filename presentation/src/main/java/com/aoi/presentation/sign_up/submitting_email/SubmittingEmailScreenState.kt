package com.aoi.presentation.sign_up.submitting_email

/**
 * SubmittingEmailScreenState
 *
 * @property email 入力されたメールアドレス
 * @property emailErrorMessage メールアドレス入力フォームに表示するエラーメッセージ
 * @property isEmailValid メールアドレスが有効かどうか
 * @property onEmailChange メールアドレス入力フォームの値が変更されたときの処理
 * @property onNavigateVerifyingEmailScreen メールアドレスが有効であるときの処理
 * @property onNavigateToSignInScreen サインイン画面に遷移するときの処理
 */
data class SubmittingEmailScreenState(
    val email: String,
    val emailErrorMessage: Int? = null,
    val isEmailValid: Boolean = false,
    val onEmailChange: (String) -> Unit,
    val onNavigateVerifyingEmailScreen: () -> Unit = {},
    val onNavigateToSignInScreen: () -> Unit = {}
)