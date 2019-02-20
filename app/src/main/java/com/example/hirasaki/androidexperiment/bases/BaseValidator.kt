package com.example.hirasaki.androidexperiment.bases

import com.example.hirasaki.androidexperiment.util.ErrorMessage

open class BaseValidator: BaseValidatorInterface {
    private var result: Array<ErrorMessage>

    constructor() {
        result = listOf<ErrorMessage>().toTypedArray()
    }

    override fun run(model: BaseModel) {
    }

    override fun getResult(): Array<ErrorMessage> {
        return result
    }

    override fun execute(model: BaseModel): Array<ErrorMessage> {
        run(model)
        return getResult()
    }
}

interface BaseValidatorInterface {
    fun run(model: BaseModel)
    fun getResult(): Array<ErrorMessage>
    fun execute(model: BaseModel): Array<ErrorMessage>
}
