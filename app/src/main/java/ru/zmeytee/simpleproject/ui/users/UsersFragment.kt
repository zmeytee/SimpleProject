package ru.zmeytee.simpleproject.ui.users

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.zmeytee.simpleproject.R
import ru.zmeytee.simpleproject.databinding.FragmentUsersBinding

class UsersFragment: Fragment(R.layout.fragment_users) {

    private val binding by viewBinding(FragmentUsersBinding::bind)
}