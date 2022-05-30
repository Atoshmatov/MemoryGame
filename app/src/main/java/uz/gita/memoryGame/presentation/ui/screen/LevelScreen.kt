package uz.gita.memoryGame.presentation.ui.screen

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.memoryGame.R
import uz.gita.memoryGame.data.comman.model.LevelData
import uz.gita.memoryGame.databinding.ScreenLevelBinding
import uz.gita.memoryGame.presentation.ui.adapter.LevelAdapter
import uz.gita.memoryGame.presentation.viewmodel.LevelViewModel
import uz.gita.memoryGame.presentation.viewmodel.impl.LevelViewModelImpl


@AndroidEntryPoint
class LevelScreen : Fragment(R.layout.screen_level) {

    private val binding by viewBinding(ScreenLevelBinding::bind)
    private val viewModel: LevelViewModel by viewModels<LevelViewModelImpl>()
    private val levelAdapter = LevelAdapter()
    private val args: LevelScreenArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        levelList.adapter = levelAdapter
        levelList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        viewModel.loadLevelList()
        viewModel.levelLiveData.observe(viewLifecycleOwner, levelObserver)
        levelAdapter.setOnclickItemListener {
            findNavController().navigate(
                LevelScreenDirections.actionLevelScreenToGameScreen(
                    args.type,
                    it
                )
            )
        }
    }

    private val levelObserver = Observer<List<LevelData>> {
        levelAdapter.submitList(it)
    }

}