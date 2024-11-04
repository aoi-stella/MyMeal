package com.aoi.presentation.sign_up.submitting_email

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aoi.core.R
import com.aoi.core.ui.components.button.outline_button.OutlineButton
import com.aoi.core.ui.components.button.outline_button.OutlineButtonState
import com.aoi.core.ui.components.button.primary_button.PrimaryButton
import com.aoi.core.ui.components.button.primary_button.PrimaryButtonState
import com.aoi.core.ui.components.divider.divider_with_text.DividerWithText
import com.aoi.core.ui.components.divider.divider_with_text.DividerWithTextState
import com.aoi.core.ui.components.input_form.MyMealUserInputForm
import com.aoi.core.ui.components.input_form.MyMealUserInputFormState
import com.aoi.core.ui.modifier.MyMealModifier
import com.aoi.core.ui.spacing.MyMealSpacing

@Composable
fun SubmittingEmailScreen(
    vm: SubmittingEmailScreenViewModel = viewModel(),
    onNavigateToSignInScreen: () -> Unit,
    onNavigateToVerifyingTokenScreen: () -> Unit){
    LaunchedEffect(Unit) {
        vm.setClickEventOnNavigateToVerifyEmailButton(onNavigateToVerifyingTokenScreen)
        vm.setClickEventOnNavigateToSignInButton(onNavigateToSignInScreen)
    }
    val state by vm.state.collectAsState()
    SubmittingEmailScreen(state = state)
}

@Composable
fun SubmittingEmailScreen(state: SubmittingEmailScreenState) {
    Surface(modifier = MyMealModifier.screenParentModifier.background(MaterialTheme.colorScheme.surface)) {
        Column(
            modifier = MyMealModifier.screenTopChildColumnModifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val emailErrorMessage = state.emailErrorMessage?.let { stringResource(it) }
            val isEmailError = emailErrorMessage != null

            Text(
                text = stringResource(R.string.sign_up_welcome_message),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
            Text(
                text = stringResource(R.string.sign_up_encourage_registering_email_address),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = MyMealSpacing.sectionLarge))
            MyMealUserInputForm(
                state = MyMealUserInputFormState(
                    value = state.email,
                    onValueChange = state.onEmailChange,
                    placeholder = stringResource(R.string.sign_up_placeholder_email),
                    errorMessage = emailErrorMessage,
                    isError = isEmailError,
                    modifier = Modifier.padding(top = MyMealSpacing.sectionMedium, bottom = MyMealSpacing.componentLarge),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            )
            PrimaryButton(
                state = PrimaryButtonState(
                    text = stringResource(R.string.sign_up_submit_email),
                    onClick = state.onNavigateVerifyingEmailScreen,
                    enabled = state.isEmailValid,
                    modifier = Modifier.fillMaxWidth()
                )
            )
            DividerWithText(
                state = DividerWithTextState(
                    text = stringResource(R.string.sign_up_divide_or),
                    modifier = Modifier.padding(top = MyMealSpacing.sectionLarge)
                )
            )
            Text(
                text = stringResource(R.string.sign_up_inquire_already_has_account),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = MyMealSpacing.sectionLarge))
            OutlineButton(
                state = OutlineButtonState(
                    text = stringResource(R.string.sign_up_navigate_to_sign_in),
                    onClick = state.onNavigateToSignInScreen,
                    modifier = Modifier.fillMaxWidth().padding(top = MyMealSpacing.componentMedium)
                )
            )
        }
    }
}

@Composable
@Preview
fun SubmittingEmailScreenPreview() {
    SubmittingEmailScreen(
        SubmittingEmailScreenState(
            email = "",
            onEmailChange = {}
        )
    )
}