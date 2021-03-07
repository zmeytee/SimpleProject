package ru.zmeytee.simpleproject.ui.persons.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.adapters.PersonAdapter
import ru.zmeytee.simpleproject.databinding.FragmentPersonsBinding
import ru.zmeytee.simpleproject.utils.autoCleared

@AndroidEntryPoint
class PersonsFragment : Fragment(R.layout.fragment_persons) {

    private val viewModel by viewModels<PersonsViewModel>()
    private val binding by viewBinding(FragmentPersonsBinding::bind)
    private var personAdapter by autoCleared<PersonAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setListeners()
        bindViewModel()
        initPersonsList()
        viewModel.getAllPersons()
    }

    private fun setListeners() {
        binding.addPersonFab.setOnClickListener {
            findNavController().navigate(R.id.action_personsFragment_to_addPersonDialogFragment)
        }
    }

    private fun bindViewModel() {
        with(viewModel) {
            persons.observe(viewLifecycleOwner) { personAdapter.items = it }
        }
    }

    private fun initPersonsList() {
        personAdapter = PersonAdapter { id ->
            navigateToPersonDetails(id)
        }

        with(binding.personsList) {
            adapter = personAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun navigateToPersonDetails(id: Long) {
        val action = PersonsFragmentDirections.actionPersonsFragmentToPersonDetailsFragment(id)
        findNavController().navigate(action)
    }
}