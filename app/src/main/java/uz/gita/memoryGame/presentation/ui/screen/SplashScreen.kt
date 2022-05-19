package uz.gita.memoryGame.presentation.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.memoryGame.R
import uz.gita.memoryGame.databinding.ScreenSplashBinding
import uz.gita.memoryGame.presentation.viewmodel.SplashViewModel
import uz.gita.memoryGame.presentation.viewmodel.impl.SplashViewModelImpl

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val binding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        viewModel.openNextLiveData.observe(viewLifecycleOwner, openNextObserver)
    }

    private val openNextObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_homeScreen)
    }
}