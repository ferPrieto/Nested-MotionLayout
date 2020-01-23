package prieto.fernando.fancymotionlayout.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.animated_item_view.view.*
import prieto.fernando.fancymotionlayout.R

class AnimatedItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), View.OnClickListener {
    private var initialized = false
    private var isFirstTransition = true

    private lateinit var animatedItemClick: AnimatedItemClick

    init {
        initializeView(context)
        attrs?.let(::applyAttributes)
    }

    fun setAnimatedItemClick(animatedItemClick: AnimatedItemClick) {
        this.animatedItemClick = animatedItemClick
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        performTransition()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initialized = true
        root.setOnClickListener {
            animatedItemClick.onClickListener()
            performTransition()
        }
    }

    private fun performTransition() {
        if (initialized) {
            root?.let {
                if (isFirstTransition) {
                    root.setTransitionDuration(200)
                    isFirstTransition = false
                } else {
                    isFirstTransition = true
                    root.setTransitionDuration(800)
                }
                root.transitionToStart()
                root.transitionToEnd()
            }
        }
    }

    private fun initializeView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.animated_item_view, this, true)
    }

    @SuppressLint("CustomViewStyleable")
    private fun applyAttributes(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.ConvertibleCardView)
        typedArray.setTextIfSet(item_text, R.styleable.ConvertibleCardView_title)
        typedArray.setImageIfSet(item_image, R.styleable.ConvertibleCardView_image)
        typedArray.recycle()
    }

    private fun TypedArray.setTextIfSet(textView: TextView, textViewTextRes: Int) =
        getText(textViewTextRes)?.let(textView::setText)

    private fun TypedArray.setImageIfSet(imageView: AppCompatImageView, imageViewTextRes: Int) =
        getDrawable(imageViewTextRes)?.let(imageView::setImageDrawable)

    override fun onClick(v: View?) {
        animatedItemClick.onClickListener()
    }
}

interface AnimatedItemClick {
    fun onClickListener()
}
