package uz.gita.memoryGame.presentation.ui.screen

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.memoryGame.R
import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.model.GameData
import uz.gita.memoryGame.databinding.ScreenGameBinding
import uz.gita.memoryGame.presentation.viewmodel.GameViewModel
import uz.gita.memoryGame.presentation.viewmodel.impl.GameViewModelImpl
import uz.gita.memoryGame.utils.px


@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {
    private val binding by viewBinding(ScreenGameBinding::bind)
    private val viewModel: GameViewModel by viewModels<GameViewModelImpl>()
    private val args: GameScreenArgs by navArgs()
    private var count = 0
    private var level: LevelEnum = LevelEnum.BEGINNER
    private var _height = 0
    private var _width = 0
    private var imageHeight = 0
    private var imageWidth = 0
    private val view = ArrayList<ImageView>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)


        args.level.apply {
            level = this
            count = x * y
        }
        container.post {
            imageWidth = container.width / level.x
            imageHeight = imageWidth
            _height = imageWidth * level.y
            container.layoutParams.apply {
                height = _height
            }
            loadView()
            viewModel.loadData(args.level, args.type)
        }
        viewModel.allGameDataLiveData.observe(viewLifecycleOwner, allGameDataObserver)
    }

    private fun loadView() {
        for (i in 0 until level.x) {
            for (j in 0 until level.y) {
                val image = ImageView(requireContext())
                binding.container.addView(image)
                val lp = image.layoutParams as RelativeLayout.LayoutParams
                lp.apply {
                    height = imageHeight
                    width = imageWidth
                }
                image.x = i * imageWidth * 1f
                image.y = j * imageHeight * 1f
                image.scaleType = ImageView.ScaleType.FIT_XY
                imagePadding(image)
                image.layoutParams = lp
                image.setImageResource(R.drawable.back_style)
                view.add(image)
            }
        }
    }

    private val allGameDataObserver = Observer<List<GameData>> { list ->
        for (i in list.indices) {
            view[i].tag = list[i]
            view[i].setOnClickListener {
                if (view[i].rotationY == 180f) closeClickImage(it as ImageView)
                else openClickImage(it as ImageView)
            }
        }

    }

    private fun openClickImage(image: ImageView) {
        image.animate().setDuration(300).rotationY(89f).withEndAction {
            image.setImageResource((image.tag as GameData).image)
            image.animate().setDuration(300).rotationY(180f).setInterpolator(LinearInterpolator())
                .withEndAction {}
        }.start()
    }

    private fun closeClickImage(image: ImageView) {
        image.animate().setDuration(300).rotationY(91f).withEndAction {
            image.setImageResource(R.drawable.back_style)
            image.animate().setDuration(300).rotationY(0f).setInterpolator(LinearInterpolator())
                .withEndAction {}
        }.start()
    }

    private fun imagePadding(image: ImageView) {
        when (args.level) {
            LevelEnum.BEGINNER -> {
                image.setPadding(14.px, 14.px, 14.px, 14.px)
            }
            LevelEnum.EASY -> {
                image.setPadding(8.px, 8.px, 8.px, 8.px)
            }
            LevelEnum.MEDIUM -> {
                image.setPadding(6.px, 6.px, 6.px, 6.px)
            }
            LevelEnum.HARD -> {
                image.setPadding(6.px, 6.px, 6.px, 6.px)
            }
            else -> {
                image.setPadding(3.px, 3.px, 3.px, 3.px)
            }
        }
    }
}