package prieto.fernando.fancymotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.animated_item_view.view.*
import kotlinx.android.synthetic.main.content_scrolling.*
import prieto.fernando.fancymotionlayout.utils.AnimatedItemClick
import kotlinx.android.synthetic.main.content_scrolling.motion_wrapper as motionWrapper

class MainActivity : AppCompatActivity(), AnimatedItemClick {
    private var isFirstTransition = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first_item.setAnimatedItemClick(this)
    }

    override fun onClickListener() {

        motionWrapper?.let {
            if (isFirstTransition) {
                motionWrapper.setTransitionDuration(550)
                isFirstTransition = false
            } else {
                isFirstTransition = true
                motionWrapper.setTransitionDuration(110)
            }
            motionWrapper.transitionToStart()
            motionWrapper.transitionToEnd()
        }
    }
}
