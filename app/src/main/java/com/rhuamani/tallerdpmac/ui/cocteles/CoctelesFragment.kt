package com.rhuamani.tallerdpmac.ui.cocteles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rhuamani.tallerdpmac.R
import com.rhuamani.tallerdpmac.databinding.FragmentCoctelesBinding

class CoctelesFragment : Fragment() {

    private var _binding: FragmentCoctelesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoctelesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCocteles: List<CoctelModel> = getListaCocteles()

        val adapterCocteles: RecyclerView.Adapter<CoctelAdapter.ViewHolder> = CoctelAdapter(listaCocteles)

        binding.rvCocteles.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCocteles.adapter = adapterCocteles


    }

    private fun getListaCocteles(): List<CoctelModel> {
        val cocteles = mutableListOf<CoctelModel>()
        //val cocteles : mutableList<CoctelModel>() = ArrayList()
        cocteles.add(CoctelModel("1", "Pisco Sour", "https://elcoctelero.com/wp-content/uploads/2020/10/coctel-pisco-sour-ok-e1616925946258.jpg"))
        cocteles.add(CoctelModel("2", "Daiquiri", "https://elcoctelero.com/wp-content/uploads/2020/10/coctel-daiquiri.jpg"))
        cocteles.add(CoctelModel("3", "Caipirinha", "https://elcoctelero.com/wp-content/uploads/2020/10/coctel-caipiri%C3%B1a-caipirinha.jpg"))
        cocteles.add(CoctelModel("2", "Mojito", "https://elcoctelero.com/wp-content/uploads/2020/09/coctel-mojito-e1606903836707.jpg"))
        cocteles.add(CoctelModel("2", "Bloody Mary", "https://elcoctelero.com/wp-content/uploads/2020/09/coctel-bloody-mary.jpg"))
        return cocteles
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}