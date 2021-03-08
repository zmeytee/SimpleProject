package ru.zmeytee.simpleproject.ui.photos

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.adapters.PhotoAdapter
import ru.zmeytee.simpleproject.databinding.FragmentPhotosBinding
import ru.zmeytee.simpleproject.utils.autoCleared

@AndroidEntryPoint
class PhotosFragment: Fragment(R.layout.fragment_photos) {

    private val viewModel by viewModels<PhotosViewModel>()
    private val binding by viewBinding(FragmentPhotosBinding::bind)
    private var photoAdapter by autoCleared<PhotoAdapter>()
    private val args by navArgs<PhotosFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        setListeners()
        initPhotosList()
        if (savedInstanceState == null) { viewModel.getPhotos(args.albumId) }
    }

    private fun bindViewModel() {
        viewModel.photos.observe(viewLifecycleOwner) { photoAdapter.submitList(it) }
    }

    private fun setListeners() {
        binding.addPhotoFab.setOnClickListener {

        }
    }

    private fun initPhotosList() {
        photoAdapter = PhotoAdapter {

        }

        with(binding.photosList) {
            adapter = photoAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
        }
    }
}