package com.example.tugastpcempatnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var getUsername = arguments?.getString("dataUsername")
        tv_nama.text = "$getUsername"

        btn_hitung.setOnClickListener {
            var tahunLahir = edt_input_lahir.text.toString().toInt()
            var HitungUmur = 2022 - tahunLahir
            tv_nama.text = getUsername
            var nama = tv_nama.text.toString()
            var bundle = Bundle()
            bundle.putString("dataTahunLahir", HitungUmur.toString())
            bundle.putString("dataNama", nama)
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_hasilHitungUmurFragment, bundle)
        }

        ib_profile.setOnClickListener {
            tv_nama.text = getUsername
            var name = tv_nama.text.toString()
            var bundle = Bundle()
            bundle.putString("dataNama", name)
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileFragment,bundle)
        }
    }
}