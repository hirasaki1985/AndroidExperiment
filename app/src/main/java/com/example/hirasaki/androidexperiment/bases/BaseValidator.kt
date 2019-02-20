package com.example.hirasaki.androidexperiment.bases

import com.example.hirasaki.androidexperiment.util.ErrorMessage

open class BaseValidator: BaseValidatorInterface {
    private var result: Array<ErrorMessage>

    constructor() {
        result = mutableListOf<ErrorMessage>().toTypedArray()
    }

    override fun validate(model: BaseModel): Array<ErrorMessage> {
        return result
    }

    override fun setResult(_result: Array<ErrorMessage>) {
        result = _result
    }

    override fun getResult(): Array<ErrorMessage> {
        return result
    }

    override fun execute(model: BaseModel): Array<ErrorMessage> {
        setResult(validate(model))
        return getResult()
    }
}

interface BaseValidatorInterface {
    fun validate(model: BaseModel): Array<ErrorMessage>
    fun setResult(_result: Array<ErrorMessage>)
    fun getResult(): Array<ErrorMessage>
    fun execute(model: BaseModel): Array<ErrorMessage>
}
