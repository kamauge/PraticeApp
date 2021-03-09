package com.regera.aad

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.regera.aad.data.User
import com.regera.aad.data.UserViewModel
import com.regera.aad.databinding.FragmentAddUserBinding


class AddUserFragment : Fragment() {

    private var _binding: FragmentAddUserBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddUserBinding.inflate(inflater, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.addBtn.setOnClickListener{
            insertDataToDatabase()
        }

        return binding.root

    }

    private fun insertDataToDatabase() {

        val firstName = binding.addFirstNameEt.text.toString()
        val lastName = binding.addLastNameEt.text.toString()
        val age = binding.addAgeEt.text.toString()

        if (checkInput(firstName,lastName,age)){

            val user = User(0,firstName,lastName,age.toInt())

            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"successfully added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addUserFragment2_to_listUsersFragment2)

        }
        else{
            Toast.makeText(requireContext(),"Please fill out the fields",Toast.LENGTH_LONG).show()
        }
    }

    private fun checkInput(firstName:String, lastName:String, age: String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}