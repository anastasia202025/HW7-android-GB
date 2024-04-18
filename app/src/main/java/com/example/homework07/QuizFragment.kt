package com.example.homework07

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework07.databinding.FragmentQuizBinding
class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSendAnswers.setOnClickListener {
            val number = getAnswersByUser()
            val action = QuizFragmentDirections.actionQuizFragmentToResultFragment(number)
            findNavController().navigate(action)
        }
    }

    private fun getAnswersByUser() : Int {
        var currentAnswers = 0

        if (binding.radiogroupAnswers01.checkedRadioButtonId == binding.radiobuttonAnswer0103.id)
            currentAnswers++
        if (binding.radiogroupAnswers02.checkedRadioButtonId == binding.radiobuttonAnswer0204.id)
            currentAnswers++
        if (binding.radiogroupAnswers03.checkedRadioButtonId == binding.radiobuttonAnswer0302.id)
            currentAnswers++
        if (binding.radiogroupAnswers04.checkedRadioButtonId == binding.radiobuttonAnswer0401.id)
            currentAnswers++

        return currentAnswers
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
