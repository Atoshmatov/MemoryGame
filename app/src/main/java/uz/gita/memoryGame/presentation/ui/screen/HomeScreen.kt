package uz.gita.memoryGame.presentation.ui.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.memoryGame.R
import uz.gita.memoryGame.databinding.ScreenHomeBinding
import uz.gita.memoryGame.presentation.viewmodel.HomeViewModel
import uz.gita.memoryGame.presentation.viewmodel.impl.HomeViewModelImpl

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openLevelScreenLiveData.observe(this@HomeScreen, openLevelScreenObserver)
        viewModel.openRateLiveData.observe(this@HomeScreen, openRateObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        homeLikeButton.setOnClickListener {
            viewModel.openRate()
        }
        homePlayButton3.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.rotate))
        homePlayButton2.animate().setDuration(1000).scaleY(0.8f).withEndAction {
            homePlayButton2.animate().setDuration(1000).scaleY(1f)
        }.start()
        homePlayButton.setOnClickListener {
            imageLoad()
        }
        homePlayButton2.setOnClickListener {
            imageLoad()
        }
    }

    private val openLevelScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_homeScreen_to_typeScreen)
    }

    private val openRateObserver = Observer<Unit> {
        val browserIntent = Intent(Intent.ACTION_VIEW)
        browserIntent.data =
            Uri.parse("https://play.google.com/store/apps/developer?id=uz.gita.memoryGame")
        startActivity(browserIntent)
    }

    private fun imageLoad() = with(binding) {
        scope.launch {
            homePlayButton.animate()
                .setDuration(300)
                .alpha(1f)
                .setInterpolator(LinearInterpolator())
                .translationY(500f)
                .withEndAction {
                    homePlayButton.animate().setDuration(100).scaleYBy(0.5f)
                }.start()
            homeLikeButton.animate().setDuration(100).translationY(250f)
                .setInterpolator(LinearInterpolator()).start()
            homeShareButton.animate().setDuration(100).translationY(250f)
                .setInterpolator(LinearInterpolator()).start()
            homeMusicButton.animate().setDuration(100).translationY(250f)
                .setInterpolator(LinearInterpolator()).start()
            homePlayButton2.animate().setDuration(100).alpha(0f)
                .setInterpolator(LinearInterpolator()).start()
            homePlayButton3.animate().setDuration(100).alpha(0f)
                .setInterpolator(LinearInterpolator()).start()
            delay(300)
            viewModel.openLevelScreen()
        }
    }
}