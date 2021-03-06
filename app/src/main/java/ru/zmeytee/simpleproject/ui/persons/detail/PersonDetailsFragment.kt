package ru.zmeytee.simpleproject.ui.persons.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.databinding.FragmentPersonDetailsBinding

@AndroidEntryPoint
class PersonDetailsFragment(): Fragment(R.layout.fragment_person_details) {

    private val viewModel by viewModels<PersonDetailsViewModel>()
    private val binding by viewBinding(FragmentPersonDetailsBinding::bind)
    private val args: PersonDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPerson(args.personId)
        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.currentPerson.observe(viewLifecycleOwner) {
            showPersonDetails(it)
        }
    }

    private fun getPerson(id: Long) {
        viewModel.getPerson(id)
    }

    private fun showPersonDetails(person: Person) {
        when(person) {
            is Person.AdvancedUser -> showAdvancedUserDetails(person)
            else -> error("Incorrect arguments")
        }
    }

    private fun showAdvancedUserDetails(advancedUser: Person.AdvancedUser) {
        with(binding) {
            name.text = advancedUser.name
            userName.text = advancedUser.username
            email.text = advancedUser.email
            addressStreet.text = advancedUser.address.street
            addressCity.text = advancedUser.address.city
            companyName.text = advancedUser.company.name
            companyCatchPhrase.text = advancedUser.company.catchPhrase
        }
    }
}