package com.regera.aad

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.regera.aad.data.User
import com.regera.aad.data.UserViewModel
import com.regera.aad.databinding.FragmentUpdateUserBinding



class UpdateUserFragment : Fragment() {

    private var _binding: FragmentUpdateUserBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<UpdateUserFragmentArgs>()
    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateUserBinding.inflate(inflater, container, false)
        binding.updateFirstNameEt.setText(args.currentUser.firstName)
        binding.updateLastNameEt.setText(args.currentUser.lastName)
        binding.updateAgeEt.setText(args.currentUser.age.toString())

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.updateBtn.setOnClickListener {
            updateUser()
        }

        setHasOptionsMenu(true)

        return binding.root

    }

    private fun updateUser() {
        val firstName = binding.updateFirstNameEt.text.toString()
        val lastName = binding.updateLastNameEt.text.toString()
        val age = binding.updateAgeEt.text.toString()

        if (checkInput(firstName,lastName,age)){

            val updateUser = User(args.currentUser.id,firstName,lastName,age.toInt())
            userViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(),"successfully updated", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateUserFragment_to_listUsersFragment2)

        }
        else{
            Toast.makeText(requireContext(),"Please fill out the fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkInput(firstName:String, lastName:String, age: String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.user_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete){

            deleteUser()
        }

        return super.onOptionsItemSelected(item)
    }


    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes")
        { _,_->
            userViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(),"successfully delete ${args.currentUser.firstName}", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateUserFragment_to_listUsersFragment2)

        }
        builder.setNegativeButton("NO"){_,_->}
        builder.setTitle("Delete${args.currentUser.firstName}")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName} ")
        builder.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}