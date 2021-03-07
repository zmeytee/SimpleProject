package ru.zmeytee.simpleproject.ui.users.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.models.User
import ru.zmeytee.simpleproject.databinding.DialogAddUserBinding

@AndroidEntryPoint
class AddUserDialogFragment: BottomSheetDialogFragment() {

    private val viewModel by viewModels<AddUserViewModel>()
    private val binding by viewBinding(DialogAddUserBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_add_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.addUserButton.setOnClickListener { addUser() }
    }

    private fun addUser() {
        val newUser = User.AdvancedUser(
            id = 6,
            name = "Name",
            username = "Username",
            email = "Email",
            address = User.AdvancedUser.Address(
                street = "Street",
                suite = "Suite",
                city = "City",
                zipcode = "ZipCode",
                geo = User.AdvancedUser.Address.Geo(
                    lat = 2154.5,
                    lng = 215.21
                )
            ),
            phone = "Phone",
            website = "Website",
            company = User.AdvancedUser.Company(
                name = "Company name",
                catchPhrase = "Company catchPhrase",
                bs = "Company bs"
            )
        )

        viewModel.addUser(newUser)
    }

}