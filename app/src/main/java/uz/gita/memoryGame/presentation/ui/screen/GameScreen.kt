package uz.gita.memoryGame.presentation.ui.screen

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.memoryGame.R


@AndroidEntryPoint
class GameScreen: Fragment(R.layout.screen_game){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}