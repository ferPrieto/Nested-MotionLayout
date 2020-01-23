package prieto.fernando.fancymotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.coordinatorlayout_header.*
import prieto.fernando.fancymotionlayout.utils.AnimatedItemClick
import kotlinx.android.synthetic.main.content_scrolling.motion_wrapper as motionWrapper

class MainActivity : AppCompatActivity(), AnimatedItemClick {
    private var isFirstTransition = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first_item.setAnimatedItemClick(this)
        scrollable.setOnScrollChangeListener { _, _, _, _, _ ->
            constraintToolbar.setTransition(
                R.id.start,
                R.id.end
            )
        }
        motionWrapper.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(
                p0: MotionLayout?,
                p1: Int,
                p2: Boolean,
                p3: Float
            ) {}

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                if (!isFirstTransition) {
                    background.setImageDrawable(getDrawable(R.drawable.ic_header_background))
                }
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                if (isFirstTransition) {
                    background.setImageDrawable(getDrawable(R.drawable.ic_daenerys))
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        isFirstTransition = true
    }

    override fun onClickListener(isFirstTransition: Boolean) {
        this.isFirstTransition = isFirstTransition
        motionWrapper?.let {
            if (isFirstTransition) {
                motionWrapper.setTransitionDuration(550)
            } else {
                motionWrapper.setTransitionDuration(110)
            }
            motionWrapper.transitionToStart()
            motionWrapper.transitionToEnd()
        }
    }
}
