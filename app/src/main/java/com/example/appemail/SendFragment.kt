package com.example.appemail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.appemail.databinding.FragmentSendBinding


class SendFragment : Fragment() {

    private lateinit var binding: FragmentSendBinding
    lateinit var sendFrom: String
    lateinit var sendTo: String
    lateinit var sendSubject: String
    lateinit var sendCompose: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_send, menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_send, container, false)
        return binding.root
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.send -> {
                sendFrom = binding.etFrom.text.toString().trim()
                sendTo = binding.etTo.text.toString().trim()
                sendSubject = binding.etSubject.text.toString().trim()
                sendCompose = binding.etComposeEmail.text.toString().trim()
                val action = SendFragmentDirections.actionSendFragmentToReceiveFragment(sendFrom, sendTo, sendSubject, sendCompose)
                view?.findNavController()?.navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}