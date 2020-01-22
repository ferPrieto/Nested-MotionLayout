package prieto.fernando.fancymotionlayout.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.animated_item_view.view.*
import prieto.fernando.fancymotionlayout.R

class AnimatedItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr) {
    private var initialized = false

    init {
        initializeView(context)
        attrs?.let(::applyAttributes)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        if (initialized) {
            root?.let {
                root.transitionToStart()
                root.transitionToEnd()
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initialized = true
    }

    private fun initializeView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.animated_item_view, this, true)
    }

    @SuppressLint("CustomViewStyleable")
    private fun applyAttributes(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.ConvertibleCardView)
        typedArray.setTextIfSet(text, R.styleable.ConvertibleCardView_title)
        typedArray.setImageIfSet(image, R.styleable.ConvertibleCardView_image)
        typedArray.recycle()
    }

    private fun TypedArray.setTextIfSet(textView: TextView, textViewTextRes: Int) =
        getText(textViewTextRes)?.let(textView::setText)

    private fun TypedArray.setImageIfSet(imageView: AppCompatImageView, imageViewTextRes: Int) =
        getDrawable(imageViewTextRes)?.let(imageView::setImageDrawable)
}
