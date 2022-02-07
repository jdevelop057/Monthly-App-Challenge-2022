package com.jdevelop.starwarsapp.ui.component.progressbar

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.annotation.ColorInt
import com.jdevelop.starwarsapp.databinding.ComponentProgressbarBinding

/**
 * Created by Jdevelop057 on 07/02/2022.
 */
class ComponentProgressBar : LinearLayout {
    private lateinit var binding: ComponentProgressbarBinding
    private lateinit var progressBar: ProgressBar

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet?, i: Int) : super(
        context,
        attributeSet,
        i
    ) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        binding = ComponentProgressbarBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
        progressBar = binding.progressBar
    }

    fun setProgressBarColor(@ColorInt color: Int) {
        progressBar.indeterminateTintList = ColorStateList.valueOf(color)
    }
}