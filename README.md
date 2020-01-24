
# Nested MotionLayout  
  
![demo](art/Demo-Nested-MotionLayout.gif)  
  
The purpose of this project is to show up the complexity, pros and cons of going against what Google mentions in the [MotionLayout documentation][motionLayout]:  
>Note: MotionLayout works only with its direct children. It does not support nested layout hierarchies or activity transitions.  
  
[motionLayout]: https://developer.android.com/training/constraint-layout/motionlayout  
  
## Experiment  
  
Following one of the Mike Scamell's examples [Loco-MotionLayout][locoMotionLayout], I found quite interesting using the main structure and experimenting creating animations connected between the two different `includes`:  
  
[locoMotionLayout]:https://github.com/mikescamell/Loco-MotionLayout  
```  
<com.google.android.material.appbar.AppBarLayout  
 android:id="@+id/app_bar" 
 android:layout_width="match_parent" 
 android:layout_height="@dimen/app_bar_height"
 android:theme="@style/AppTheme.AppBarOverlay">  
	 <include layout="@layout/coordinatorlayout_header"/>
</com.google.android.material.appbar.AppBarLayout>  
 <include layout="@layout/content_scrolling" />
 ```  
  
### Realisation  
  
Using scenes within the xml files, forces you to have all of your animations views in the same `layout` (it was acknowledged with the Android documentation). Then, in case you want to communicate one of those includes with the other one, you might need to use the listeners provided in your UI. For example:  
```  
motionWrapper.setTransitionListener(object : MotionLayout.TransitionListener {  
 override fun onTransitionTrigger( p0: MotionLayout?, p1: Int,  p2: Boolean, p3: Float ) {} override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) { if (isFirstTransition) { background.animate().alpha(0f).setDuration(500) .setInterpolator(AccelerateInterpolator()).start() } else { background.setImageDrawable(getDrawable(R.drawable.ic_header_background)) } } override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {} override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) { if (isFirstTransition) { background.animate().alpha(1f).setDuration(200) .setInterpolator(AccelerateInterpolator()).start() background.setImageDrawable(getDrawable(R.drawable.ic_emilia)) } } })
```
And also things like calling the animation trigger from the desired point of the code:  

```  
root.transitionToStart()  
root.transitionToEnd()  
```  
  
### Findings  
  
If the plan is making animations between so many elements, make sure all of them are included in the same layout. The down side of this is that, the layout might become too big.  
  
### Upcoming projects related   
Applying these insights, I'll publish a project with different cool animations, assuming all of the views will be included in the same layout.   
  
#  License  
  
 Copyright 2020 Fernando Prieto Moyano  
 Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at  
 http://www.apache.org/licenses/LICENSE-2.0  
 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.