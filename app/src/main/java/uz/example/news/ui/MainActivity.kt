package uz.example.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.example.news.R
import uz.example.news.databinding.ActivityMainBinding
import uz.example.news.ui.fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var firstFragment= FirstFragment.newInstance()
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//       viewModel=ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel= MainViewModel()

        viewModel.generalNews.observe(this, Observer {
            viewModel.insertAllView(it)
            firstFragment.loadData()
        })




        loadData()
    }

    private fun loadData(){
        viewModel.getGeneralNews()
    }
}