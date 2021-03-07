package ru.zmeytee.simpleproject.ui.users.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.models.User
import ru.zmeytee.simpleproject.databinding.FragmentUserDetailsBinding

@AndroidEntryPoint
class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private val viewModel by viewModels<UserDetailsViewModel>()
    private val binding by viewBinding(FragmentUserDetailsBinding::bind)
    private val args by navArgs<UserDetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUser(args.userId)
        bindViewModel()
        setListeners()
    }

    private fun bindViewModel() {
        viewModel.currentUser.observe(viewLifecycleOwner) { showUserDetails(it) }
    }

    private fun setListeners() {
        with(binding) {
            toAlbumsButton.setOnClickListener {
                val action = UserDetailsFragmentDirections
                    .actionUserDetailsFragmentToAlbumsFragment(args.userId)
                findNavController().navigate(action)
            }
            toPostsButton.setOnClickListener {
                val action = UserDetailsFragmentDirections
                    .actionUserDetailsFragmentToPostsFragment(args.userId)
                findNavController().navigate(action)
            }
        }
    }

    private fun getUser(id: Long) {
        viewModel.getUser(id)
    }

    private fun showUserDetails(user: User) {
        when (user) {
            is User.AdvancedUser -> showAdvancedUserDetails(user)
            else -> error("Incorrect arguments")
        }
    }

    private fun showAdvancedUserDetails(advancedUser: User.AdvancedUser) {
        with(binding) {
            nameTextView.text = advancedUser.name
            userNameTextView.text = advancedUser.username
            emailTextView.text = advancedUser.email
            addressStreetTextView.text = advancedUser.address.street
            addressCityTextView.text = advancedUser.address.city
            companyNameTextView.text = advancedUser.company.name
            companyCatchPhraseTextView.text = advancedUser.company.catchPhrase
        }
    }
}