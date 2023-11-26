package com.rhuamani.tallerdpmac.ui.basicos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
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
        binding.txtTitulo.text = "Controles Basicos"
        val titulo = binding.txtTitulo.text

        binding.btnSaludo.setOnClickListener { _ ->
            val nombres = binding.edtNombres.text.toString()
            val apellidos = binding.tietApellidos.text
            Toast.makeText(requireContext(), "Hola $nombres $apellidos", Toast.LENGTH_SHORT).show()
        }
        binding.imgFoto.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_launcher_foreground
            )
        )
        binding.imgFoto.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))

        binding.switch1.setOnClickListener {
            if (binding.switch1.isChecked) {
                binding.switch1.text = "PowerOn"
                binding.progressBar.visibility = View.VISIBLE
                binding.toggleButton.isChecked = true
            } else {
                binding.switch1.text = "PowerOff"
                binding.progressBar.visibility = View.INVISIBLE
                binding.toggleButton.isChecked = false
            }
        }

        binding.toggleButton.setOnClickListener {
            if (binding.toggleButton.isChecked) {
                binding.progressBar.visibility = View.VISIBLE
                binding.switch1.isChecked = true
                binding.switch1.text = "PowerOn"
            } else {
                binding.progressBar.visibility = View.INVISIBLE
                binding.switch1.isChecked = false
                binding.switch1.text = "PowerOff"
            }
        }

        val estados = mutableListOf<String>()
        estados.add("Soltero")
        estados.add("Casado")
        estados.add("Conviviente")
        estados.add("Viudo")
        estados.add("Divorciado")

        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), R.layout.spinner_item, estados)

        binding.spinner.adapter = spinnerAdapter

        binding.rgSexo.setOnCheckedChangeListener { _, _ ->
            if (binding.rbMasculino.isChecked){
                Toast.makeText(requireContext(), "Sexo Masculino", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(requireContext(), "Sexo Femenino", Toast.LENGTH_SHORT).show()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}