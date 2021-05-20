package droidninja.filepicker

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.MaterialToolbar

/**
 * Created by droidNinja on 22/07/17.
 */

abstract class BaseFilePickerActivity : AppCompatActivity() {

    protected fun onCreate(savedInstanceState: Bundle?, @LayoutRes layout: Int) {
        super.onCreate(savedInstanceState)
        setTheme(PickerManager.theme)
        setContentView(layout)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //设置标题文字颜色
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white))
        //设在标题背景
        toolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.blue))
        //是否显示返回按钮
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //设置返回按钮图标
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_24)

        //set orientation
        requestedOrientation = PickerManager.orientation
        initView()
    }

    protected abstract fun initView()
}
