package com.regera.aad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.regera.aad.R
import com.regera.aad.databinding.FragmentListBinding
import com.regera.aad.databinding.FragmentListUsersBinding


class ListUsersFragment : Fragment() {

    private var _binding: FragmentListUsersBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListUsersBinding.inflate(inflater, container, false)
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_listUsersFragment2_to_addUserFragment2)
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}