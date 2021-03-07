package ru.zmeytee.simpleproject.ui.albums

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
import ru.zmeytee.simpleproject.data.adapters.AlbumAdapter
import ru.zmeytee.simpleproject.databinding.FragmentAlbumsBinding
import ru.zmeytee.simpleproject.utils.autoCleared

@AndroidEntryPoint
class AlbumsFragment: Fragment(R.layout.fragment_albums) {

    private val viewModel by viewModels<AlbumsViewModel>()
    private val binding by viewBinding(FragmentAlbumsBinding::bind)
    private val args by navArgs<AlbumsFragmentArgs>()
    private var albumAdapter by autoCleared<AlbumAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        setListeners()
        initAlbumList()
        viewModel.getAllAlbums(args.userId)
    }

    private fun bindViewModel() {
        viewModel.albums.observe(viewLifecycleOwner) { albumAdapter.submitList(it) }
    }

    private fun setListeners() {
        binding.addAlbumFab.setOnClickListener {

        }
    }

    private fun initAlbumList() {
        albumAdapter = AlbumAdapter { navigateToComments(it) }

        with(binding.albumsList) {
            adapter = albumAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun navigateToComments(albumId: Long) {
        val action = AlbumsFragmentDirections.actionAlbumsFragmentToPhotosFragment(albumId)
        findNavController().navigate(action)
    }
}