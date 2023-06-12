package com.based.kotlin.learncompose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.based.kotlin.learncompose.ui.theme.LearnComposeTheme
import java.text.NumberFormat

@Preview(showBackground = true)
@Composable
fun CalculatorPreview(){
    LearnComposeTheme {
        Calculator()
    }
}

@Composable
fun Calculator(){
    var amountInput by rememberSaveable { mutableStateOf("0") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0

    var tipInput by rememberSaveable { mutableStateOf("") }
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0

    var roundUp by rememberSaveable { mutableStateOf(false) }
    val tip = calculateTip(amount, tipPercent, roundUp)

    Column(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            label = R.string.bill_amount,
            leadingIcon = R.drawable.ic_launcher_foreground,
            amount = amountInput,
            onValueChange = { amountInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            label = R.string.how_was_the_service,
            leadingIcon = R.drawable.ic_launcher_foreground,
            amount = tipInput,
            onValueChange = { tipInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(150.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon : Int,
    amount: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions,
    ) {
    OutlinedTextField(
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        label = { Text(text = stringResource(id = label)) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        value = amount,
        onValueChange = onValueChange,
        modifier = modifier
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp)
        tip = kotlin.math.ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
        )
    }
}