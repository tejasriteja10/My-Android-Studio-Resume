package com.example.myapplication1

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.databinding.ActivityMainBinding  // View Binding import

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isSkillsExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupInteractiveElements()
    }

    private fun setupInteractiveElements() {
        binding.skillsCard.setOnClickListener {
            toggleSkillsVisibility()
        }
    }

    private fun toggleSkillsVisibility() {
        isSkillsExpanded = !isSkillsExpanded

        binding.skillsContent.visibility = if (isSkillsExpanded) View.VISIBLE else View.GONE
        binding.skillsExpandIcon.animate()
            .rotation(if (isSkillsExpanded) 180f else 0f)
            .setDuration(300)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .start()
    }

    fun onEmailClicked(view: View) {
        // Handle email click
    }
}