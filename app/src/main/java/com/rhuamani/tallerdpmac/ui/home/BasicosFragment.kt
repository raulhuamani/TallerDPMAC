package com.rhuamani.tallerdpmac.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.rhuamani.tallerdpmac.R
import com.rhuamani.tallerdpmac.databinding.FragmentBasicosBinding

class BasicosFragment : Fragment() {

    private var _binding: FragmentBasicosBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBasicosBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val boton = view.findViewById<Button>(R.id.btnSaludo)
        binding.txtTitulo.text="Controles Basicos"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}