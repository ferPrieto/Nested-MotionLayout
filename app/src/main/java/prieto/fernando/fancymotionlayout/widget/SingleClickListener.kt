package prieto.fernando.fancymotionlayout.widget

import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

const val THRESHOLD_MILLIS: Long = 600L

abstract class SingleClickListener : View.OnClickListener {
    private val publishSubject: PublishSubject<View> = PublishSubject.create()

    abstract fun onClicked(v: View)

    override fun onClick(p0: View?) {
        if (p0 != null) {
            publishSubject.onNext(p0)
        }
    }

    init {
        publishSubject.throttleFirst(THRESHOLD_MILLIS, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { v -> onClicked(v) }
    }
}