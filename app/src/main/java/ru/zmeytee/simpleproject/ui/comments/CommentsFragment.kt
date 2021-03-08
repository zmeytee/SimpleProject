package ru.zmeytee.simpleproject.ui.comments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.adapters.CommentAdapter
import ru.zmeytee.simpleproject.databinding.FragmentCommentsBinding
import ru.zmeytee.simpleproject.utils.autoCleared
import ru.zmeytee.simpleproject.utils.toast

@AndroidEntryPoint
class CommentsFragment: Fragment(R.layout.fragment_comments) {

    private val viewModel by viewModels<CommentsViewModel>()
    private val binding by viewBinding(FragmentCommentsBinding::bind)
    private val args by navArgs<CommentsFragmentArgs>()
    private var commentAdapter by autoCleared<CommentAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        setListeners()
        initCommentsList()
        if (savedInstanceState == null) { viewModel.getComments(args.postId) }
    }

    private fun bindViewModel() {
        viewModel.comments.observe(viewLifecycleOwner) { commentAdapter.submitList(it) }
    }

    private fun setListeners() {
        binding.addAlbumFab.setOnClickListener {

        }
    }

    private fun initCommentsList() {
        commentAdapter = CommentAdapter {
            toast("Comment click")
        }

        with(binding.commentsList) {
            adapter = commentAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }
}