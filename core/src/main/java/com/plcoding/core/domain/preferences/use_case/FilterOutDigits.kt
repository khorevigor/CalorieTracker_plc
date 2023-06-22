package com.plcoding.core.domain.preferences.use_case

class FilterOutDigits {

    operator fun invoke(text: String) : String {
        return text.filter { it.isDigit() }
    }
}
