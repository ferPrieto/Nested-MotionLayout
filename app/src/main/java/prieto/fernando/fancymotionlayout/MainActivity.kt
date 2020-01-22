package prieto.fernando.fancymotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_scrolling.*
import prieto.fernando.fancymotionlayout.utils.AnimatedItemClick
import kotlinx.android.synthetic.main.content_scrolling.motion_wrapper as motionWrapper

class MainActivity : AppCompatActivity(), AnimatedItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first_item.setAnimatedItemClick(this)
    }

    override fun onClickListener() {
        motionWrapper?.let {
            motionWrapper.transitionToStart()
            motionWrapper.transitionToEnd()
        }
    }
}
