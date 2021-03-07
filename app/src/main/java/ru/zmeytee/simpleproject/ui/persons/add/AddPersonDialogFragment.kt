package ru.zmeytee.simpleproject.ui.persons.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.databinding.DialogAddPersonBinding

@AndroidEntryPoint
class AddPersonDialogFragment: BottomSheetDialogFragment() {

    private val viewModel by viewModels<AddPersonViewModel>()
    private val binding by viewBinding(DialogAddPersonBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_add_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.addPersonButton.setOnClickListener { addPerson() }
    }

    private fun addPerson() {
        val newPerson = Person.AdvancedUser(
            id = 6,
            name = "Name",
            username = "Username",
            email = "Email",
            address = Person.AdvancedUser.Address(
                street = "Street",
                suite = "Suite",
                city = "City",
                zipcode = "ZipCode",
                geo = Person.AdvancedUser.Address.Geo(
                    lat = 2154.5,
                    lng = 215.21
                )
            ),
            phone = "Phone",
            website = "Website",
            company = Person.AdvancedUser.Company(
                name = "Company name",
                catchPhrase = "Company catchPhrase",
                bs = "Company bs"
            )
        )

        viewModel.addPerson(newPerson)
    }

}