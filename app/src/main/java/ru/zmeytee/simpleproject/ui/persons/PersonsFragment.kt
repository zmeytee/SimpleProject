package ru.zmeytee.simpleproject.ui.persons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.adapters.PersonAdapter
import ru.zmeytee.simpleproject.databinding.FragmentUsersBinding
import ru.zmeytee.simpleproject.utils.autoCleared
import kotlin.random.Random

@AndroidEntryPoint
class PersonsFragment(): Fragment(R.layout.fragment_users) {

    private val viewModel by viewModels<PersonsViewModel>()
    private val binding by viewBinding(FragmentUsersBinding::bind)
    private var personAdapter by autoCleared<PersonAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        setListeners()
        initPersonsList()
        viewModel.getAllPersons()
    }

    private fun bindViewModel() {
        with(viewModel) {
            persons.observe(viewLifecycleOwner) { personAdapter.items = it }
        }
    }

    private fun setListeners() {
        binding.getUserButton.setOnClickListener {
            viewModel.getPersonById(Random.nextLong(1, 10))
        }
    }

    private fun initPersonsList() {
        personAdapter = PersonAdapter()

        with(binding.personsList) {
            adapter = personAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }
}