package uz.example.news.ui.fragments

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uz.example.news.Models.Article
import uz.example.news.Models.NewsModel
import uz.example.news.R
import uz.example.news.adapter.RvAdapter
import uz.example.news.databinding.FragmentFirstBinding
import uz.example.news.retrofit.Api
import uz.example.news.retrofit.NetWorkManager
import uz.example.news.ui.MainViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    lateinit var bind: FragmentFirstBinding
    lateinit var rvAdapter: RvAdapter




    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        bind = FragmentFirstBinding.bind(view)


        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]


        bind.swipe.setOnRefreshListener {
            loadData()
        }

        mainViewModel.proggress.observe(requireActivity(), Observer {
            bind.swipe.isRefreshing = it
        })



        mainViewModel.error.observe(requireActivity(), Observer {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        })

        bind.clickSports.setOnClickListener {
            mainViewModel.sportNews.observe(requireActivity(), Observer {


                bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                    override fun onClick(list: Article) {

                        var bundle = Bundle().apply {
                            putSerializable("key1", list)
                        }
                        findNavController().navigate(
                            R.id.action_firstFragment_to_secondFragment,
                            bundle
                        )

                    }
                })
            })
        }
        bind.clicktech.setOnClickListener {
            mainViewModel.technologyNews.observe(requireActivity(), Observer {


                bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                    override fun onClick(list: Article) {

                        var bundle = Bundle().apply {
                            putSerializable("key1", list)
                        }
                        findNavController().navigate(
                            R.id.action_firstFragment_to_secondFragment,
                            bundle
                        )

                    }
                })
            })
        }
        bind.clickBusiness.setOnClickListener {
            mainViewModel.businessNews.observe(requireActivity(), Observer {


                bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                    override fun onClick(list: Article) {

                        var bundle = Bundle().apply {
                            putSerializable("key1", list)
                        }
                        findNavController().navigate(
                            R.id.action_firstFragment_to_secondFragment,
                            bundle
                        )

                    }
                })
            })
        }
        bind.clickScience.setOnClickListener {
            mainViewModel.scienceNews.observe(requireActivity(), Observer {


                bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                    override fun onClick(list: Article) {

                        var bundle = Bundle().apply {
                            putSerializable("key1", list)
                        }
                        findNavController().navigate(
                            R.id.action_firstFragment_to_secondFragment,
                            bundle
                        )

                    }
                })
            })
        }
        bind.clickGenerl.setOnClickListener {
            mainViewModel.generalNews.observe(requireActivity(), Observer {


                bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                    override fun onClick(list: Article) {

                        var bundle = Bundle().apply {
                            putSerializable("key1", list)
                        }
                        findNavController().navigate(
                            R.id.action_firstFragment_to_secondFragment,
                            bundle
                        )

                    }
                })
            })
        }
        bind.clickHealth.setOnClickListener {
            mainViewModel.healthNews.observe(requireActivity(), Observer {


                bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                    override fun onClick(list: Article) {

                        var bundle = Bundle().apply {
                            putSerializable("key1", list)
                        }
                        findNavController().navigate(
                            R.id.action_firstFragment_to_secondFragment,
                            bundle
                        )

                    }

                })


            })
        }
        bind.clickEntertainment.setOnClickListener {
            mainViewModel.entertainmentNews.observe(requireActivity(), Observer {


                bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                    override fun onClick(list: Article) {

                        var bundle = Bundle().apply {
                            putSerializable("key1", list)
                        }
                        findNavController().navigate(
                            R.id.action_firstFragment_to_secondFragment,
                            bundle
                        )

                    }
                })


            })
        }

        mainViewModel.generalNews.observe(requireActivity(), Observer {


            bind.rv.adapter = RvAdapter(it, object : RvAdapter.OnClickListenerItem {

                override fun onClick(list: Article) {

                    var bundle = Bundle().apply {
                        putSerializable("key1", list)
                    }
                    findNavController().navigate(
                        R.id.action_firstFragment_to_secondFragment,
                        bundle
                    )

                }
            })
        })




        loadData()

        return view
    }


    fun loadData() {
//        mainViewModel.getGeneralNews()
        mainViewModel.getSportNews()
        mainViewModel.getBusinessNews()
        mainViewModel.getTechnologyNews()
        mainViewModel.getEntertainmentNews()
        mainViewModel.getHealthNews()
        mainViewModel.getScienceNews()

        mainViewModel.getAllView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}