package uz.gita.memoryGame.presentation.ui.screen

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
import uz.gita.memoryGame.databinding.ScreenHomeBinding
import uz.gita.memoryGame.presentation.viewmodel.HomeViewModel
import uz.gita.memoryGame.presentation.viewmodel.impl.HomeViewModelImpl

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openLevelScreenLiveData.observe(this@HomeScreen, openLevelScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        homePlayButton.setOnClickListener {
            viewModel.openLevelScreen()
        }
    }

    private val openLevelScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_homeScreen_to_typeScreen)
    }
}