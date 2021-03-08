package ru.zmeytee.simpleproject.ui.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.adapters.PostAdapter
import ru.zmeytee.simpleproject.databinding.FragmentPostsBinding
import ru.zmeytee.simpleproject.utils.autoCleared

@AndroidEntryPoint
class PostsFragment: Fragment(R.layout.fragment_posts) {

    private val viewModel by viewModels<PostsViewModel>()
    private val binding by viewBinding(FragmentPostsBinding::bind)
    private val args by navArgs<PostsFragmentArgs>()
    private var postAdapter by autoCleared<PostAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        setListeners()
        initPostsList()
        if (savedInstanceState == null) { viewModel.getPosts(args.userId) }
    }

    private fun bindViewModel() {
        viewModel.posts.observe(viewLifecycleOwner) { postAdapter.submitList(it) }
    }

    private fun setListeners() {

    }

    private fun initPostsList() {
        postAdapter = PostAdapter { navigateToComments(it) }

        with(binding.postsList) {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun navigateToComments(postId: Long) {
        val action = PostsFragmentDirections.actionPostsFragmentToCommentsFragment(postId)
        findNavController().navigate(action)
    }
}