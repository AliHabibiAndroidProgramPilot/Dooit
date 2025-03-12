package com.ali.dooit.ui

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import com.ali.dooit.R
import com.ali.dooit.databinding.FragmentWelcomePageBinding
import com.ali.dooit.mvp.ext.WelcomePageView
import com.ali.dooit.mvp.presenter.PresenterWelcomePageFragment

class WelcomePageFragment : Fragment(), WelcomePageView {

    private var _binding: FragmentWelcomePageBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: PresenterWelcomePageFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PresenterWelcomePageFragment(this)
        binding.btnContinue.setOnClickListener {
            val isLightModeOn: Boolean =
                (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_NO) ==
                        Configuration.UI_MODE_NIGHT_NO
            if (isLightModeOn) {
                presenter.setBackSystemBarsColors()
            }
            presenter.onContinueButtonClicked()
        }
    }

    override fun removeFragment() {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(0, R.animator.fade_out)
            .remove(this)
            .commit()
    }

    override fun setSystemBarsColors() {
        val window = requireActivity().window
        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        window.statusBarColor = Color.WHITE
        window.navigationBarColor = Color.WHITE
        insetsController.isAppearanceLightNavigationBars = true
        insetsController.isAppearanceLightStatusBars = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}