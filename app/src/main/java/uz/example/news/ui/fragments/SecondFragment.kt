package uz.example.news.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import uz.example.news.Models.Article
import uz.example.news.R
import uz.example.news.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
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

    lateinit var month:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_second, container, false)
        val bind=FragmentSecondBinding.bind(view)
        val list=arguments?.getSerializable("key1") as Article


        bind.author.text=list.author?.subSequence(0,1)
        Picasso.get().load(list.urlToImage).into(bind.imageBottom)
        bind.titleTv.text=list.title
        bind.descriptionTv.text=list.description

        bind.denTv.text=list.publishedAt?.subSequence(8,10)

        if (list.publishedAt?.subSequence(6,7)=="1"){
            month="January"
        }else if (list.publishedAt?.subSequence(6,7)=="2"){
            month="February"
        }else if (list.publishedAt?.subSequence(6,7)=="3"){
            month="March"
        }else if (list.publishedAt?.subSequence(6,7)=="4"){
            month="April"
        }else if (list.publishedAt?.subSequence(6,7)=="5"){
            month="May"
        }else if (list.publishedAt?.subSequence(6,7)=="6"){
            month="June"
        }else if (list.publishedAt?.subSequence(6,7)=="7"){
            month="July"
        }else if (list.publishedAt?.subSequence(6,7)=="8"){
            month="August"
        }else if (list.publishedAt?.subSequence(6,7)=="9"){
            month="September"
        }else if (list.publishedAt?.subSequence(6,7)=="10"){
            month="October"
        }else if (list.publishedAt?.subSequence(6,7)=="11"){
            month="November"
        }else if (list.publishedAt?.subSequence(6,7)=="12"){
            month="December"
        }

        bind.yearTv.text=list.publishedAt?.subSequence(0,4)
        bind.monthTv.text=month

//        val list2=arguments?.getSerializable("key1") as Article
//
//        bind.author.text=list2.author.subSequence(0,1)
//        Picasso.get().load(list2.urlToImage).into(bind.imageBottom)
//        bind.titleTv.text=list2.title
//        bind.descriptionTv.text=list2.description
//
//        bind.denTv.text=list2.publishedAt?.subSequence(8,10)
//
//        if (list2.publishedAt.subSequence(6,7)=="1"){
//            month="January"
//        }else if (list2.publishedAt.subSequence(6,7)=="2"){
//            month="February"
//        }else if (list2.publishedAt.subSequence(6,7)=="3"){
//            month="March"
//        }else if (list2.publishedAt.subSequence(6,7)=="4"){
//            month="April"
//        }else if (list2.publishedAt.subSequence(6,7)=="5"){
//            month="May"
//        }else if (list2.publishedAt.subSequence(6,7)=="6"){
//            month="June"
//        }else if (list2.publishedAt.subSequence(6,7)=="7"){
//            month="July"
//        }else if (list2.publishedAt.subSequence(6,7)=="8"){
//            month="August"
//        }else if (list2.publishedAt.subSequence(6,7)=="9"){
//            month="September"
//        }else if (list2.publishedAt.subSequence(6,7)=="10"){
//            month="October"
//        }else if (list2.publishedAt.subSequence(6,7)=="11"){
//            month="November"
//        }else if (list2.publishedAt.subSequence(6,7)=="12"){
//            month="December"
//        }
//        bind.yearTv.text=list2.publishedAt.subSequence(0,4)
//        bind.monthTv.text=month
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}