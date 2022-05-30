package uz.gita.memoryGame.presentation.ui.screen

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.memoryGame.R
import uz.gita.memoryGame.data.comman.model.TypeData
import uz.gita.memoryGame.databinding.ScreenTypeBinding
import uz.gita.memoryGame.presentation.ui.adapter.TypeAdapter
import uz.gita.memoryGame.presentation.viewmodel.TypeViewModel
import uz.gita.memoryGame.presentation.viewmodel.impl.TypeViewModelImpl

@AndroidEntryPoint
class TypeScreen : Fragment(R.layout.screen_type) {
    private val binding by viewBinding(ScreenTypeBinding::bind)
    private val viewModel: TypeViewModel by viewModels<TypeViewModelImpl>()
    private val typeAdapter = TypeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        typeList.adapter = typeAdapter
        typeList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        viewModel.loadTypeList()
        viewModel.typeLiveData.observe(viewLifecycleOwner, typeObserver)
        typeAdapter.setOnclickItemListener {
            findNavController().navigate(TypeScreenDirections.actionTypeScreenToLevelScreen(it))
        }
    }

    private val typeObserver = Observer<List<TypeData>> {
        typeAdapter.submitList(it)
    }
}