
package edu.temple.selectionactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ImageViewModel(): ViewModel() {

    val message: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val image by lazy { MutableLiveData<String>() }


    fun setMessage(item: String?) {
        message.value = item
    }

    fun setImage(item: String?) {
        image.value = item
    }

    fun getMessage(): String? {
        return message.value
    }

    fun getImage(): String? {
        return image.value
    }
}