package ru.zmeytee.simpleproject.ui.posts

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.databinding.FragmentPostsBinding

class PostsFragment: Fragment(R.layout.fragment_posts) {

    private val binding by viewBinding(FragmentPostsBinding::bind)
}