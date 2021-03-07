package ru.zmeytee.simpleproject.ui.users.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.data.adapters.UserAdapter
import ru.zmeytee.simpleproject.databinding.FragmentUsersBinding
import ru.zmeytee.simpleproject.utils.autoCleared

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {

    private val viewModel by viewModels<UsersViewModel>()
    private val binding by viewBinding(FragmentUsersBinding::bind)
    private var userAdapter by autoCleared<UserAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
        bindViewModel()
        initUsersList()
        viewModel.getAllUsers()
    }

    private fun setListeners() {
        binding.addUserFab.setOnClickListener {
            findNavController().navigate(R.id.action_usersFragment_to_addUserDialogFragment)
        }
    }

    private fun bindViewModel() {
        with(viewModel) {
            users.observe(viewLifecycleOwner) { userAdapter.items = it }
        }
    }

    private fun initUsersList() {
        userAdapter = UserAdapter { navigateToUserDetails(it) }

        with(binding.usersList) {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun navigateToUserDetails(userId: Long) {
        val action = UsersFragmentDirections.actionUsersFragmentToUserDetailsFragment(userId)
        findNavController().navigate(action)
    }
}