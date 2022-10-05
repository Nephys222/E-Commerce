package com.nilearning.ecommerce.models

data class DataModel(val nestedList: List<String>, val itemText: String) {
    var isExpandable = false
}