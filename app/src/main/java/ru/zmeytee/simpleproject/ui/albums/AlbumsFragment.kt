package ru.zmeytee.simpleproject.ui.albums

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.databinding.FragmentAlbumsBinding

class AlbumsFragment: Fragment(R.layout.fragment_albums) {

    private val binding by viewBinding(FragmentAlbumsBinding::bind)
}