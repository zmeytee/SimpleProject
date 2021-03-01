package ru.zmeytee.simpleproject.ui.photos

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.databinding.FragmentPhotosBinding

class PhotosFragment: Fragment(R.layout.fragment_photos) {

    private val binding by viewBinding(FragmentPhotosBinding::bind)
}