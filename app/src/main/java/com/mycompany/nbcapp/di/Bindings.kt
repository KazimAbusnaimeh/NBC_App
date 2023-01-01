package com.mycompany.nbcapp.di

import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mycompany.nbcapp.R
import com.mycompany.nbcapp.models.Item

@BindingAdapter("app:loadImageFromUri")
fun loadImageFromUrl(imageView: ImageView, image: String?) {
    Glide.with(imageView.context)
        .load(image)
        .error(R.drawable.ic_launcher_background)
        .into(imageView)
}

@BindingAdapter("app:showIfLive")
fun showLiveText(tv: TextView, data: Item) {
    if (data.type == "Live") {
        tv.text = "live"
        tv.isVisible = true
    }
}

@BindingAdapter("app:showIfNeed")
fun showLabelText(tv: TextView, data: Item) {
    if (data.labelBadge != null) {
        tv.text = data.labelBadge
        tv.isVisible = true
    }
}


